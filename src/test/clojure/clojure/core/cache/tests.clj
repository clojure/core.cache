;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns ^{:doc "A caching library for Clojure."
      :author "Fogus"}
  clojure.core.cache.tests
  (:use [clojure.core.cache] :reload-all)
  (:use [clojure.test])
  (:import [clojure.core.cache BasicCache FIFOCache LRUCache TTLCache LUCache]))

(deftest test-basic-cache-lookup
  (testing "that the BasicCache can lookup as expected"
    (is (= :robot (lookup (miss (BasicCache. {}) '(servo) :robot) '(servo))))))

(defn do-ilookup-tests [c]
  (are [expect actual] (= expect actual)
       1   (:a c)
       2   (:b c)
       42  (:X c 42)
       nil (:X c)
       1   (get c :a)
       2   (get c :b)
       42  (get c :X 42)
       nil (get c :X)))

(deftest test-basic-cache-ilookup
  (testing "that the BasicCache can lookup via keywords"
    (do-ilookup-tests (BasicCache. {:a 1 :b 2}))))

(deftest test-fifo-cache-ilookup
  (testing "that the FifoCache can lookup via keywords"
    (do-ilookup-tests (FIFOCache. {:a 1 :b 2} clojure.lang.PersistentQueue/EMPTY 2))))

(deftest test-lru-cache-ilookup
  (testing "that the LRUCache can lookup via keywords"
    (do-ilookup-tests (LRUCache. {:a 1 :b 2} {} 0 2))))

(deftest test-ttl-cache-ilookup
  (testing "that the TTLCache can lookup via keywords"
    (do-ilookup-tests (TTLCache. {:a 1 :b 2} 10 2))))

(deftest test-lu-cache-ilookup
  (testing "that the LUCache can lookup via keywords"
    (do-ilookup-tests (LUCache. {:a 1 :b 2} {} 2))))

