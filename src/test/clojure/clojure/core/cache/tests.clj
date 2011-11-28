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

(defn do-getting [c]
  (are [expect actual] (= expect actual)
       (get c :a) 1
       (get c :e) nil
       (get c :e 0) 0
       (get c :b 0) 2
       (get c :f 0) nil
       
       (get-in c [:c :e]) 4
       (get-in c '(:c :e)) 4
       (get-in c [:c :x]) nil
       (get-in c [:f]) nil
       (get-in c [:g]) false
       (get-in c [:h]) nil
       (get-in c []) c
       (get-in c nil) c
       
       (get-in c [:c :e] 0) 4
       (get-in c '(:c :e) 0) 4
       (get-in c [:c :x] 0) 0
       (get-in c [:b] 0) 2
       (get-in c [:f] 0) nil
       (get-in c [:g] 0) false
       (get-in c [:h] 0) 0
       (get-in c [:x :y] {:y 1}) {:y 1}
       (get-in c [] 0) c
       (get-in c nil 0) c))

(defn do-finding [c]
  (are [expect actual] (= expect actual)
       (find c :a) [:a 1]
       (find c :b) [:b 2]
       (find c :c) nil
       (find c nil) nil))

(defn do-contains [c]
  (are [expect actual] (= expect actual)
       (contains? c :a) true
       (contains? c :b) true
       (contains? c :c) false
       (contains? c nil) false))


(def big-map {:a 1, :b 2, :c {:d 3, :e 4}, :f nil, :g false, nil {:h 5}})
(def small-map {:a 1 :b 2})

(deftest test-basic-cache-ilookup
  (testing "that the BasicCache can lookup via keywords"
    (do-ilookup-tests (BasicCache. small-map)))
  (testing "that get and cascading gets work for BasicCache"
    (do-getting (BasicCache. big-map)))
  (testing "that finding works for BasicCache"
    (do-finding (BasicCache. small-map)))
  (testing "that contains? works for BasicCache"
    (do-contains (BasicCache. small-map))))

(deftest test-fifo-cache-ilookup
  (testing "that the FifoCache can lookup via keywords"
    (do-ilookup-tests (FIFOCache. small-map clojure.lang.PersistentQueue/EMPTY 2)))
  (testing "that get and cascading gets work for FifoCache"
    (do-getting (FIFOCache. big-map clojure.lang.PersistentQueue/EMPTY 2)))
  (testing "that finding works for FifoCache"
    (do-finding (FIFOCache. small-map clojure.lang.PersistentQueue/EMPTY 2)))
  (testing "that contains? works for FifoCache"
    (do-contains (FIFOCache. small-map clojure.lang.PersistentQueue/EMPTY 2))))

(deftest test-lru-cache-ilookup
  (testing "that the LRUCache can lookup via keywords"
    (do-ilookup-tests (LRUCache. small-map {} 0 2))))

(deftest test-ttl-cache-ilookup
  (testing "that the TTLCache can lookup via keywords"
    (do-ilookup-tests (TTLCache. small-map 10 2))))

(deftest test-lu-cache-ilookup
  (testing "that the LUCache can lookup via keywords"
    (do-ilookup-tests (LUCache. small-map {} 2))))

