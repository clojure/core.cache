LRU cache
==========

The least-recently-used cache is one that evicts items that are accessed least frequently once its threshold has been exceeded.

> In simple terms, the LRU cache will remove the element in the cache that has not been accessed in the longest time.

*Before reading this page please make sure that you've read and understand the [Basic Usage patterns](./Using.md).*

General usage
-------------

To create a core.cache `LRUCache` instance you should *always* use its associated constructor function `lru-cache-factory` with an optional `:threshold` parameter:

```clojure
    (ns your.lib 
      (:require [clojure.core.cache :as cache]))
	
    (def C (cache/lru-cache-factory {} :threshold 2))
    
    (-> C (assoc :a 1) (assoc :b 2))
	;=> {:a 1, :b 2}
```

*note: the default `:threshold` value is 32*

At this point the cache has not yet crossed the set threshold of `2`, but if you execute yet another call the story will change:

```clojure
    (-> C (assoc :a 1) (assoc :b 2) (assoc :c 3))
	;=> {:b 2, :c 3}
```

At this point the operation of the LRU cache looks exactly the same at the FIFO cache.  However, the difference becomes apparent when a given cache item is "touched":

```clojure
    (-> C (assoc :a 1) 
          (assoc :b 2) 
          (.hit :a)       ;; ensure :a is used most recently
          (assoc :c 3))
    
    ;=> {:a 1, :c 3}
```

As you see, hitting the element at the key `:a` will expose the LRU nature of the underlying cache.  That is, when the threshold is passed, the cache will expel the **L**east **R**ecently **U**sed element in favor of the new.  In this base case the items accessed most recetly were `:c` and `:a`.

Like all of the implementations in core.cache, `LRUCache` instances operate like regular maps and are immutable. All caveats apply regarding the [proper usage patterns](./Using.md).

LRU cache use case
------------------

The LRU cache eviction policy is very simple to understand and works well in general.  However, because the policy requires "age" information, the implementation is somewhat subtle and moderately memory intensive.

### Advantages to using an LRU cache

There are a few reasons why you might want to use a LRU cache:

 * Its logic is easy to understand
 * It's reasonably fast
 * It's generally efficient
 * It works well with data subject to locality concerns
 * It generally performs better as the cache size increases
 * Is fairly agile to catch up with changing access patterns

### Disadvantages to using an LRU cache

 * Tends to perform poorly when elements files are accessed occassionally but consistently while other elements are accessed very frequently for a short duration and never accessed again
 * It requires more historical data to operate
 * It requires a larger cache to increase efficiency
 
As always, you should measure your system's characteristics to determine the best eviction strategy for your purposes.
