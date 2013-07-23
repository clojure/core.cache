TTL cache
==========

The time-to-live cache is one that evicts items that are older than a time-to-live threshold (in milliseconds).

*Before reading this page please make sure that you've read and understand the [Basic Usage patterns](./Using.md).*

General usage
-------------

To create a core.cache `TTLCache` instance you should *always* use its associated constructor function `ttl-cache-factory` with an optional `:ttl` parameter:

```clojure
    (ns your.lib 
      (:require [clojure.core.cache :as cache]))
	
    (def C (cache/ttl-cache-factory {} :ttl 1000))
    
    (-> C (assoc :a 1) (assoc :b 2))
	;=> {:a 1, :b 2}
```

*note: the default `:ttl` value is 2 seconds*

At this point the cache is fresh and younger than one second (that is, depending on how fast you read), but if you execute yet another call the story will change:

```clojure
    (def sleepy #(do (Thread/sleep %2) %))
    
    (-> C (assoc :a 1) 
	      (assoc :b 2)
		  (sleepy 1500)
	      (assoc :c 3))
	;=> {:c 3}
```

At this point the operation of the TTL cache is exposed.  As you see, sleeping in between adding the keys `:a` and `:b` causes them to be evicted on the next insertion.

All caveats apply regarding the [proper usage patterns](./Using.md).

TTL cache use cases
--------------------

The TTL cache eviction policy is very simple to understand and works well for certain scenarios.  However, because the policy requires "age" information, the implementation is somewhat subtle and moderately memory intensive.

### Advantages to using an TTL cache

There are a few reasons why you might want to use a TTL cache:

 * Its logic is easy to understand
 * It's reasonably fast
 * It works well with data subject to temporal concerns

### Disadvantages to using an TTL cache

 * It requires more historical data to operate
 * Cache size does not generally help its efficiency
 
As always, you should measure your system's characteristics to determine the best eviction strategy for your purposes.
