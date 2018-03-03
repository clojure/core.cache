#!/bin/sh
#
# We don't auto-test against Clojure 1.6 because the Cognitect test runner
# requires at least 1.7, so we run those tests manually:

time clj -A:1.6:test -e \
"(require 'clojure.core.cache-test)\
 (clojure.test/run-tests 'clojure.core.cache-test)"

versions="1.7 1.8 1.9 master"
for v in $versions
do
  time clj -A:test:runner:$v
done
