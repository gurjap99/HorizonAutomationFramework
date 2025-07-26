Feature: Horizon Services Electrical Overview Page tests

  Scenario: Validate list of services in Overview of Electrical
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    Then I can validate the list of all "Electrical" services and their order

  Scenario: Validate Lighting & Ceiling Fans of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Lighting & Ceiling Fans"
    Then "Lighting & Ceiling Fans" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Lighting & Ceiling Fans" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Lighting & Ceiling Fans" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/lighting-and-ceiling-fans"

  Scenario: Validate Electrical Panels & Circuit Breakers of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Electrical Panels & Circuit Breakers"
    Then "Electrical Panels & Circuit Breakers" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Electrical Panels & Circuit Breakers" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Electrical Panels & Circuit Breakers" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-panels-and-circuit-breakers"

  Scenario: Validate Electrical Wiring of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Electrical Wiring"
    Then "Electrical Wiring" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Electrical Wiring" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Electrical Wiring" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-wiring"

  Scenario: Validate Electrical Remodeling of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Electrical Remodeling"
    Then "Electrical Remodeling" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Electrical Remodeling" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Electrical Remodeling" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electrical-remodeling"

  Scenario: Validate Electric Vehicle Chargers of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Electric Vehicle Chargers"
    Then "Electric Vehicle Chargers" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Electric Vehicle Chargers" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Electric Vehicle Chargers" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/electric-vehicle-chargers"

  Scenario: Validate Whole-House Generators of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Whole-House Generators"
    Then "Whole-House Generators" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Whole-House Generators" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Whole-House Generators" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-generators"

  Scenario: Validate Whole-House Surge Protectors of Electrical services CTA
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on "Electrical" "Whole-House Surge Protectors"
    Then "Whole-House Surge Protectors" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    When "Whole-House Surge Protectors" Phone number button in CTA is clicked
    Then I can verify Phone call popup
    When I click on "Whole-House Surge Protectors" Learn More button
    Then it navigates to "https://test.horizonservices.com/electrical-services/whole-house-surge-protectors"

  Scenario: Validating Electrical Offer available at bottom of overview page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    And I go to bottom of the homepage
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
    When I can verify Phone call popup
    When I close bottom offer CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"

  Scenario: Validating Google Review on Electrical overview page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    Then I should see Google review in the home page

  Scenario: Validate Image Call and Book Now buttons on Electrical overview page

    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Electrical
    When I click on Overview button in "Electrical" header submenu
    When I click on Book Now button in Image on "Horizon Services electrical" Page
    Then I should see Book Online Now Window and close it
    When I click on Phone Number in Image on "Horizon Services electrical" Page
    Then I can verify Phone call popup
