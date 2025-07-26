Feature: Horizon Service Ways To Save Finance Page tests

  Scenario: Validate call button, other buttons in Finance page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Ways to Save
    When I click on "Financing" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    #When I click on service page Book Now Button
    #Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Explore Offers and Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    When I navigate back
    When I click on call us today phone number button
    Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/ways-to-save"
