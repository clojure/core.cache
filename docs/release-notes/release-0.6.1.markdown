core.cache v0.6.1 Release Notes
===============================

core.cache is a new Clojure contrib library providing the following features:

* An underlying `CacheProtocol` used as the base abstraction for implementing new synchronous caches

* A `defcache` macro for hooking your `CacheProtocol` implementations into the Clojure associative data capabilities.

* Immutable implementations of some basic caching strategies
  - First-in-first-out (FIFOCache)
  - Least-recently-used (LRUCache)
  - Least-used (LUCache)
  - Time-to-live (TTLCache)
  - Soft-Reference cache (SoftCache)
  - Naive cache (BasicCache)

* Implementation of an efficient buffer replacement policy based on the *low inter-reference recency set* algorithm (LIRSCache) described in the [LIRS](http://citeseer.ist.psu.edu/viewdoc/summary?doi=10.1.1.116.2184) paper

* Factory functions for each existing cache type

Absorb
------

You can use core.cache in your [Leiningen](https://github.com/technomancy/leiningen) and [Cake](https://github.com/flatland/cake) projects with the following `:dependencies` directive in your `project.clj` file:

    [org.clojure/core.cache "0.6.1"]

For Maven-driven projects, use the following slice of XML in your `pom.xml`'s `<dependencies>` section:

    <dependency>
	  <groupId>org.clojure</groupId>
	  <artifactId>core.cache</artifactId>
	  <version>0.6.1</version>
	</dependency>

Enjoy!


Places
------

* [Source code](https://github.com/clojure/core.cache)
* [Ticket system](http://clojure.atlassian.net/browse/CCACHE)
* [Announcement](http://groups.google.com/group/clojure/browse_frm/thread/69d08572ab265dc7)
* [API Reference](https://clojure.github.com/core.cache)
* [Examples and documentation](https://github.com/clojure/core.cache/wiki) (work in progress)

Changes from v0.5.0
-------------------

The v0.6.1 version of core.cache contains the following changes:

* The addition of a cache built on Java soft references

* Bug fix for LRU and LU caches disabling the eviction of duplicate keys prior to threshold.

* The factory function optional argument named `:limit` was changed to `:threshold`.

* The default thresholds set by the factory functions were adjusted.

Plans
-----

The following capabilities are under design, development, or consideration for future versions of core.cache:

* Make ClojureScript compatible
* Asynchronous caching protocol
* FunCache implementation
* `LIRSCache evict`
* Hardening of the `seed` function implementations
* test.generative usage
* Deprecation of Clache
* More documentation and examples

More planning is needed around capabilities not listed nor thought of.
