Feature: Electrical PLP page scenarios

  Scenario: Navigate to Electrical PLP page and Verify Schedule today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/ready/hzn/electrical"
    When I click on Schedule Today Button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup

  Scenario: Verify page Images and Verify Schedule today and call buttons
    Given I navigate to "https://test.horizonservices.com/ready/hzn/electrical"
    When I click on Schedule Today button under same-day appointment now
    Then I should see Book Online Now Window and close it
    When I click on Book Now button by the images
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button by the images
    Then I can verify Phone call popup

  Scenario: Validate Offer at the bottom of the Electrical PLP Page
    Given I navigate to "https://test.horizonservices.com/ready/hzn/electrical"
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
