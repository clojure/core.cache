(defproject core.cache "0.6.3-SNAPSHOT"
  :description "Cache library for Clojure."
  :dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]
  :dev-dependencies [[jline "0.9.94"]
                     [lein-marginalia "0.7.1"]
                     [lein-multi "1.1.0"]]
  :multi-deps {"1.2"   [[org.clojure/clojure "1.2.0"]]
               "1.2.1" [[org.clojure/clojure "1.2.1"]]
               "1.3"   [[org.clojure/clojure "1.3.0"]]
               "1.4"   [[org.clojure/clojure "1.4.0"]]}
  :plugins [[lein-swank "1.4.4"]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :source-paths ["src/main/clojure"]
  :test-paths   ["src/test/clojure"])
