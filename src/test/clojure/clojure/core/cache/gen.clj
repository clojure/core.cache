;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns ^{:doc "A caching library for Clojure."
      :author "Michael Fogus"}
  clojure.core.cache.gen
  (:use [clojure.core.cache] :reload-all)
  (:use [clojure.test.generative])
  (:import [clojure.core.cache BasicCache FIFOCache LRUCache TTLCache LUCache]))

(defspec put-in-is-get-out
  (let [bc (BasicCache. {})]
    (fn [k v] (assoc bc k v)))
  [^keyword k ^string v]
  (assert (not (nil? %))))
