(ns top-monks-frame.handlers
    (:require [re-frame.core :as re-frame]
              [top-monks-frame.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
 :inp-changed
 (fn [db [_ text]]
   (assoc db :text text)))
