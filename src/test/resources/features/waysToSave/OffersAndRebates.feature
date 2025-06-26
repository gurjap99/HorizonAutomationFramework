Feature: Horizon Service Ways To Save Offers And Rebates Page tests

  Scenario: Validate Book Now, call button, explore membership button in AC Installation page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Ways to Save
    When I click on "Offers & Rebates" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    And I should be able to click on each offer details link and validate CTA

