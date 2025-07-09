Feature: Horizon Service Heating & Cooling AC Maintenance Page tests

  Scenario: Validate Book Now, call button, explore membership button in AC Maintenance page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on "AC Maintenance" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-maintenance"
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
    When I Click on Heating & Cooling
    When I click on "AC Maintenance" button in category header submenu
    When I click on "Heating Maintenance" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-maintenance"
    When I navigate back
    When I click on "Heating Installation" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-installation"
    When I navigate back
    When I click on "Heating Repair" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-repair"
    When I navigate back
    When I click on "AC Repair" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-repair"
    When I navigate back
    When I click on "AC Installation" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-installation"
    When I navigate back
    When I click on "Ductless Mini-Splits" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling/ductless-mini-splits"
    When I navigate back
    When I click on "HVAC Accessories" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling/hvac-accessories"
    When I navigate back
    When I click on "Indoor Air Quality" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/indoor-air-quality"

  Scenario: Validate Offer at the bottom of the Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Heating & Cooling
    When I click on "AC Maintenance" button in category header submenu
    When I go to bottom of the homepage
    Then I should see 2 offers is displaying
    When I click on the 1 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 1 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 1 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 2 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 2 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 2 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"