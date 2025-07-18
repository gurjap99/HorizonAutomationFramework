Feature: Horizon Service Ways To Save Membership Page tests

  Scenario: Validate buttons and links in Membership page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Ways to Save
    When I click on "Membership Program" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I click on Explore Financing button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    When I navigate back
    When I click on Explore Offers and Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    When I navigate back
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/ways-to-save"
