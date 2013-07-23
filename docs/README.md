core.cache
==========

## Table of Topics

* Overview (this page)
* [Including core.cache in your projects](./Including.md)
* [Example usages of core.cache](./Using.md)
* [Composing caches](./Composing.md)
* [Creating custom caches](./Extending.md)
* [Building core.cache](./Building.md)
* [Plans for core.cache](./Plans.md)

## The problem

Value caching is sometimes needed. This need is often driven by the desire is to avoid calculating expensive operations such as inherently costly algorithms or I/O more often than necessary.  The naive solution for this need is to perform some expensive operation once and cache the result.  Therefore, whenever the same calculation is needed in the future it can be retrieved from cache more quickly than simply recalculating from scratch.

While effective for small domains, the naive caching of many expensive calculations or cyclopean results can consume available memory quickly.  Therefore, the ideal situation is to expunge stored results that have expired, meant for single-use or less likely to be needed again.  There are many general-purpose and domain-specific strategies for efficient cache population and eviction. The core.cache library provides implementations of common caching strategies as well as a mechanism for implementing custom strategies.

## Overview

core.cache is a Clojure contrib library providing the following features:

* An underlying `CacheProtocol` used as the base abstraction for implementing new synchronous caches

* A `defcache` macro for hooking your `CacheProtocol` implementations into the Clojure associative data capabilities.

* Implementations of some common caching strategies, including:
  - [First-in-first-out](./FIFO.md)
  - [Least-recently-used](./LRU.md)
  - [Least-used](./LU.md)
  - [Time-to-live](./TTL.md)

* Implementation of an efficient buffer replacement policy based on the *low inter-reference recency set* algorithm ([LIRSCache](./LIRS.md)) described in the [LIRS](http://citeseer.ist.psu.edu/viewdoc/summary?doi=10.1.1.116.2184) paper

* Factory functions for each existing cache type

*The implementation of core.cache is based on and heavily influenced by the excellent ['Memoize done right'](http://kotka.de/blog/2010/03/memoize_done_right.html) by Meikel Brandmeyer*

## Places

* [Source code](https://github.com/clojure/core.cache)
* [Ticket system](http://dev.clojure.org/jira/browse/CCACHE)
* [Announcement](http://groups.google.com/group/clojure/browse_frm/thread/69d08572ab265dc7)
* [Examples and documentation](http://github.com/clojure/core.cache/wiki)