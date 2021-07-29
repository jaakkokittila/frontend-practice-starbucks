(ns frontend-practice-starbucks.subs
  (:require
   [re-frame.core :as re]))

(re/reg-sub
 ::star-tab
 (fn [db]
   (:star-tab db)))

(re/reg-sub
 ::star-code
 (fn [db]
   (:star-code db)))

(re/reg-sub
 ::valid-code
 (fn [db]
   (:valid-code db)))