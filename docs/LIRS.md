LIRS cache
==========

The low inter-reference recency set cache is one that, like [LRU](./LRU), uses recency as its basis for behavior.  Unlike, LRU however, LIRS uses access recency of other cache elements relative to any other block to determine its eviction policy.

*Before reading this page please make sure that you've read and understand the [Basic Usage patterns](./Using).*

General usage
-------------

To create a core.cache `LRUCache` instance you can do the following:

```clojure
    (ns your.lib 
      (:require [clojure.core.cache :as cache]))
	
    (def C (cache/lirs-cache-factory {}))
```

Most of the trival examples will likely look very similar to the examples found in the [LRU](./LRU) page.  See the discussion in the next section why you might wish to choose LIRS instead.

Like all of the implementations in core.cache, `LRUCache` instances operate like regular maps and are immutable. All caveats apply regarding the [proper usage patterns](./Using).

LIRS cache use cases
--------------------

TODO
