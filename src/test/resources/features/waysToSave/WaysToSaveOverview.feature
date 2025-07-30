Feature: Horizon Service Ways To Save Page tests

  @Smoke
  Scenario: Validate Exclusive offers and Rebates, Flexible Financing, Comfort Membership in Ways To Save overview page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Ways to Save
    When I click on Overview button in "Ways To Save" header submenu
    Then it navigates to "https://test.horizonservices.com/ways-to-save"
    When I click on Exclusive offers and Rebates
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    And I navigate back
    When I click on Flexible Financing
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    And I navigate back
    When I click on Comfort Membership
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"


  @Regression
  Scenario: Validate Image Call and Book Now buttons on Ways To Save overview page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Ways to Save
    When I click on Overview button in "Ways To Save" header submenu
    When I click on Book Now button in Image on Ways To Save Overview Page
    Then I should see Book Online Now Window and close it
    When I click on Phone Number in Image on  Ways To Save Overview Page
    Then I can verify Phone call popup

  Scenario: Validate Offer at the bottom of the Ways to Save Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Ways to Save
    When I click on Overview button in "Ways To Save" header submenu
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"