;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns ^{:doc "A caching library for Clojure."
      :author "Fogus"}
  clojure.core.cache)

;; # Protocols and Types

(defprotocol CacheProtocol
  "This is the protocol describing the basic cache capability."
  (lookup  [cache e]
   "Retrieve the value associated with `e` if it exists")
  (has?    [cache e]
   "Checks if the cache contains a value associtaed with `e`")
  (hit     [cache e]
   "Is meant to be called if the cache is determined to contain a value
   associated with `e`")
  (miss    [cache e ret]
   "Is meant to be called if the cache is determined to **not** contain a
   value associated with `e`")
  (evict  [cache e]
   "Removes an entry from the cache")
  (seed    [cache base]
   "Is used to signal that the cache should be created with a seed.
   The contract is that said cache should return an instance of its
   own type.")
  (-base   [cache]
   "Used to grab the underlying storage struct."))


(defmacro defcache
  [type-name fields & specifics]
  (let [[base-field & _] fields]
    `(deftype ~type-name [~@fields]
       ~@specifics
     
       clojure.lang.ILookup
       (valAt [this# key#]
              (lookup this# key#))
       (valAt [this# key# not-found#]
              (if (has? this# key#)
                (lookup this# key#)
                not-found#))

       clojure.lang.IPersistentMap
       (assoc [this# k# v#]
         (miss this# k# v#))
       (without [this# k#]
         (evict this# k#))

       clojure.lang.Associative
       (containsKey [this# k#]
         (has? this# k#))
       (entryAt [this# k#]
         (when (has? this# k#)
           (clojure.lang.MapEntry. k# (lookup this# k#))))

       clojure.lang.Counted
       (count [this#]
         (clojure.core/count ~base-field))

       clojure.lang.IPersistentCollection
       (cons [_# elem#]
         (clojure.core/cons ~base-field elem#))
       (empty [this#]
         (seed this# (empty ~base-field)))
       (equiv [_# other#]
         (.equiv ~base-field other#))

       clojure.lang.Seqable
       (seq [_#]
         (seq ~base-field))

       ;; Java interfaces
       java.lang.Iterable
       (iterator [this#] (.iterator ~base-field)))))


(defcache BasicCache [cache]
  CacheProtocol
  (lookup [_ item]
    (get cache item))
  (has? [_ item]
    (contains? cache item))
  (hit [this item] this)
  (miss [_ item result]
    (BasicCache. (assoc cache item result)))
  (evict [_ key]
    (BasicCache. (dissoc cache key)))
  (seed [_ base]
    (BasicCache. base))
  Object
  (toString [_] (str cache)))


(defcache FIFOCache [cache q limit]
  CacheProtocol
  (lookup [_ item]
    (get cache item))
  (has? [_ item]
    (contains? cache item))
  (hit [this item]
    this)
  (miss [_ item result]
    (let [k (peek q)]
      (FIFOCache. (-> cache (dissoc k) (assoc item result))
                  (-> q pop (conj item))
                  limit)))
  (evict [_ key]
    (let [v (get cache key ::miss)]
      nil))
  (seed [_ base]
    (FIFOCache. base
                (into clojure.lang.PersistentQueue/EMPTY
                      (repeat limit ::free))
                limit))
  Object
  (toString [_]
    (str cache \, \space (pr-str q))))


(defcache LRUCache [cache lru tick limit]
  CacheProtocol
  (lookup [_ item]
    (get cache item))
  (has? [_ item]
    (contains? cache item))
  (hit [_ item]
    (let [tick+ (inc tick)]
      (LRUCache. cache
                 (assoc lru item tick+)
                 tick+
                 limit)))
  (miss [_ item result]
    (let [tick+ (inc tick)
          k (apply min-key lru (keys lru))]
      (LRUCache. (-> cache (dissoc k) (assoc item result))
                 (-> lru (dissoc k) (assoc item tick+))
                 tick+
                 limit)))
  (seed [_ base]
    (LRUCache. base
               (into {} (for [x (range (- limit) 0)] [x x]))
               0
               limit))
  Object
  (toString [_]
    (str cache \, \space lru \, \space tick \, \space limit)))


(declare key-killer)

(defcache TTLCache [cache ttl limit]
  CacheProtocol
  (lookup [_ item]
    (get cache item))
  (has? [_ item]
    (when-let [t (get ttl item)]
      (< (- (System/currentTimeMillis)
            t)
         limit)))
  (hit [this item] this)
  (miss [this item result]
    (let [now  (System/currentTimeMillis)
          kill-old (key-killer ttl limit now)]
      (TTLCache. (assoc (kill-old cache) item result)
                 (assoc (kill-old ttl) item now)
                 limit)))
  (seed [_ base]
    (let [now (System/currentTimeMillis)]
      (TTLCache. base
                 (into {} (for [x base] [(key x) now]))
                 limit)))
  Object
  (toString [_]
    (str cache \, \space ttl \, \space limit)))


(defn- key-killer
  [ttl limit now]
  (let [ks (map key (filter #(> (- now (val %)) limit)
                            ttl))]
    #(apply dissoc % ks)))


(defcache LUCache [cache lu limit]
  CacheProtocol
  (lookup [_ item]
    (get cache item))
  (has? [_ item]
    (contains? cache item))
  (hit [_ item]
    (LUCache. cache (update-in lu [item] inc) limit))
  (miss [_ item result]
    (let [k (apply min-key lu (keys lu))]
      (LUCache. (-> cache (dissoc k) (assoc item result))
                (-> lu (dissoc k) (assoc item 0))
                limit)))
  (seed [_ base]
    (LUCache. base
              (into {} (for [x (range (- limit) 0)] [x x]))
              limit))
  Object
  (toString [_]
    (str cache \, \space lu \, \space limit)))

;; Factories

(defn basic-cache-factory
  "Returns a pluggable basic cache initialied to `base`"
  [base]
  {:pre [(map? base)]}
  (BasicCache. base))

(defn fifo-cache-factory
  "Returns a pluggable FIFO cache with the cache and FIFO queue initialied to `base` --
   the queue is filled as the values are pulled out of `seq`. (maybe this should be
   randomized?)"
  [limit base]
  {:pre [(number? limit) (< 0 limit)
         (map? base)]}
  (clojure.core.cache/seed (FIFOCache. {} clojure.lang.PersistentQueue/EMPTY limit) base))

(defn lru-cache-factory
  "Returns a pluggable LRU cache with the cache and usage-table initialied to `base` --
   each entry is initialized with the same usage value. (maybe this should be
   randomized?)"
  [limit base]
  {:pre [(number? limit) (< 0 limit)
         (map? base)]}
  (clojure.core.cache/seed (LRUCache. {} {} 0 limit) base))

(defn ttl-cache-factory
  "Returns a pluggable TTL cache with the cache and expiration-table initialied to `base` --
   each with the same time-to-live."
  [ttl base]
  {:pre [(number? ttl) (<= 0 ttl)
         (map? base)]}
  (TTLCache. base {} ttl))

(defn lu-cache-factory
  "Returns a pluggable LU cache with the cache and usage-table initialied to `base`."
  [limit base]
  {:pre [(number? limit) (< 0 limit)
         (map? base)]}
  (clojure.core.cache/seed (LUCache. {} {} limit) base))
