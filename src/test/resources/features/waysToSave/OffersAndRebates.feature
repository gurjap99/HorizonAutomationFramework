Feature: Horizon Service Ways To Save Offers And Rebates Page tests

  Scenario: Validate buttons on Offers And Rebates page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Ways to Save
    When I click on "Offers & Rebates" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Explore Financing button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    When I navigate back
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/ways-to-save"

    Scenario: Validate all offer CTAs and detail links in Offers and Rebates page
      Given I navigate to "https://test.horizonservices.com"
      When I Click on Ways to Save
      When I click on "Offers & Rebates" button in category header submenu
      When I should be able to click on each offer details link and validate CTA