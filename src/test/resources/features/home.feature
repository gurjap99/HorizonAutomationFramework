Feature: Horizon Services home page tests

  #Scenario: Validate home page title

    When I navigate to "https://www.goldmedalservice.com"
    Then I should see the page title as "Homepage | Gold Medal Service"
    Then all the links on the page should be valid
    When I extract all the elements based on tag from config
    Then I verify each link is working
  # Then both CTAs with plus icons should be clickable and show Book Now button
    Then I should see the text "What do you need help with today?"
    And I click on the Offer Details link

  Scenario: Validate Offer Banner Frame

    Given I navigate to "https://www.horizonservices.com/"
    When I click on offer banner
    Then I can verify the Offer Banner CTA alignment
    And Offer expiry date in offer banner CTA
    When I click on Book Now button in offer banner CTA
    Then I should see Book Online Now Window and close it
    When I click on phone number button in offer banner CTA
    #Then I can verify Phone call popup

  Scenario: Validate Explore Heating & cooling, Explore Plumbing, Explore Electrical buttons

    Given I navigate to "https://www.horizonservices.com/"
    When I click on Explore Heating & Cooling, it opens Heating & Cooling webpage
    Then I can navigate back to home page
    When I click on Explore Plumbing, it opens Plumbing webpage
    Then I can navigate back to home page
    When I click on Explore Electrical, it opens Electrical webpage
    Then I can navigate back to home page

  Scenario: Validate Image Call and Book Now buttons

    Given I navigate to "https://www.horizonservices.com/"
    When I click on Book Now button in Image on home screen
    Then I should see Book Online Now Window and close it
    When I click on phone number button in in Image on home screen
    #Then I can verify Phone call popup

  Scenario: Validate "Peace of mind is on the way" call and book now buttons

    Given I navigate to "https://www.horizonservices.com/"
    When I click on Book Now button in Peace of mind is on the way bar
    Then I should see Book Online Now Window and close it
    When I click on phone number button in Peace of mind is on the way bar
    #Then I can verify Phone call popup

  Scenario: Validate footer elements, their order and links

    Given I navigate to "https://www.horizonservices.com/"
    Then I should see the footer menu list in correct order
    When Links in Services column are clicked, they redirect to correct webpages
    When Links in Quick Links column are clicked, they redirect to correct webpages
    When Links in About Us column are clicked, they redirect to correct webpages


  Scenario: Validate Help, my air conditioner won’t turn on! CTA
    Given I navigate to "https://www.horizonservices.com"
    When Click on Help my air conditioner won’t turn on! option
    Then I should see and click on Book Now button on flashed air conditioner frame
    Then I should see Book Online Now Window and close it
    #And I should see and click on phone number on flashed air conditioner frame

  Scenario: Validate Do you install tankless water heaters? CTA
    Given I navigate to "https://www.horizonservices.com"
    When Click on Do you install tankless water heaters option
    Then I should see and click on Book Now button on flashed water tank frame
    #And I should see and click on phone number on flashed water tank frame

  Scenario: Validate Help, I need 24/7 emergency service! CTA
    Given I navigate to "https://www.horizonservices.com"
    When Click on emergency service option
    Then I should see Book Online Now Window and close it

  Scenario: Validate Header Menu Order
    Given I navigate to "https://www.horizonservices.com"
    When I get the Menu list
    Then I Should see the Menu order is displayed in correct order

  Scenario: Validate Header Sub Menu Order
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    Then I should see the Heating & Cooling Sub Menu order is displayed in correct order
    When I Click on Plumbing
    Then I should see the Plumbing Sub Menu order is displayed in correct order
    When I Click on Electrical
    Then I should see the Electrical Sub Menu order is displayed in correct order
    When I Click on Ways to Save
    Then I should see the Ways to Save Sub Menu order is displayed in correct order
    When I Click on About Us
    Then I should see the About Us Sub Menu order is displayed in correct order
    When I Click on Learn
    Then I should see new page with URL "https://www.horizonservices.com/learning-hub"

  Scenario: Validate Book Now And Phone number from header part
    Given I navigate to "https://www.horizonservices.com"
    When  I click on Book Now button on header part
    Then I should see Book Online Now Window and close it
    When I click on phone number from header part
    #Then I should see phone number popup
