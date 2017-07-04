(defproject clojure-web "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [clj-jade "0.1.7"]
                 [clj-time "0.13.0"]
                 [selmer "1.0.4"]]
  :plugins [[lein-ring "0.9.7"]
            ;;[yogthos/lein-sass "0.1.1"]
            [lein-sassy "1.0.8"]
            ]
  ;;  :sass {:source "resources/stylesheets" :target "resources/public/css"}
  :sass {:src "resources/stylesheets/" :dst "resources/public/css/"}
  :ring {:handler clojure-web.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
