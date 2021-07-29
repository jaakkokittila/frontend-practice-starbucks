(ns frontend-practice-starbucks.events
  (:require
   [re-frame.core :as re]
   [frontend-practice-starbucks.helpers :as helpers]))

(re/reg-event-db
 ::set-star-tab
 (fn [db [_ star-tab]]
   (assoc db :star-tab star-tab)))

(re/reg-event-db
 ::validate-star-code
 (fn [db [_ star-code]]
   (if (not= star-code "")
     (assoc db :valid-code true)
     (assoc db :valid-code false))))

(re/reg-event-fx
 ::set-star-code
 (fn [{db :db} [_ star-code]]
   {:db (assoc db :star-code star-code)
    :dispatch [::validate-star-code star-code]}))

(re/reg-event-db
 ::initialize-db
 (fn [_ _]
   helpers/default-db))
