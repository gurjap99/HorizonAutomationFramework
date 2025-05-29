Feature: Horizon Services Heating & Cooling Overview Page tests

  Scenario: Validate list of services in Overview of Heating & Cooling
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    Then I can validate the list of all "Heating & Cooling" services and their order

  Scenario: Validate Heating Maintenance of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "Heating Maintenance"
    Then "Heating Maintenance" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Heating Maintenance" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Heating Maintenance" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-maintenance"

  Scenario: Validate Heating Repair of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "Heating Repair"
    Then "Heating Repair" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Heating Repair" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Heating Repair" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-repair"

  Scenario: Validate Heating Installation of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "Heating Installation"
    Then "Heating Installation" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Heating Installation" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Heating Installation" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-installation"

  Scenario: Validate AC Maintenance of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "AC Maintenance"
    Then "AC Maintenance" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "AC Maintenance" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "AC Maintenance" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-maintenance"

  Scenario: Validate AC Repair of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "AC Repair"
    Then "AC Repair" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "AC Repair" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "AC Repair" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-repair"

  Scenario: Validate AC Installation of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "AC Installation"
    Then "AC Installation" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "AC Installation" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "AC Installation" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-installation"

  Scenario: Validate Ductless Mini-Splits of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "Ductless Mini-Splits"
    Then "Ductless Mini-Splits" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Ductless Mini-Splits" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Ductless Mini-Splits" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling/ductless-mini-splits"

  Scenario: Validate HVAC Accessories of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "HVAC Accessories"
    Then "HVAC Accessories" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "HVAC Accessories" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "HVAC Accessories" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling/hvac-accessories"

  Scenario: Validate Indoor Air Quality of Heating & Cooling services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on "Heating & Cooling" "Indoor Air Quality"
    Then "Indoor Air Quality" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Indoor Air Quality" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Indoor Air Quality" Learn More button
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/indoor-air-quality"

  Scenario: Validating Heating & Cooling Offer available at bottom of overview page
    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    And I go to bottom of the homepage
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
    Then it navigates to "https://www.horizonservices.com/ways-to-save/offers-and-rebates"

  Scenario: Validating Google Review on Heating & Cooling overview page
    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    Then I should see Google review in the home page

  Scenario: Validate Image Call and Book Now buttons on Heating & Cooling overview page
    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Heating & Cooling
    When I click on Overview button in "Heating & Cooling" header submenu
    When I click on Book Now button in Image on "Horizon Services heating and cooling" Page
    Then I should see Book Online Now Window and close it
    When I click on Phone Number in Image on "Horizon Services heating and cooling" Page
    #Then I can verify Phone call popup

  Scenario: Validate Maintenance Repair and Installation Services at bottom of overview page

    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Heating" in "Maintenance"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-maintenance"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Cooling" in "Maintenance"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-maintenance"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Heating" in "Repair"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-repair"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Cooling" in "Repair"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-repair"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Heating" in "Installation"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/heating-installation"
    When I Click on Heating & Cooling
    And I click on Overview button in "Heating & Cooling" header submenu
    And I click on "Cooling" in "Installation"
    Then it navigates to "https://www.horizonservices.com/heating-and-cooling-services/ac-installation"
