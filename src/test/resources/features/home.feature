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

  Scenario: Validate visibility of static phone number in home page
    Given I navigate to "https://www.horizonservices.com" with javaScript turned off, then I visible phone numbers should be same as static phone number

  Scenario: Validate Zipcode is getting updated properly in homepage
    Given I navigate to "https://www.horizonservices.com"
    When I update Zipcode "21244" using eyebrow button
    Then "Your home is in our service area!" appears, "21244" Zipcode gets updates properly, Map and map zipcode input disappears
    # Updating North Carolina Zipcode
    When I update Zipcode "27606" using eyebrow button
    Then "Your home is in our service area!" appears, "27606" Zipcode gets updates properly, Map and map zipcode input disappears
    Then North Carolina phone number appears instead of existing phone number
    # Updating incorrect phone number
    When I update Zipcode "12345" using eyebrow button
    Then "Sorry, your home is not in our service area." appears and update Zipcode is disabled, Map and map zipcode Input is visible

  Scenario: Validate Map Zipcode Input and Book Now
    Given I navigate to "https://www.horizonservices.com"
    When I update Zipcode "21244" using map zipcode input
    Then "Your home is in our service area!" appears, Zip code "21244" should be update in the home page
    When I click map Input Book Now button
    Then I should see Book Online Now Window and close it

  Scenario: Validate Offer at the bottom of the Page

    Given I navigate to "https://www.horizonservices.com/"
    When I go to bottom of the homepage
    Then I should see two offer is displaying
    When I click on the "first" offer
    Then I can verify the "first" Offer Detail CTA alignment at bottom of the Page
    And I verify "first" Offer expiry date in offer detail CTA
    When I click on Book Now button in "first" offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "first" offer Details CTA
    #Then I can verify Phone call popup
    Then I close first bottom offer CTA
    When I click on the "second" offer
    Then I can verify the "second" Offer Detail CTA alignment at bottom of the Page
    And I verify "second" Offer expiry date in offer detail CTA
    When I click on Book Now button in "second" offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "second" offer Details CTA
    #Then I can verify Phone call popup

  Scenario: Validate Google Review on homepage
    Given I navigate to "https://www.horizonservices.com/"
    Then I should see Google review in the home page

