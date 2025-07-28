Feature: Horizon Services Electrical Lighting & Ceiling Fans page tests

  Scenario: Validate Book Now, call button, explore membership button in Lighting & Ceiling Fans page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Lighting & Ceiling Fans" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/electrical-services/lighting-and-ceiling-fans"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Answers to common questions Phone number button
     Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/electrical-services"

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on "Lighting & Ceiling Fans" button in category header submenu
    When I click on "Electric Vehicle Chargers" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electric-vehicle-chargers"
    When I navigate back
    When I click on "Electrical Remodeling" button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-remodeling"
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

  Scenario: Validate Offer at the bottom of the Lighting and Ceiling Fans Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on "Lighting & Ceiling Fans" button in category header submenu
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"