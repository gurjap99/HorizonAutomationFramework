Feature: Learn More HVAC PLP page scenarios

  @Regression
  Scenario: Navigate to Learn More HVAC PLP page and Verify Book Now and call buttons in image, Google review, Explore Financing
    Given I navigate to "https://test.horizonservices.com/learn-more/hvac"
    When I click on Book now button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup
    #Then PLP google reviews are visible
    When I click on Explore Financing button
    Then I navigate to "https://test.horizonservices.com/ways-to-save/financing"

  @Smoke
  Scenario: Validate Maintenance, Repair, Installation Heating and Cooling links in Learn More HVAC PLP
    Given I navigate to "https://test.horizonservices.com/learn-more/hvac"
    When I click on "Heating" in "Maintenance"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-maintenance"
    When I navigate back
    And I click on "Cooling" in "Maintenance"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-maintenance"
    When I navigate back
    And I click on "Heating" in "Repair"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-repair"
    When I navigate back
    And I click on "Cooling" in "Repair"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-repair"
    When I navigate back
    And I click on "Heating" in "Installation"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/heating-installation"
    When I navigate back
    And I click on "Cooling" in "Installation"
    Then it navigates to "https://test.horizonservices.com/heating-and-cooling-services/ac-installation"


  @Smoke
  Scenario: Validate all bottom CTAs and detail links in Learn More HVAC PLP
    Given I navigate to "https://test.horizonservices.com/learn-more/hvac"
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"