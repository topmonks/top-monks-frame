(ns top-monks-frame.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [top-monks-frame.handlers]
              [top-monks-frame.subs]
              [top-monks-frame.views :as views]
              [top-monks-frame.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
