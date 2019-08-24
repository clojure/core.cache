;   Copyright (c) Rich Hickey. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns clojure.core.cache.wrapped-test
  (:require [clojure.core.cache.wrapped :as c]
            [clojure.test :refer [deftest is]]))

(deftest basic-wrapped-test
  (let [cache (c/basic-cache-factory {})]
    (is (= nil (c/lookup cache :a)))
    (is (= ::missing (c/lookup cache :a ::missing)))
    ;; mutating operation
    (is (= 42 (c/lookup-or-miss cache :a (constantly 42))))
    ;; cache now contains :a
    (is (= 42 (c/lookup cache :a)))
    ;; :a is present, does not call value-fn
    (is (= 42 (c/lookup-or-miss cache :a #(throw (ex-info "bad" {:key %})))))
    ;; cache still contains :a as 42
    (is (= 42 (c/lookup cache :a)))
    (c/evict cache :a)
    (is (= nil (c/lookup cache :a)))
    (is (= ::missing (c/lookup cache :a ::missing)))))
