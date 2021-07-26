(ns frontend-practice-starbucks.helpers)

(def default-db
  {:star-tab "25"
   :star-code ""
   :current-page "Rewards"})

(def started-components 
  [{:id 1 :title "Create an account" 
    :text "To get started, join now. You can also join in the app to get access to the full range of Starbucks® Rewards benefits."}
   {:id 2 :title "Order and pay how you'd like"
    :text "Use cash, credit/debit card or save some time and pay right through the app. You’ll collect Stars all ways. Learn how"}
   {:id 3 :title "Earn Stars, get Rewards"
    :text "As you earn Stars, you can redeem them for Rewards—like free food, drinks, and more. Start redeeming with as little as 25 Stars!"}])

(def offer-components
  [{:number "25" :title "Customize your drink"
    :text "Make your drink just right with an extra espresso shot, dairy substitute or a dash of your favorite syrup."}
   {:number "50" :title "Brewed hot coffee, bakery item or hot tea"
    :text "Pair coffee cake or an almond croissant with your fresh cup of hot brew."}
   {:number "150" :title "Handcrafted drink, hot breakfast or parfait"
    :text "Have a really good morning with a breakfast sandwich, oatmeal or your favorite drink."}
   {:number "200" :title "Salad, sandwich or protein box"
    :text "Nourish your day with a hearty Chipotle Chicken Wrap or Eggs & Cheese Protein Box."}
   {:number "400" :title "Select merchandise or at-home coffee"
    :text "Take home a signature cup, a bag of coffee or your choice of select coffee accessories."}])

(def texts
     {:hero-header "FREE COFFEE IS A TAP AWAY"
      :hero-subheader1 "Join now to start earning rewards."
      :hero-subheader2 "Or join in the app for the best experience"
      :getting-started-header "Getting started is easy"
      :getting-started-subheader "Earn stars and get rewarded in a few easy steps"
      :offer-header "Get your favorites for free"})