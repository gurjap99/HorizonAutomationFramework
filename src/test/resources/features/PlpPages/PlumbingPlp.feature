Feature: Plumbing PLP page scenarios

  Scenario: Navigate to Plumbing PLP page and Verify Schedule today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I click on Schedule Today Button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup

  Scenario: Verify page Images and Verify Schedule today and call buttons
    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I click on Schedule Today button under same-day appointment now
    Then I should see Book Online Now Window and close it
    When I click on Book Now button by the images
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button by the images
    Then I can verify Phone call popup

  Scenario: Validate Offer at the bottom of the Page

    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I go to bottom of the homepage
    Then I should see 2 offers is displaying
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
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
