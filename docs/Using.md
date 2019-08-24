# Using core.cache

*note: see the page on [including core.cache](./Including.md) before you begin this section*

## Basic usage pattern

To use the cache implementations or extend the core.cache protocols you first need to require the proper namespace:

```clojure
(require '[clojure.core.cache :as cache])
```

Next you should create an instance of a specific cache type, optionally seeded:

```clojure
(def C (cache/fifo-cache-factory {:a 1, :b 2}))
```

To find a value in a map by its key you have a couple choices:

```clojure
(cache/lookup C :a)
;=> 1

(:b C)
;=> 2
```

To ensure the proper cache policies are followed for each specific type, the following `has?/hit/miss` pattern should be used:

```clojure
(if (cache/has? C :c)     ;; has? checks that the cache contains an item
  (cache/hit C :c)        ;; hit returns a cache with any relevant internal information updated
  (cache/miss C :c 42))   ;; miss returns a new cache with the new item and without evicted entries

;=> {:a 1, :b 2, :c 42}
```

Using the `has?/hit/miss` pattern ensures that the thresholding and eviction logic for each implementation works properly. It is built into the `through` and `through-cache` functions, as well as `clojure.core.cache.wrapped/lookup-or-miss`.  **Avoid this pattern at your own risk.**

Finally, to explicitly evict an element in a cache, use the `evict` function:

```clojure
(cache/evict C :b)

;=> {:a 1}
```

For specific information about eviction policies and thresholds, view the specific documentation for each cache type listed in the next section.

## Builtin cache implementations

core.cache comes with a number of builtin immutable cache implementations, including (*click through for specific information*):

* [FIFO cache](./FIFO.md)
* [LRU cache](./LRU.md)
* [LU cache](./LU.md)
* [TTL cache](./TTL.md)
* [LIRS cache](./LIRS.md)
* Function-backed cache (work in progress)
* Soft-reference cache (work in progress)

The core.cache implementations are backed by any map-like object.  Additionally, each cache implements the Clojure map behaviors and can therefore serve as special maps or even as backing stores for other cache implementations.  For caches taking a limit argument, the eviction policies tend not to apply until the limit has been exceeded.

## Extending core.cache

See the section [on creating custom caches](./Extending.md) for more information.

## Nesting cache types

See the section [on composing caches](./Composing.md) for more information.
