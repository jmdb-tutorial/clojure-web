(ns clojure-web.data
  (:require [clj-time.core :as t]))

;; Bug in selmer it doesn't like hyphenated data names
(defn load-demo-data []
  {:data {:fullname "Johnny Mnemomic"
          :time (str (t/now))}})
