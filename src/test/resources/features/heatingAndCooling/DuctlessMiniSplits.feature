Feature: Horizon Service Heating & Cooling Ductless Mini-Splits Page tests

  Scenario: Validate Book Now, call button, explore membership button in Ductless Mini-Splits page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on "Ductless Mini-Splits" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling/ductless-mini-splits"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
#    When I click on Explore Membership button
#    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
#    When I navigate back
    When I click on Explore Financing button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    When I navigate back
#    When I click on Answers to common questions Phone number button
#    Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services"

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Heating & Cooling
    When I click on "Ductless Mini-Splits" button in category header submenu
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
    When I click on "AC Maintenance" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-maintenance"
    When I navigate back
    When I click on "AC Installation" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-installation"
    When I navigate back
    When I click on "HVAC Accessories" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling/hvac-accessories"
    When I navigate back
    When I click on "Indoor Air Quality" button
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/indoor-air-quality"

  Scenario: Validate Offer at the bottom of the Ductless Mini Splits Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Heating & Cooling
    When I click on "Ductless Mini-Splits" button in category header submenu
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"