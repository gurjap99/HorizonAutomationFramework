Feature: Horizon Services Electrical Electrical Remodeling page tests

  Scenario: Validate Book Now, call button, explore membership button in Electrical Remodeling page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Electrical Remodeling" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-remodeling"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    #When I click on service page Phone number button
    #Then I can verify Phone call popup
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Answers to common questions Phone number button
     #Then I can verify Phone call popup

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Electrical Remodeling" button in category header submenu
    When I click on "Lighting & Ceiling Fans" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/lighting-and-ceiling-fans"
    When I navigate back
    When I click on "Electrical Panels & Circuit Breakers" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-panels-and-circuit-breakers"
    When I navigate back
    When I click on "Electrical Wiring" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-wiring"
    When I navigate back
    When I click on "Electric Vehicle Chargers" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electric-vehicle-chargers"
    When I navigate back
    When I click on "Whole-House Generators" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-generators"
    When I navigate back
    When I click on "Whole-House Surge Protectors" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-surge-protectors"

  Scenario: Validate Offer at the bottom of the Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on "Electrical Remodeling" button in category header submenu
    When I go to bottom of the homepage
    Then I should see two offer is displaying
    When I click on the "first" offer
    Then I can verify the "first" Offer Detail CTA alignment at bottom of the Page
    And I verify "first" Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "first" offer Details CTA
    #Then I can verify Phone call popup
    Then I close first bottom offer CTA
    When I click on the "second" offer
    Then I can verify the "second" Offer Detail CTA alignment at bottom of the Page
    And I verify "second" Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "second" offer Details CTA
    #Then I can verify Phone call popup
    Then I close first bottom offer CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"






