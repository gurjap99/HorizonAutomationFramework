Feature: Horizon Services Electrical Electric Vehicle Chargers page tests

  Scenario: Validate Book Now, call button, explore membership button in Electric Vehicle Chargers page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Electric Vehicle Chargers" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/electrical-services/electric-vehicle-chargers"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    #When I click on Explore Membership button
    #Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    #When I navigate back
    When I click on Explore Financing button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    When I navigate back
    When I click on Answers to common questions Phone number button
     Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/electrical-services"

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Electric Vehicle Chargers" button in category header submenu
    When I click on "Lighting & Ceiling Fans" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/lighting-and-ceiling-fans"
    When I navigate back
    When I click on "Electrical Panels & Circuit Breakers" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-panels-and-circuit-breakers"
    When I navigate back
    When I click on "Whole-House Surge Protectors" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-surge-protectors"
    When I navigate back
    When I click on "Electric Wiring" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-wiring"
    When I navigate back
    When I click on "Whole-House Generators" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-generators"
    When I navigate back
    When I click on "Electrical Remodeling" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-remodeling"

  Scenario: Validate Offer at the bottom of the Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on "Electric Vehicle Chargers" button in category header submenu
    When I go to bottom of the homepage
    Then I should see 2 offers is displaying
    When I click on the 1 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 1 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    When I click on phone number button in 1 offer Details CTA
    Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 2 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 2 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    When I click on phone number button in 2 offer Details CTA
    Then I can verify Phone call popup
    Then I close bottom offer CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"