(ns frontend-practice-starbucks.views
  (:require
   [re-frame.core :as re]
   [frontend-practice-starbucks.subs :as subs]
   [frontend-practice-starbucks.events :as events]
   [frontend-practice-starbucks.helpers :as helpers]))

(defn footer []
  [:div.footer
   [:p.footer-text "Made for practice purposes"]
   [:p.footer-text "Jaakko Kittilä - 2021"]])

(defn star-code-form []
  (let [star-code @(re/subscribe [::subs/star-code])
        valid-code @(re/subscribe [::subs/valid-code])
        border-color (if valid-code
                       {:borderColor nil}
                       {:borderColor "red"})]
    [:div.star-code-form.margin-center
     [:p.star-code-header "Star Codes"]
     [:p.star-code-subheader (:star-code-subheader helpers/texts)]
     [:div.input-container
      [:input.star-code-input
       {:style border-color
        :type "text"
        :required true
        :value star-code
        :on-change #(re/dispatch [::events/set-star-code (-> % .-target .-value)])}]
      [:label.star-code-placeholder (:star-code-placeholder helpers/texts)]
      (when-not valid-code
        [:p {:style {:color "red"}} "Please enter a Star code."])
      [:button.btn.btn-light.submit-btn.rounded-button "Submit"]]
     [:p.star-code-subtext (:star-code-subtext1 helpers/texts)]
     [:p.star-code-subtext (:star-code-subtext2 helpers/texts)]]))

(defn offer-component []
  (let [star-tab @(re/subscribe [::subs/star-tab])
        tab-navigation (doall (for [component helpers/offer-components]
                                ^{:key (:number component)}
                                [:div.navigation-tab {:onClick #(re/dispatch [::events/set-star-tab (:number component)])}
                                 (:number component)]))
        current-tab (first (filterv #(= star-tab (:number %)) helpers/offer-components))
        current-component [:div.current-offer.margin-center
                           [:img.offer-img {:src (:image current-tab)}]
                           [:div.current-offer-text-part
                            [:p.current-offer-title (:title current-tab)]
                            [:p.current-offer-text (:text current-tab)]]]]
    [:div.offer-component
     [:div.offer-component-upper
      [:p.offer-component-header (:offer-header helpers/texts)]
      [:div.navigation-tab-container.flex-row.margin-center
       tab-navigation
       [:div.active-tab-container [:div.active-tab {:style {:margin-left (:margin-left current-tab)}}]]]]
     [:div.offer-component-lower
      current-component]]))

(defn get-started []
  (let [components (doall 
                    (for [component helpers/started-components]
                      ^{:key (:id component)}
                      [:div.get-started-component.margin-center
                       [:p.get-started-number-container (:id component)]
                       [:p.get-started-title (:title component)]
                       [:p.get-started-text (:text component)]]))]
    [:div.get-started-section.margin-center
     [:p.get-started-section-header (:getting-started-header helpers/texts)]
     [:p.get-started-section-subheader (:getting-started-subheader helpers/texts)]
     [:div.get-started-component-container.flex-row components]]))

(defn header []
  [:div.header
   [:div.header-top.navbar-light.navbar.navbar-expand-lg
    [:img.header-image {:src "logo.png"}]
    [:button.navbar-toggler {:type "button" :data-bs-toggle "collapse" :data-bs-target "#navbarSupportedContent"}
     [:span.navbar-toggler-icon]]
    [:div.navbar-collapse.collapse {:id "navbarSupportedContent"}
     [:div.header-left [:p.header-link "MENU"] [:p.header-link "REWARDS"] [:p.header-link "GIFT CARDS"]]
     [:div.header-right
      [:p.header-link "Find a store"]
      [:button.btn.btn-light.sign-in-btn.rounded-button "Sign in"]
      [:button.btn.btn-dark.join-now-btn.rounded-button "Join now"]]]]
   [:div.header-bottom.flex-row [:p.header-bottom-text "STARBUCKS REWARDS"]]])

(defn hero []
  [:div.hero 
   [:div.hero-content
    [:p.hero-header (:hero-header helpers/texts)]
    [:p.hero-subheader (:hero-subheader1 helpers/texts)]
    [:button.btn.btn-success.hero-btn.rounded-button "Join now"]
    [:p.hero-subheader (:hero-subheader2 helpers/texts)]]])

(defn main-panel []
  [:div
   [header]
   [hero]
   [get-started]
   [offer-component]
   [star-code-form]
   [footer]])
