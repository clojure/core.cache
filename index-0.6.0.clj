{:namespaces
 ({:source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache/clojure.core.cache-api.html",
   :name "clojure.core.cache",
   :author "Fogus",
   :doc "A caching library for Clojure."}),
 :vars
 ({:arglists ([base]),
   :name "basic-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L463",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/basic-cache-factory",
   :doc "Returns a pluggable basic cache initialied to `base`",
   :var-type "function",
   :line 463,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:arglists ([base & {limit :limit, :or {limit 32}}]),
   :name "fifo-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L469",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/fifo-cache-factory",
   :doc
   "Returns a FIFO cache with the cache and FIFO queue initialized to `base` --\nthe queue is filled as the values are pulled out of `base`.  If the associative\nstructure can guarantee ordering, then the said ordering will define the\neventual eviction order.  Otherwise, there are no guarantees for the eventual\neviction ordering.\n\nIf the number of elements in `base` is greater than the limit then some items\nin `base` will be dropped from the resulting cache.  If the associative\nstructure used as `base` can guarantee sorting, then the last `limit` elements\nwill be used as the cache seed values.  Otherwise, there are no guarantees about\nthe elements in the resulting cache.",
   :var-type "function",
   :line 469,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:arglists
   ([base
     &
     {:keys [s-history-limit q-history-limit],
      :or {s-history-limit 32, q-history-limit 32}}]),
   :name "lirs-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L511",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lirs-cache-factory",
   :doc
   "Returns an LIRS cache with the S & R LRU lists set to the indicated\nlimts.",
   :var-type "function",
   :line 511,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:arglists ([base & {limit :limit, :or {limit 32}}]),
   :name "lru-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L487",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lru-cache-factory",
   :doc
   "Returns an LRU cache with the cache and usage-table initialied to `base` --\neach entry is initialized with the same usage value. (maybe this should be\nrandomized?)",
   :var-type "function",
   :line 487,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:arglists ([base & {limit :limit, :or {limit 32}}]),
   :name "lu-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L504",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lu-cache-factory",
   :doc
   "Returns an LU cache with the cache and usage-table initialied to `base`.",
   :var-type "function",
   :line 504,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:arglists ([base & {ttl :ttl, :or {ttl 2000}}]),
   :name "ttl-cache-factory",
   :namespace "clojure.core.cache",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L496",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/ttl-cache-factory",
   :doc
   "Returns a TTL cache with the cache and expiration-table initialied to `base` --\neach with the same time-to-live.",
   :var-type "function",
   :line 496,
   :file "src/main/clojure/clojure/core/cache.clj"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/BasicCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "BasicCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/FIFOCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "FIFOCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/FnCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "FnCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LIRSCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "LIRSCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LRUCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "LRUCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LUCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "LUCache"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/TTLCache",
   :namespace "clojure.core.cache",
   :var-type "type",
   :name "TTLCache"}
  {:file "src/main/clojure/clojure/core/cache.clj",
   :raw-source-url
   "https://github.com/clojure/core.cache/raw/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5751b7e8d8d2f10c87b8a79c8ed9b0324368514d/src/main/clojure/clojure/core/cache.clj#L15",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/CacheProtocol",
   :namespace "clojure.core.cache",
   :line 15,
   :var-type "protocol",
   :doc "This is the protocol describing the basic cache capability.",
   :name "CacheProtocol"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/evict",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache e]),
   :doc "Removes an entry from the cache",
   :name "evict"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/has?",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache e]),
   :doc "Checks if the cache contains a value associtaed with `e`",
   :name "has?"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/hit",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache e]),
   :doc
   "Is meant to be called if the cache is determined to contain a value\nassociated with `e`",
   :name "hit"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lookup",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache e] [cache e not-found]),
   :doc
   "Retrieve the value associated with `e` if it exists, else `nil` in\nthe 2-arg case.  Retrieve the value associated with `e` if it exists,\nelse `not-found` in the 3-arg case.",
   :name "lookup"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/miss",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache e ret]),
   :doc
   "Is meant to be called if the cache is determined to **not** contain a\nvalue associated with `e`",
   :name "miss"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/seed",
   :namespace "clojure.core.cache",
   :var-type "function",
   :arglists ([cache base]),
   :doc
   "Is used to signal that the cache should be created with a seed.\nThe contract is that said cache should return an instance of its\nown type.",
   :name "seed"})}
