Building core.cache
===================

1. Clone the [core.cache git repository](http://github.com/clojure/core.cache) or download its [source archive](https://github.com/clojure/core.cache/zipball/master)

2. Run `mvn package` to generate a Jar file

3. Run `mvn install` to install the Jar into your local Maven repository

To test that the build succeeded try:

    mvn clojure:repl

This will launch a Clojure REPL.  Try the following to exercise core.cache:

```clojure
(use 'clojure.core.cache)
	
(def c (fifo-cache-factory 1 {:a 42}))
	
(-> c (assoc :b 1) 
      (assoc :z 108))
```

You should see the result `{:z 108}`.
