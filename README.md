# clojure.core.cache - A Clojure Caching Library 

core.cache is a new Clojure contrib library providing the following features:

* An underlying `CacheProtocol` used as the base abstraction for implementing new synchronous caches

* A `defcache` macro for hooking your `CacheProtocol` implementations into the Clojure associative data capabilities.

* Immutable implementations of some basic caching strategies
  - First-in-first-out (FIFOCache)
  - Least-recently-used (LRUCache)
  - Least-used (LUCache)
  - Time-to-live (TTLCache)
  - Naive cache (BasicCache)

* Implementation of an efficient buffer replacement policy based on the *low inter-reference recency set* algorithm (LIRSCache) described in the [LIRS](http://citeseer.ist.psu.edu/viewdoc/summary?doi=10.1.1.116.2184) paper

* Factory functions for each existing cache type

core.cache is based on a library named Clache, found at http://github.com/fogus/clache that is planned for deprecation.


Using
-----

You can use core.cache in your [Leiningen](https://github.com/technomancy/leiningen) and [Cake](https://github.com/flatland/cake) projects with the following `:dependencies` directive in your `project.clj` file:

    [org.clojure/core.cache "0.5.0"]

For Maven-driven projects, use the following slice of XML in your `pom.xml`'s `<dependencies>` section:

    <dependency>
	  <groupId>org.clojure</groupId>
	  <artifactId>core.cache</artifactId>
	  <version>0.5.0</version>
	</dependency>

Enjoy!


Places
------

* [Source code](https://github.com/clojure/core.cache)
* [Ticket system](http://dev.clojure.org/jira/browse/CCACHE)
* [Announcement](http://groups.google.com/group/clojure/browse_frm/thread/69d08572ab265dc7)
* Examples and documentation -- in progress


Changes from Clache
-------------------

The v0.5.0 version of core.cache is based almost wholly on the final version of Clache, with the following changes:

* An addition of an `evict` function on the `CacheProtocol` used to explicitly remove a value from a cache based on a key.  All of the existing cache types implement this function *except* for `LIRSCache`.

* The addition of cache factory functions for all of the existing cache types

* The associative structure behaviors are defined solely in terms of the underlying `CacheProtocol`

* The `SoftCache` implementation was buggy and removed for now


Plans
-----

The following capabilities are under design, development, or consideration for future versions of core.cache:

* Asynchronous caching protocol
* `LIRSCache evict`
* Removal of the `seed` function from the `CacheProtocol`
* Reimplementation of a cache based on soft references
* test.generative usage
* Deprecation of Clache
* Documentation and examples

More planning is needed around capabilities not listed nor thought of.


Contributors
------------

core.cache would not exist if not for the inspiration and contributions of the following people:

* [Meikel Brandmeyer](http://kotka.de)
* [Fogus](http://fogus.me/fun)
* [Sebastián Galkin](http://github.com/paraseba)
* [Jan Oberhagemann](http://github.com/deduktion)


References
----------

TODO


License
-------

Copyright © 2011 Rich Hickey

Licensed under the EPL. (See the file epl.html.)
