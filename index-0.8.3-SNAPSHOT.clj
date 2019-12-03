{:namespaces
 ({:doc "A caching library for Clojure.",
   :author "Fogus",
   :name "clojure.core.cache",
   :wiki-url "https://clojure.github.io/core.cache/index.html",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj"}
  {:doc
   "A higher level way to use clojure.core.cache that assumes the immutable\ncache is wrapped in an atom.\n\nThe API is (almost) the same as clojure.core.cache -- including the factory\nfunctions -- but instead of accepting immutable caches, the functions\nhere accept atoms containing those caches. The factory functions return\nnew atoms containing the newly created cache.\n\nIn addition, lookup-or-miss provides a safe, atomic way to retrieve a\nvalue from a cache or compute it if it is missing, without risking a\ncache stampede.",
   :name "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache/index.html#clojure.core.cache.wrapped",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->BasicCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L115",
   :line 115,
   :var-type "function",
   :arglists ([cache]),
   :doc
   "Positional factory function for class clojure.core.cache.BasicCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->BasicCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->FIFOCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L173",
   :line 173,
   :var-type "function",
   :arglists ([cache q limit]),
   :doc
   "Positional factory function for class clojure.core.cache.FIFOCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->FIFOCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->FnCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L135",
   :line 135,
   :var-type "function",
   :arglists ([cache f]),
   :doc
   "Positional factory function for class clojure.core.cache.FnCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->FnCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->LIRSCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L437",
   :line 437,
   :var-type "function",
   :arglists ([cache lruS lruQ tick limitS limitQ]),
   :doc
   "Positional factory function for class clojure.core.cache.LIRSCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->LIRSCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->LRUCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L214",
   :line 214,
   :var-type "function",
   :arglists ([cache lru tick limit]),
   :doc
   "Positional factory function for class clojure.core.cache.LRUCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->LRUCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->LUCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L316",
   :line 316,
   :var-type "function",
   :arglists ([cache lu limit]),
   :doc
   "Positional factory function for class clojure.core.cache.LUCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->LUCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->SoftCache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L522",
   :line 522,
   :var-type "function",
   :arglists ([cache rcache rq]),
   :doc
   "Positional factory function for class clojure.core.cache.SoftCache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->SoftCache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "->TTLCacheQ",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L272",
   :line 272,
   :var-type "function",
   :arglists ([cache ttl q gen ttl-ms]),
   :doc
   "Positional factory function for class clojure.core.cache.TTLCacheQ.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/->TTLCacheQ"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "basic-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L581",
   :line 581,
   :var-type "function",
   :arglists ([base]),
   :doc "Returns a pluggable basic cache initialied to `base`",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/basic-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "fifo-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L587",
   :line 587,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns a FIFO cache with the cache and FIFO queue initialized to `base` --\nthe queue is filled as the values are pulled out of `base`.  If the associative\nstructure can guarantee ordering, then the said ordering will define the\neventual eviction order.  Otherwise, there are no guarantees for the eventual\neviction ordering.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the FIFO semantics apply (default is 32).\n\nIf the number of elements in `base` is greater than the limit then some items\nin `base` will be dropped from the resulting cache.  If the associative\nstructure used as `base` can guarantee sorting, then the last `limit` elements\nwill be used as the cache seed values.  Otherwise, there are no guarantees about\nthe elements in the resulting cache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/fifo-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "lirs-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L640",
   :line 640,
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
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/lirs-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "lru-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L608",
   :line 608,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LRU cache with the cache and usage-table initialied to `base` --\neach entry is initialized with the same usage value.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LRU semantics apply (default is 32).",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/lru-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "lu-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L630",
   :line 630,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LU cache with the cache and usage-table initialied to `base`.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LU semantics apply (default is 32).",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/lu-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "soft-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L651",
   :line 651,
   :var-type "function",
   :arglists ([base]),
   :doc
   "Returns a SoftReference cache.  Cached values will be referred to with\nSoftReferences, allowing the values to be garbage collected when there is\nmemory pressure on the JVM.\n\nSoftCache is a mutable cache, since it is always based on a\nConcurrentHashMap.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/soft-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "through",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L44",
   :line 44,
   :var-type "function",
   :arglists
   ([cache item] [value-fn cache item] [wrap-fn value-fn cache item]),
   :doc
   "The basic hit/miss logic for the cache system.  Expects a wrap function and\nvalue function.  The wrap function takes the value function and the item in question\nand is expected to run the value function with the item whenever a cache\nmiss occurs.  The intent is to hide any cache-specific cells from leaking\ninto the cache logic itelf.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/through"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "through-cache",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L57",
   :line 57,
   :var-type "function",
   :arglists
   ([cache item] [cache item value-fn] [cache item wrap-fn value-fn]),
   :doc
   "The basic hit/miss logic for the cache system.  Like through but always has\nthe cache argument in the first position for easier use with swap! etc.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/through-cache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "ttl-cache-factory",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L619",
   :line 619,
   :var-type "function",
   :arglists ([base & {ttl :ttl, :or {ttl 2000}}]),
   :doc
   "Returns a TTL cache with the cache and expiration-table initialized to `base` --\neach with the same time-to-live.\n\nThis function also allows an optional `:ttl` argument that defines the default\ntime in milliseconds that entries are allowed to reside in the cache.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/ttl-cache-factory"}
  {:name "BasicCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/BasicCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "FIFOCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/FIFOCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "FnCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/FnCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LIRSCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/LIRSCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LRUCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/LRUCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "LUCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/LUCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "SoftCache",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/SoftCache",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:name "TTLCacheQ",
   :var-type "type",
   :namespace "clojure.core.cache",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/TTLCacheQ",
   :source-url nil,
   :raw-source-url nil,
   :file nil}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj",
   :name "CacheProtocol",
   :file "src/main/clojure/clojure/core/cache.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/5b8474a532a7f12ca1a1fbbf8f82a6f816c16b29/src/main/clojure/clojure/core/cache.clj#L20",
   :line 20,
   :var-type "protocol",
   :arglists nil,
   :doc "This is the protocol describing the basic cache capability.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/CacheProtocol"}
  {:raw-source-url nil,
   :name "evict",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache e]),
   :doc "Removes an entry from the cache",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/evict"}
  {:raw-source-url nil,
   :name "has?",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache e]),
   :doc "Checks if the cache contains a value associated with `e`",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/has?"}
  {:raw-source-url nil,
   :name "hit",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache e]),
   :doc
   "Is meant to be called if the cache is determined to contain a value\nassociated with `e`",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/hit"}
  {:raw-source-url nil,
   :name "lookup",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache e] [cache e not-found]),
   :doc
   "Retrieve the value associated with `e` if it exists, else `nil` in\nthe 2-arg case.  Retrieve the value associated with `e` if it exists,\nelse `not-found` in the 3-arg case.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/lookup"}
  {:raw-source-url nil,
   :name "miss",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache e ret]),
   :doc
   "Is meant to be called if the cache is determined to **not** contain a\nvalue associated with `e`",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/miss"}
  {:raw-source-url nil,
   :name "seed",
   :file nil,
   :source-url nil,
   :var-type "function",
   :arglists ([cache base]),
   :doc
   "Is used to signal that the cache should be created with a seed.\nThe contract is that said cache should return an instance of its\nown type.",
   :namespace "clojure.core.cache",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache/seed"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "basic-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L130",
   :line 130,
   :var-type "function",
   :arglists ([base]),
   :doc "Returns a pluggable basic cache initialied to `base`",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/basic-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "evict",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L95",
   :line 95,
   :var-type "function",
   :arglists ([cache-atom e]),
   :doc
   "Removes an entry from the cache.\n\nReturns the updated cache from the atom.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/evict"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "fifo-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L135",
   :line 135,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns a FIFO cache with the cache and FIFO queue initialized to `base` --\nthe queue is filled as the values are pulled out of `base`.  If the associative\nstructure can guarantee ordering, then the said ordering will define the\neventual eviction order.  Otherwise, there are no guarantees for the eventual\neviction ordering.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the FIFO semantics apply (default is 32).\n\nIf the number of elements in `base` is greater than the limit then some items\nin `base` will be dropped from the resulting cache.  If the associative\nstructure used as `base` can guarantee sorting, then the last `limit` elements\nwill be used as the cache seed values.  Otherwise, there are no guarantees about\nthe elements in the resulting cache.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/fifo-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "has?",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L72",
   :line 72,
   :var-type "function",
   :arglists ([cache-atom e]),
   :doc
   "Checks if the cache contains a value associated with `e`.\n\nReads from the current version of the atom.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/has?"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "hit",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L79",
   :line 79,
   :var-type "function",
   :arglists ([cache-atom e]),
   :doc
   "Is meant to be called if the cache is determined to contain a value\nassociated with `e`.\n\nReturns the updated cache from the atom. Provided for completeness.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/hit"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "lirs-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L179",
   :line 179,
   :var-type "function",
   :arglists
   ([base
     &
     {:keys [s-history-limit q-history-limit],
      :or {s-history-limit 32, q-history-limit 32}}]),
   :doc
   "Returns an LIRS cache with the S & R LRU lists set to the indicated\nlimits.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/lirs-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "lookup",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L25",
   :line 25,
   :var-type "function",
   :arglists ([cache-atom e] [cache-atom e not-found]),
   :doc
   "Retrieve the value associated with `e` if it exists, else `nil` in\nthe 2-arg case.  Retrieve the value associated with `e` if it exists,\nelse `not-found` in the 3-arg case.\n\nReads from the current version of the atom.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/lookup"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "lookup-or-miss",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L38",
   :line 38,
   :var-type "function",
   :arglists ([cache-atom e value-fn] [cache-atom e wrap-fn value-fn]),
   :doc
   "Retrieve the value associated with `e` if it exists, else compute the\nvalue (using value-fn, and optionally wrap-fn), update the cache for `e`\nand then perform the lookup again.\n\nvalue-fn (and wrap-fn) will only be called (at most) once even in the\ncase of retries, so there is no risk of cache stampede.\n\nSince lookup can cause invalidation in some caches (such as TTL), we\ntrap that case and retry (a maximum of ten times).",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/lookup-or-miss"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "lru-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L153",
   :line 153,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LRU cache with the cache and usage-table initialied to `base` --\neach entry is initialized with the same usage value.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LRU semantics apply (default is 32).",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/lru-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "lu-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L171",
   :line 171,
   :var-type "function",
   :arglists ([base & {threshold :threshold, :or {threshold 32}}]),
   :doc
   "Returns an LU cache with the cache and usage-table initialied to `base`.\n\nThis function takes an optional `:threshold` argument that defines the maximum number\nof elements in the cache before the LU semantics apply (default is 32).",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/lu-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "miss",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L87",
   :line 87,
   :var-type "function",
   :arglists ([cache-atom e ret]),
   :doc
   "Is meant to be called if the cache is determined to **not** contain a\nvalue associated with `e`.\n\nReturns the updated cache from the atom. Provided for completeness.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/miss"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "seed",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L102",
   :line 102,
   :var-type "function",
   :arglists ([cache-atom base]),
   :doc
   "Is used to signal that the cache should be created with a seed.\nThe contract is that said cache should return an instance of its\nown type.\n\nReturns the updated cache from the atom. Provided for completeness.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/seed"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "soft-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L189",
   :line 189,
   :var-type "function",
   :arglists ([base]),
   :doc
   "Returns a SoftReference cache.  Cached values will be referred to with\nSoftReferences, allowing the values to be garbage collected when there is\nmemory pressure on the JVM.\n\nSoftCache is a mutable cache, since it is always based on a\nConcurrentHashMap.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/soft-cache-factory"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "through",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L111",
   :line 111,
   :var-type "function",
   :arglists
   ([cache-atom item]
    [value-fn cache-atom item]
    [wrap-fn value-fn cache-atom item]),
   :doc
   "The basic hit/miss logic for the cache system.  Expects a wrap function and\nvalue function.  The wrap function takes the value function and the item in question\nand is expected to run the value function with the item whenever a cache\nmiss occurs.  The intent is to hide any cache-specific cells from leaking\ninto the cache logic itelf.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/through"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "through-cache",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L122",
   :line 122,
   :var-type "function",
   :arglists
   ([cache-atom item]
    [cache-atom item value-fn]
    [cache-atom item wrap-fn value-fn]),
   :doc
   "The basic hit/miss logic for the cache system.  Like through but always has\nthe cache argument in the first position.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/through-cache"}
  {:raw-source-url
   "https://github.com/clojure/core.cache/raw/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj",
   :name "ttl-cache-factory",
   :file "src/main/clojure/clojure/core/cache/wrapped.clj",
   :source-url
   "https://github.com/clojure/core.cache/blob/68c317bad2706267a63d024fe3bb5aaf5c1b7b75/src/main/clojure/clojure/core/cache/wrapped.clj#L162",
   :line 162,
   :var-type "function",
   :arglists ([base & {ttl :ttl, :or {ttl 2000}}]),
   :doc
   "Returns a TTL cache with the cache and expiration-table initialized to `base` --\neach with the same time-to-live.\n\nThis function also allows an optional `:ttl` argument that defines the default\ntime in milliseconds that entries are allowed to reside in the cache.",
   :namespace "clojure.core.cache.wrapped",
   :wiki-url
   "https://clojure.github.io/core.cache//index.html#clojure.core.cache.wrapped/ttl-cache-factory"})}
