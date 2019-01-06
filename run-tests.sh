#!/bin/sh

versions="1.6 1.7 1.8 1.9 1.10 master"
for v in $versions
do
  time clj -A:test:runner:$v
done
