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

