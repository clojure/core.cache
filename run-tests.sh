#!/bin/sh

versions="1.9 1.10 1.11 1.12"
for v in $versions
do
  time clojure -M:test:$v
  if test $? != 0; then exit 1; fi
done
