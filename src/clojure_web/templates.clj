(ns clojure-web.templates
  (:use [compojure.core]
        [ring.util.response]
        [clojure.java.io])
  (:require [compojure.handler :as handler]
            [clj-jade.core :as jade]
            [selmer.parser :as selmer]))


(defn initialise! [template-dir]
  (jade/configure {:template-dir template-dir
                   :pretty-print true
                   :cache? false})
  (println "Initialised jade to : " template-dir)

  (selmer/set-resource-path! template-dir)
  (selmer/cache-off!)
  (println "Initialised selmer to : " template-dir))

(defn determine-type [template-name]
  (let [regex #"(.*)/(.*)"]
    (keyword (second (re-matches regex template-name)))))

(defmulti render-template (fn [template-name page-data] (determine-type template-name)))

(defmethod render-template :jade [template-name page-data]
  (jade/render template-name page-data))

(defmethod render-template :selmer [template-name page-data]
  (selmer/render-file template-name page-data))


(defn render [template-name page-data]
  (render-template template-name page-data))


