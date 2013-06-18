Creating custom caches
======================

This page will guide you through the steps required to create your own custom cache types.  In this tutorial you will create a naive cache type `LameCache` with a very straight-forward and illustrative eviction policy.

The details of the implementation are as follows:
 * `LameCache` should work like a map
 * Its eviction policy is semi-random
 * It allows a threshold

CacheProtocol
-------------

The best place to start when attempting to create your own cache implementations with core.cache is with the `CacheProtocol`:

```clojure
(defprotocol CacheProtocol
  "This is the protocol describing the basic cache capability."
  (lookup [cache e]
          [cache e not-found]
   "Retrieve the value associated with `e` if it exists, else `nil` in
   the 2-arg case.  Retrieve the value associated with `e` if it exists,
   else `not-found` in the 3-arg case.")
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
   own type."))
```

The commentary on the cache protocol is fairly straight-forward, but there are subtlties in play that I will discuss herein.  

The defcache convenience macro
------------------------------

The core.cache library provides a convenience macro for defining cache implementations called `defcache`.  The advantage that `defcache` provides is that by implementing the `CacheProtocol` protocol your caches will automatically implement Clojure's associative data structure protocols as well.  The `defcache` does this by implementing the associative behaviors in terms of the `CacheProtocol`.  

*All caveats apply regarding the [proper usage patterns](./Using).*

Implementing a custom cache
---------------------------

Therefore, to implement a version of `LameCache`, the `defcache` usage is as follows:

```clojure
(defcache LameCache [cache ks threshold]
  CacheProtocol
```

The first step is to name the type and to provide its attributes:

* `cache`: The base storage structure
  - Should be an associative structure
  - **Must** be the first attribute listed
* `ks`: A set of keys stored
* `threshold`: The threshold defining the point when eviction policies take effect

```clojure
  (lookup [_ item]
    (get cache item))
  (lookup [_ item not-found]
    (get cache item not-found))
```

The `lookup` method is straight-forward. Simply retrieve the item at the given key from the base `cache`.

```clojure
  (has? [_ item]
    (contains? cache item))
```

The `has?` method is likewise straight-forward. Simply return `true` if a key is located in the base `cache`; `false` otherwise.

```clojure
  (hit [this item] this)
```

The `hit` method in this case is trivial, it just returns the instance itself.  If your cache implementation needs to track hit history then you would probably return a new instance with history updated.

```clojure
  (miss [_ item result]
    (let [size (count cache)]
      (if (<= size threshold)
        (LameCache. (assoc cache item result)
                    (conj ks item)
                    threshold)
        (let [new-cache (dissoc cache (first ks))
              new-keys  (dissoc ks item)]
          (LameCache. (assoc new-cache item result)
                      (conj item new-keys)
                      threshold)))))
```

The `miss` method is where all the action takes place.  That is, if the size of the base `cache` is less than the `threshold` then the cached value is staored in the base `cache` and its key in the `ks` set.  However, if the threshold was breached then the first key in the `ks` set is removed from the base `cache` and `ks` and a new `LameCache` instance is returned with the new key and value added to `cache` and `ks`.

```clojure
  (evict [_ key]
    (LameCache. (dissoc cache key)
                (dissoc ks key)
                threshold))
```

The `evict` method purges the value from the base `cache` and its key from `ks`, returning a new `LameCache` instance.

```clojure
  (seed [_ base]
    (LameCache. base
                (set (keys base))
                threshold))
```

The `seed` function is meant to populate the cache with a set of known values.  For `LameCache` the seed forms the base `cache` and its keys the `ks`.  Seeding a cache is often a delicate matter and your custom caches may require some thought.

```clojure
  Object
  (toString [_]
    (str cache)))
```

Finally, `LameCache` is given a lame `toString` method.

