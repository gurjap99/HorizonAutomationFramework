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