(ns top-monks-frame.views
    (:require [re-frame.core :as re-frame]))

(defn atom-input [value]
  [:input {:type "text"
           :value @value
           :on-change #(re-frame/dispatch [:inp-changed (-> % .-target .-value)])}])

(defn shared-state []
  (let [text (re-frame/subscribe [:text])]
    (fn []
      [:div
       [:p "The value is now: " (str @text " is the best")]
       [:p "Change it here: " [atom-input text]]])))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div "Hello from " @name]
       [shared-state]])))
