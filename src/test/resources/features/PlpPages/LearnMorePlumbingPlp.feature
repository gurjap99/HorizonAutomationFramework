Feature: Learn More Plumbing PLP page scenarios

  @Regression
  Scenario: Navigate to Learn More Plumbing PLP page and Verify Book Now and call buttons in image, Google review, Explore Financing
    Given I navigate to "https://test.horizonservices.com/learn-more/plumbing"
    When I click on Book now button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup
    Then PLP google reviews are visible
    When I click on Explore Financing button
    Then I navigate to "https://test.horizonservices.com/ways-to-save/financing"

  @Smoke
  Scenario: Validate all bottom CTAs and detail links in Learn More Plumbing PLP
    Given I navigate to "https://test.horizonservices.com/learn-more/plumbing"
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"