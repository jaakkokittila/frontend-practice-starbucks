(ns frontend-practice-starbucks.subs
  (:require
   [re-frame.core :as re]))

(re/reg-sub
 ::star-tab
 (fn [db]
   (:star-tab db)))

(re/reg-sub
 ::current-page
 (fn [db]
   (:current-page db)))

(re/reg-sub
 ::star-code
 (fn [db]
   (:star-tab db)))