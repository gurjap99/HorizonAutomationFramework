Feature: HVAC PLP page scenarios

  Scenario: Navigate to HVAC PLP page and Verify Schedule today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/ready/hzn/hvac"
    When I click on Schedule Today Button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    #Then I can verify Phone call popup

  Scenario: Verify page Images and Verify Schedule today and call buttons
    Given I navigate to "https://test.horizonservices.com/ready/hzn/hvac"
    When I click on Schedule Today button under same-day appointment now
    Then I should see Book Online Now Window and close it
    When I click on 3rd Schedule Today button
    Then I should see Book Online Now Window and close it
    When I click on 4th Schedule Today button
    Then I should see Book Online Now Window and close it

  Scenario: Validate Offer at the bottom of the Page
    Given I navigate to "https://test.horizonservices.com/ready/hzn/hvac"
    When I go to bottom of the homepage
    Then I should see 4 offers is displaying
    When I click on the 1 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 1 Offer expiry date in offer detail CTA
    When I click on Schedule Today button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 1 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 2 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 2 Offer expiry date in offer detail CTA
    When I click on Schedule Today button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 2 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 3 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 3 Offer expiry date in offer detail CTA
    When I click on Schedule Today button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 2 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 4 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 4 Offer expiry date in offer detail CTA
    When I click on Schedule Today button in offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in 2 offer Details CTA
    #Then I can verify Phone call popup
    Then I close bottom offer CTA
