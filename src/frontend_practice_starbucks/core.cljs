(ns frontend-practice-starbucks.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [frontend-practice-starbucks.events :as events]
   [frontend-practice-starbucks.views :as views]
   [frontend-practice-starbucks.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
