(defproject core.cache "0.7.0-SNAPSHOT"
  :description "Cache library for Clojure."
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.priority-map "0.0.7"]]
  :profiles {:1.6   {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7   {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8   {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9   {:dependencies [[org.clojure/clojure "1.9.0"]]}
             :1.10  {:dependencies [[org.clojure/clojure "1.10.0-master-SNAPSHOT"]]}}
  :plugins [[lein-swank "1.4.4"]
            [lein-marginalia "0.7.1"]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :source-paths ["src/main/clojure"]
  :test-paths   ["src/test/clojure"]
  :aliases {"test-all" ["with-profile"
                        "1.6:1.7:1.8:1.9:1.10"
                        "test"]})
