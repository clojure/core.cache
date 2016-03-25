{:namespaces
 ({:doc "A caching library for Clojure.",
   :author "Fogus",
   :name "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache/clojure.core.cache-api.html",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->BasicCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L100",
   :line 100,
   :var-type "function",
   :arglists ([cache]),
   :doc
   "Positional factory function for class clojure.core.cache.BasicCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->BasicCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->FIFOCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L160",
   :line 160,
   :var-type "function",
   :arglists ([cache q limit]),
   :doc
   "Positional factory function for class clojure.core.cache.FIFOCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->FIFOCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->FnCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L120",
   :line 120,
   :var-type "function",
   :arglists ([cache f]),
   :doc
   "Positional factory function for class clojure.core.cache.FnCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->FnCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->LIRSCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L409",
   :line 409,
   :var-type "function",
   :arglists ([cache lruS lruQ tick limitS limitQ]),
   :doc
   "Positional factory function for class clojure.core.cache.LIRSCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->LIRSCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->LRUCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L201",
   :line 201,
   :var-type "function",
   :arglists ([cache lru tick limit]),
   :doc
   "Positional factory function for class clojure.core.cache.LRUCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->LRUCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->LUCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L288",
   :line 288,
   :var-type "function",
   :arglists ([cache lu limit]),
   :doc
   "Positional factory function for class clojure.core.cache.LUCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->LUCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->SoftCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L493",
   :line 493,
   :var-type "function",
   :arglists ([cache rcache rq]),
   :doc
   "Positional factory function for class clojure.core.cache.SoftCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->SoftCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "->TTLCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L253",
   :line 253,
   :var-type "function",
   :arglists ([cache ttl ttl-ms]),
   :doc
   "Positional factory function for class clojure.core.cache.TTLCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/->TTLCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "basic-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L551",
   :line 551,
   :var-type "function",
   :arglists ([base]),
   :doc "Returns a pluggable basic cache initialied to `base`",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/basic-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "fifo-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L557",
   :line 557,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns a FIFO cache with the cache and FIFO queue initialized to `base` --\nthe queue is filled as the values are pulled out of `base`.  If the associative\nstructure can guarantee ordering, then the said ordering will define the\neventual eviction order.  Otherwise, there are no guarantees for the eventual\neviction ordering.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the FIFO semantics apply (default is 32).\n\nIf the number of elements in `base` is greater than the limit then some items\nin `base` will be dropped from the resulting cache.  If the associative\nstructure used as `base` can guarantee sorting, then the last `limit` elements\nwill be used as the cache seed values.  Otherwise, there are no guarantees about\nthe elements in the resulting cache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/fifo-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "lirs-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L610",
   :line 610,
   :var-type "function",
   :arglists
   ([base
     &
     {:keys [s-history-limit q-history-limit],
      :or {s-history-limit 32, q-history-limit 32}}]),
   :doc
   "Returns an LIRS cache with the S & R LRU lists set to the indicated\nlimits.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lirs-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "lru-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L578",
   :line 578,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LRU cache with the cache and usage-table initialied to `base` --\neach entry is initialized with the same usage value.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LRU semantics apply (default is 32).",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lru-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "lu-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L600",
   :line 600,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LU cache with the cache and usage-table initialied to `base`.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LU semantics apply (default is 32).",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lu-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "soft-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L621",
   :line 621,
   :var-type "function",
   :arglists ([base]),
   :doc
   "Returns a SoftReference cache.  Cached values will be referred to with\nSoftReferences, allowing the values to be garbage collected when there is\nmemory pressure on the JVM.\n\nSoftCache is a mutable cache, since it is always based on a\nConcurrentHashMap.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/soft-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "through",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L44",
   :line 44,
   :var-type "function",
   :arglists
   ([cache item] [value-fn cache item] [wrap-fn value-fn cache item]),
   :doc
   "The basic hit/miss logic for the cache system.  Expects a wrap function and\nvalue function.  The wrap function takes the value function and the item in question\nand is expected to run the value function with the item whenever a cache\nmiss occurs.  The intent is to hide any cache-specific cells from leaking\ninto the cache logic itelf.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/through"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "ttl-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L589",
   :line 589,
   :var-type "function",
   :arglists ([base & {ttl :ttl, :or {ttl 2000}}]),
   :doc
   "Returns a TTL cache with the cache and expiration-table initialized to `base` --\neach with the same time-to-live.\n\nThis function also allows an optional `:ttl` argument that defines the default\ntime in milliseconds that entries are allowed to reside in the cache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/ttl-cache-factory"}
  {:name "BasicCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/BasicCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "FIFOCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/FIFOCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "FnCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/FnCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LIRSCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LIRSCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LRUCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LRUCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LUCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/LUCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "SoftCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/SoftCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "TTLCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/TTLCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj",
   :name "CacheProtocol",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/aab34676929c0d08eeb28e66d1233333c1a78aec/src/main/clojure/clojure/core/cache.clj#L20",
   :line 20,
   :var-type "protocol",
   :arglists nil,
   :doc "This is the protocol describing the basic cache capability.",
   :namespace "clojure.core.cache",
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/CacheProtocol"}
  {:name "evict",
   :doc "Removes an entry from the cache",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache e]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/evict",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "has?",
   :doc "Checks if the cache contains a value associated with `e`",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache e]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/has?",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "hit",
   :doc
   "Is meant to be called if the cache is determined to contain a value\nassociated with `e`",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache e]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/hit",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "lookup",
   :doc
   "Retrieve the value associated with `e` if it exists, else `nil` in\nthe 2-arg case.  Retrieve the value associated with `e` if it exists,\nelse `not-found` in the 3-arg case.",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache e] [cache e not-found]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/lookup",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "miss",
   :doc
   "Is meant to be called if the cache is determined to **not** contain a\nvalue associated with `e`",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache e ret]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/miss",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "seed",
   :doc
   "Is used to signal that the cache should be created with a seed.\nThe contract is that said cache should return an instance of its\nown type.",
   :var-type "function",
   :namespace "clojure.core.cache",
   :arglists ([cache base]),
   :wiki-url
   "http://clojure.github.com/core.cache//clojure.core.cache-api.html#clojure.core.cache/seed",
   :source-url nil,
   :raw-source-url nil,
   :file nil})}
