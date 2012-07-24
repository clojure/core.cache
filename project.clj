(defproject core.cache "0.6.2-SNAPSHOT"
  :description "Cache library for Clojure."
  :dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]
  :dev-dependencies [[jline "0.9.94"]
                     [swank-clojure "1.4.2"]
                     [lein-marginalia "0.7.1"]
                     [lein-multi "1.1.0"]]
  :multi-deps {"1.2"   [[org.clojure/clojure "1.2.0"]]
               "1.2.1" [[org.clojure/clojure "1.2.1"]]
               "1.3"   [[org.clojure/clojure "1.3.0"]]
               "1.4"   [[org.clojure/clojure "1.4.0"]]}
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :source-path "src/main/clojure"
  :test-path   "src/test/clojure")
