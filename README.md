clojure.core.cache
========================================

core.cache is a Clojure contrib library providing the following features:

* An underlying `CacheProtocol` used as the base abstraction for implementing new synchronous caches

* A `defcache` macro for hooking your `CacheProtocol` implementations into the Clojure associative data capabilities.

* Implementations of some basic in-memory caching strategies
  - First-in-first-out (FIFOCache)
  - Least-recently-used (LRUCache)
  - Least-used (LUCache -- sometimes called Least Frequently Used)
  - Time-to-live (TTLCacheQ)
  - Naive cache (BasicCache)
  - Naive cache backed with soft references (SoftCache)

* Implementation of an efficient buffer replacement policy based on the *low inter-reference recency set* algorithm (LIRSCache) described in the [LIRS](http://citeseer.ist.psu.edu/viewdoc/summary?doi=10.1.1.116.2184) paper

* Factory functions for each existing cache type

* Caches are generally in-memory and immutable and should be used in conjunction with Clojure's state management, such as `atom`. SoftCache is the exception here, an in-memory cache built on top of mutable Java collections, but it can be treated as an immutable cache as well.

The `clojure.core.cache` namespace contains the immutable in-memory caches themselves.
The `clojure.core.cache.wrapped` namespace contains the same API operating on caches wrapped in atoms, which is the "normal" use in the wild (introduced in 0.8.0).

core.cache is based on an old library named Clache that has been thoroughly deprecated.

The `core.cache` API is hard to use correctly. That's why `clojure.core.cache.wrapped/lookup-or-miss` exists: it encapsulates all the best practices around using the API _and_ wraps it in an `atom` from the get-go. Read this article about [the `core.cache` API](https://dev.to/dpsutton/exploring-the-core-cache-api-57al) by Dan Sutton for why it is important to use the API correctly!

Releases and Dependency Information
========================================

This project follows the version scheme MAJOR.MINOR.COMMITS where MAJOR and MINOR provide some relative indication of the size of the change, but do not follow semantic versioning. In general, all changes endeavor to be non-breaking (by moving to new names rather than by breaking existing names). COMMITS is an ever-increasing counter of commits since the beginning of this repository.

Latest stable release: 1.1.234

* [All Released Versions](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.clojure%22%20AND%20a%3A%22core.cache%22)
* [Development Snapshot Versions](https://oss.sonatype.org/index.html#nexus-search;gav~org.clojure~core.cache~~~)

[CLI/`deps.edn`](https://clojure.org/reference/deps_edn) dependency information:

```clojure
org.clojure/core.cache {:mvn/version "1.1.234"}
```

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

    [org.clojure/core.cache "1.1.234"]

[Maven](http://maven.apache.org/) dependency information:

    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>core.cache</artifactId>
      <version>1.1.234</version>
    </dependency>



Example Usage
========================================

The [`clojure.core.cache` namespace](https://cljdoc.org/d/org.clojure/core.cache/CURRENT/api/clojure.core.cache)
provides an API for immutable caches where
it is expected that you would manage storage of these data structures.

The [`clojure.core.cache.wrapped` namespace](https://cljdoc.org/d/org.clojure/core.cache/CURRENT/api/clojure.core.cache.wrapped)
provides the same API but over
immutable caches already wrapped in an atom, which is generally a more
intuitive API for straightforward use cases. In particular, this namespace
adds a `lookup-or-miss` function which encapsulates the `has?`/`hit`/`miss`
logic for the underlying cache as well as edge cases such as `lookup`
returning `nil` if a cache item expires on fetch (e.g., TTL), and guaranteeing
the value computing function is only called at most once.

The expectation is that you use _either_ `clojure.core.cache` _or_
`clojure.core.cache.wrapped` and you do not try to mix them.

```clojure
    (require '[clojure.core.cache :as cache])

    ;; C1 is an immutable cache:
    (def C1 (cache/fifo-cache-factory {:a 1, :b 2}))

    (def C1' (if (cache/has? C1 :c)
               (cache/hit C1 :c)
               (cache/miss C1 :c 42)))

    ;=> {:a 1, :b 2, :c 42}

    (cache/lookup C1' :c)

    ;=> 42

    (get C1' :c) ; cache/lookup is implemented as get

    ;=> 42

    ;; a shorthand for the above conditional...
    (def C1' (cache/through-cache C1 :c (constantly 42)))
    ;; ...which uses a value to compute the result from the key...
    (cache/through-cache C1 my-key (partial jdbc/get-by-id db-spec :storage))
    ;; ...so you could fetch values from a database if they're not in cache...

    (cache/evict C1 :b)

    ;=> {:a 1}

    ;; since the caches are immutable, you would normally wrap them in an atom
    (def C2 (atom (cache/fifo-cache-factory {:a 1, :b 2})))

    (swap! C2 cache/through-cache :d (constantly 13))

    ;=> {:a 1, :b 3, :d 13}

    (swap! C2 cache/evict :b)

    ;=> {:a 1, :d 13}

    (get @C2 :a)

    ;=> 1

    ;; or use the wrapped API instead:
    (require '[clojure.core.cache.wrapped :as w])

    ;; in this case C3 is an atom containing a cache:
    (def C3 (w/fifo-cache-factory {:a 1, :b 2}))

    ;; operations modify the atom and return the updated cache:
    (w/through-cache C3 :d (constantly 13))

    ;=> {:a 1, :b 3, :d 13}

    ;; modifies the atom and returns the updated cache:
    (w/evict C3 :b)

    ;=> {:a 1, :d 13}

    ;; for some caches this is a mutating operation (e.g., TTL):
    (w/lookup C3 :a) ; or (get @C3 :a)

    ;=> 1

    ;; unique to the wrapped API, this combines through-cache and lookup
    ;; to return the looked up value, possibly after calling the passed in
    ;; function with the key to populate the cache if the key wasn't present:
    (w/lookup-or-miss C3 :b (constantly 42))

    ;=> 42

    @C3

    ;=> {:a 1, :d 13, :b 42}

    ;; calls (jdbc/get-by-id :storage my-key) in the event of a cache miss:
    (w/lookup-or-miss C3 my-key (partial jdbc/get-by-id db-spec :storage))
```

Refer to docstrings in the `clojure.core.cache` or `clojure.core.cache.wrapped` namespaces, or the [autogenerated API documentation](http://clojure.github.io/core.cache/) for additional documentation.


Developer Information
========================================

* [GitHub project](https://github.com/clojure/core.cache)
* [Bug Tracker](https://clojure.atlassian.net/browse/CCACHE)
* [Continuous Integration](https://github.com/clojure/core.cache/actions/workflows/test.yml)



Change Log
====================

* Release 1.2.next in progress
  * [CCACHE-65](http://clojure.atlassian.net/browse/CCACHE-65) Use `delay` in `lookup-or-miss` to avoid cache-stampede.
* Release 1.1.234 on 2024-02-19
  * Update parent pom and `data.priority-map` versions
* Release 1.0.225 on 2021-12-06
  * Update `data.priority-map` to 1.1.0
* Release 1.0.217 on 2021-08-02
  * [CCACHE-63](http://clojure.atlassian.net/browse/CCACHE-63) Improve cache initialization for LU/LRU; fix LU miss logic when not full.
* Release 1.0.207 on 2020-04-10
  * Switch to 1.0.x versioning.
  * Update `data.priority-map` to 1.0.0
* Release 0.8.2 on 2019-09-30
  * [CCACHE-57](http://clojure.atlassian.net/browse/CCACHE-57) Fix wrapped cache `miss` function
* Release 0.8.1 on 2019-08-24
  * [CCACHE-56](http://clojure.atlassian.net/browse/CCACHE-56) Fix wrapped TTL cache and fix `clojure.core.cache.wrapped/lookup-or-miss` for caches that can invalidate on `lookup`
* Release 0.8.0 on 2019-08-24
  * [CCACHE-50](http://clojure.atlassian.net/browse/CCACHE-50) Add `clojure.core.cache.wrapped` namespace with atom-wrapped caches for a more convenient API that adds `lookup-or-miss` which avoids the possibility of cache stampede
* Release 0.7.2 on 2019-01-06
  * [CCACHE-53](http://clojure.atlassian.net/browse/CCACHE-53) Remove unnecessary/additional `.get` call (Neil Prosser)
  * [CCACHE-52](http://clojure.atlassian.net/browse/CCACHE-52) Fix NPE in SoftCache (Neil Prosser)
* Release 0.7.1 on 2018.03.02
  * [CCACHE-49](http://clojure.atlassian.net/browse/CCACHE-49) Fix TTLCacheQ `seed` function and expand tests on TTLCacheQ
* Release 0.7.0 on 2018.03.01
  * [CCACHE-46](http://clojure.atlassian.net/browse/CCACHE-46) Fix TTLCache when wrapped around another cache (Ivan Kryvoruchko)
  * [CCACHE-43](http://clojure.atlassian.net/browse/CCACHE-43) Add `through-cache` to provide a version of `through` that plays nice with `swap!` etc
  * [CCACHE-40](http://clojure.atlassian.net/browse/CCACHE-40) Fix FIFOCache stack overflow on large threshold (uses PersistentQueue now instead of concat and list)
  * [CCACHE-39](http://clojure.atlassian.net/browse/CCACHE-39) Fix FIFOCache evict/miss queue handling
  * [CCACHE-20](http://clojure.atlassian.net/browse/CCACHE-20) Updated README to clarify that caches are immutable and provide examples of use with `atom` etc
  * [CCACHE-15](http://clojure.atlassian.net/browse/CCACHE-15) Added queue and generation logic to reduce `miss` cost and make `evict` O(1); rename TTLCache -> TTLCacheQ (Kevin Downey)
  * Drop support for Clojure 1.3/1.4/1.5
* Release 0.6.5 on 2016.03.28
  * Bump tools.priority-map dependency to 0.0.7
  * [CCACHE-41](http://clojure.atlassian.net/browse/CCACHE-41) Implement Iterable in defcache
  * [CCACHE-44](http://clojure.atlassian.net/browse/CCACHE-44) Avoid equals comparison on cache miss
  * [CCACHE-37](http://clojure.atlassian.net/browse/CCACHE-37) Fix typo in docstring
* Release 0.6.4 on 2014.08.06
  * Thanks to Paul Stadig and Nicola Mometto who contributed patches for this release
  * [CCACHE-34](http://clojure.atlassian.net/browse/CCACHE-34) bump tools.priority-map dependency to 0.0.4
  * [CCACHE-28](http://clojure.atlassian.net/browse/CCACHE-28) concurrency bug in has? for SoftCache
  * [CCACHE-29](http://clojure.atlassian.net/browse/CCACHE-29) fix conj implementation for caches
  * [CCACHE-30](http://clojure.atlassian.net/browse/CCACHE-30) make-reference need not be dynamic
  * [CCACHE-26](http://clojure.atlassian.net/browse/CCACHE-26) hit function in LRU cache can give funny results
* Release 0.6.3 on 2013.03.15
  * Added through to encapsulate check logic
* Release 0.6.2 on 2012.08.07 [more information](http://blog.fogus.me/?p=4527)
  * Removed reflection warnings
  * Fixed eviction of items from LU, TTL and LRU caches with thresholds less than two
  * Fixed eviction of items from FIFO cache prior to threshold
* Release 0.6.2 on 2012.07.13 [more information](http://blog.fogus.me/2012/07/13/announcing-core-cache-version-0-6-1/)
  * Added SoftCache
  * Fixed eviction of items from LU and LRU caches prior to threshold
  * Adjusted default thresholds in factory functions
* Release 0.5.0 on 2011.12.13 [more information](http://blog.fogus.me/2011/12/13/announcing-core-cache-v0-5-0/)
  * Added `evict`
  * Added cache factory functions
  * Added associatve operation support


Copyright and License
========================================

Copyright (c) Rich Hickey, Michael Fogus and contributors, 2012-2023. All rights reserved.  The use and distribution terms for this software are covered by the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at the root of this distribution. By using this software in any fashion, you are agreeing to be bound bythe terms of this license.  You must not remove this notice, or any other, from this software.
