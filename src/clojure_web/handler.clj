(ns clojure-web.handler
  (:use ring.util.response)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure-web.templates :as templates]
            [clojure-web.data :as data]))

(defroutes app-routes
  (GET "/" [] (redirect "index.html"))
  (GET "/jade/demo.html" []   (templates/render "jade/demo.jade"   (data/load-demo-data)))
  (GET "/selmer/demo.html" [] (templates/render "selmer/demo.html" (data/load-demo-data)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(templates/initialise! "resources/templates")
