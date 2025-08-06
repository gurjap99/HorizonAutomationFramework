Feature: Plumbing PLP page scenarios

  @Regression
  Scenario: Navigate to Plumbing PLP page and Verify Schedule today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I click on Schedule Today Button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup

  @Regression
  Scenario: Verify page Images and Verify Schedule today and call buttons
    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I click on Schedule Today button under same-day appointment now
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button by the images
    Then I can verify Phone call popup

  @Smoke
  Scenario: Validate Offer at the bottom of the Plumbing PLP Page
    Given I navigate to "https://test.horizonservices.com/ready/hzn/plumbing"
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
