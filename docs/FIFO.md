# FIFO cache

A First-In-First-Out cache is one that uses queuing logic for its backing store, expunging the elements at the front of the queue when a predetermined threshold is exceeded.

> In simple terms, the FIFO cache will remove the element that has been in the cache the longest.

*Before reading this page please make sure that you've read and understand the [Basic Usage patterns](./Using.md).*

## General use

To create a core.cache `FIFOCache` instance you should *always* use its associated constructor function `fifo-cache-factory` with an optional `:threshold` parameter:

```clojure
    (ns your.lib
      (:require [clojure.core.cache :as cache]))
	
    (def C (cache/fifo-cache-factory {:a 1, :b 2, :c 3} :threshold 3))
```

*note: the default `:threshold` value is 32*

The cache instance `C` is initialized with the seed map `{:a 1, :b 2}` and a queue threshold of `3`,  For your own purposes `2` is probably too small, but it's fine for the purpose of illustration.  Since the queue threshold was set to `3` adding one more element should evict the first element added `:a`; and indeed it does:

```clojure
    (assoc C :d 42)
    ;=> {:c 3, :b 2, :d 42}
```

Likewise, adding two more elements should evict two values:

```clojure
    (assoc C :x 36 :z 138)
    ;=> {:z 138, :x 36, :b 2}
```

Like all of the implementations in core.cache, `FIFOCache` instances operate like regular maps and are immutable. All caveats apply regarding the [proper usage patterns](./Using.md).

## FIFO cache use cases

The FIFO cache eviction policy is very simple to implement and understand.  Additionally, because the policy requires very little information, the implementation is reasonably efficient.

The FIFO eviction policy is the base-level caching capability and is generally applicable.  However, because of its broad applicability it tends to evict at a rate non-optimally for every scenario.  Having said that, there are a few reasons why you might want to use a FIFO cache.

### Benefits to using a FIFO cache

 * Its logic is easy to understand
 * It's reasonably fast
 * It's reasonably lightweight
 * Even a naive cache eviction policy may prove better than none
 * Your expensive calculations tend toward single-use
 * It works well for data subject to sequentiality
 
### Disadvantages to using a FIFO cache

 * It's not efficient for data subject to locality concerns
 * Increasing the cache size does not benefit its efficiency (see [Bélády's anomaly](http://en.wikipedia.org/wiki/B%C3%A9l%C3%A1dy's_anomaly))

As always, you should measure your system's characteristics to determine the best eviction strategy for your purposes.