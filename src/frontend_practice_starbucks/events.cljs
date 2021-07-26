(ns frontend-practice-starbucks.events
  (:require
   [re-frame.core :as re]
   [frontend-practice-starbucks.helpers :as helpers]))

(re/reg-event-db
 ::set-star-tab
 (fn [db [_ star-tab]]
   (assoc db :star-tab star-tab)))

(re/reg-event-db
 ::set-star-code
 (fn [db [_ star-code]]
   (assoc db :star-code star-code)))

(re/reg-event-db
 ::initialize-db
 (fn [_ _]
   helpers/default-db))
