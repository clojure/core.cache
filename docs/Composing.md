Because core.cache types are defined in terms of the `CacheProtocol` protocol and the cache functions adhere to its strictures, any cache types can serve as the basis for another.

Put in simpler terms, to create a cache instance composed of the seed data `{:a 1, :b 2}` with a FIFO eviction policy and a 5-second entry lifetime, then the following nested cache usage would work:

```clojure
(def C (-> {:a 1 :b 2}
       (fifo-cache-factory :threshold 2)
       (ttl-cache-factory  :ttl 5000)))

;; used right away
  
(assoc C :c 42)
;;=> {:b 2, :c 42}                                                                                   
  
;; used after 5 seconds                                              

(assoc C :d 138)
;;=> {:d 138}
```

What the code above does is to simply use a `FIFOCache` instance, seeded with `{:a 1, :b 2}` as the seed for a `TTLCache` instance.  As shown, within the TTL window, the cache evicts its elements using a FIFO policy.  However, once a TTL window has expired the expired elements are also evicted.
