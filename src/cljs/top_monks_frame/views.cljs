(ns top-monks-frame.views
    (:require [re-frame.core :as re-frame]))

(defn atom-input [value]
  [:div.ui.input
   [:input {:type "text"
           :value @value
           :on-change #(re-frame/dispatch [:inp-changed (-> % .-target .-value)])}] ])

(defn what-we-say []
  (let [text (re-frame/subscribe [:text])]
    (fn []
      [:div
       [:h1.ui.header (str @text " is the best")]
       [atom-input text]
       [:div.ui.label "I say"]])))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:header.ui.conainer
        {:style {:margin "3rem 0"}}
        [:h1.ui.header @name]]
       [:main.ui.container [what-we-say]]])))
