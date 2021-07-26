(ns frontend-practice-starbucks.views
  (:require
   [re-frame.core :as re]
   [frontend-practice-starbucks.subs :as subs]
   [frontend-practice-starbucks.helpers :as helpers]))

(defn offer-component []
  (let [star-tab @(re/subscribe [::subs/star-tab])]
    [:div.offer-component
     [:div.offer-component-upper
      [:p.offer-component-header (:offer-header helpers/texts)]]]))

(defn get-started []
  (let [components (doall 
                    (for [component helpers/started-components]
                      ^{:key (:id component)}
                      [:div.get-started-component
                       [:p.get-started-number-container (:id component)]
                       [:p.get-started-title (:title component)]
                       [:p.get-started-text (:text component)]]))]
    [:div.get-started-section
     [:p.get-started-section-header (:getting-started-header helpers/texts)]
     [:p.get-started-section-subheader (:getting-started-subheader helpers/texts)]
     [:div.get-started-component-container components]]))

(defn header []
  [:div.header
   [:div.header-top.navbar-light.navbar.navbar-expand-lg
    [:img.header-image {:src "logo.png"}]
    [:button.navbar-toggler {:type "button" :data-bs-toggle "collapse" :data-bs-target "#navbarSupportedContent"}
     [:span.navbar-toggler-icon]]
    [:div.navbar-collapse.collapse {:id "navbarSupportedContent"}
     [:div.header-left [:p.header-link "MENU"] [:p.header-link "REWARDS"] [:p.header-link "GIFT CARDS"]]
     [:div.header-right [:p.header-link "Find a store"] [:button.btn.btn-light.sign-in-btn "Sign in"] [:button.btn.btn-dark.join-now-btn "Join now"]]]]
   [:div.header-bottom [:p.header-bottom-text "STARBUCKS REWARDS"]]])

(defn hero []
  [:div.hero 
   [:div.hero-content
    [:p.hero-header (:hero-header helpers/texts)]
    [:p.hero-subheader (:hero-subheader1 helpers/texts)]
    [:button..btn.btn-success.hero-btn "Join now"]
    [:p.hero-subheader (:hero-subheader2 helpers/texts)]]])

(defn main-panel []
  [:div
   [header]
   [hero]
   [get-started]
   [offer-component]])
