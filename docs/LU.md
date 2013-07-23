LU cache
=========

The least-used cache (sometimes called "Least Frequently Used") is a [variant of LRU](./LRU.md) that evicts items that are used least frequently once its threshold has been exceeded.

> In simple terms, the LU cache will remove the element in the cache that has been accessed the least, regardless of time.

*Before reading this page please make sure that you've read and understand the [Basic Usage patterns](./Using.md).*

General usage
-------------

To create a core.cache `LUCache` instance you should *always* use its associated constructor function `lu-cache-factory` with an optional `:threshold` parameter:

```clojure
    (ns your.lib 
      (:require [clojure.core.cache :as cache]))
	
    (def C (cache/lu-cache-factory {} :threshold 2))
    
    (-> C (assoc :a 1) (assoc :b 2))
	;=> {:a 1, :b 2}
```

*note: the default `:threshold` value is 32*
	
At this point the cache has not yet crossed the item threshold of `2`, but if you execute yet another call the story will change:

```clojure
    (-> C (assoc :a 1) (assoc :b 2) (assoc :c 3))
	;=> {:b 2, :c 3}
```

At this point the operation of the LU cache looks exactly the same at the FIFO cache.  However, the difference becomes apparent when a given cache item is "touched":

```clojure
    (-> C (assoc :a 1) 
          (assoc :b 2)
          (.hit :b)
          (.hit :b)
          (.hit :a)       ;; ensure :a is used most recently
          (assoc :c 3))
    
    ;=> {:c 3, :b 2}
```

As you see, hitting the key `:b` twice marks it as more important that `:a` even though the latter was "touched" more recently.  That is, when the threshold is passed, the cache will expel the **L**east **U**sed element in favor of the element accessed most often.

All caveats apply regarding the [proper usage patterns](./Using.md).

LU cache use cases
------------------

The LU cache eviction policy is very simple to understand and works well in general.

### Advantages to using an LU cache

There are a few reasons why you might want to use an LU cache:

 * Performs pretty well if access patterns rarely change
 * Its logic is easy to understand
 * It's reasonably fast
 * It works well with data subject to temporal locality concerns

### Disadvantages to using an LU cache

 * It performs poorly when access patterns change
 * It requires some historical data to operate
 * It requires a larger cache to increase efficiency
 
As always, you should measure your system's characteristics to determine the best eviction strategy for your purposes.
