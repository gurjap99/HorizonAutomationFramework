Feature: Horizon Service Ways To Save Page tests

  Scenario: Validate Exclusive offers and Rebates, Flexible Financing, Comfort Membership in Ways To Save overview page
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Ways to Save
    When I click on Overview button in "Ways To Save" header submenu
    Then it navigates to "https://www.horizonservices.com/ways-to-save"
    When I click on Exclusive offers and Rebates
    Then it navigates to "https://www.horizonservices.com/ways-to-save/offers-and-rebates"
    And I can navigate back
    When I click on Flexible Financing
    Then it navigates to "https://www.horizonservices.com/ways-to-save/financing"
    And I can navigate back
    When I click on Comfort Membership
    Then it navigates to "https://www.horizonservices.com/ways-to-save/membership-program"


