Feature: Horizon Services Plumbing Water Heaters page tests

  Scenario: Validate Book Now, call button, explore membership button in Water Heaters page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Plumbing
    When I click on "Water Heaters" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/plumbing-services/water-heaters"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Explore Financing button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    When I navigate back
    When I click on Answers to common questions Phone number button
     Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/plumbing-services"

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Plumbing
    When I click on "Water Heaters" button in category header submenu
    When I click on "Sump Pumps" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/sump-pumps"
    When I navigate back
    When I click on "Kitchen & Bathroom" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/kitchen-and-bathroom"
    When I navigate back
    When I click on "Water Lines" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/water-lines"
    When I navigate back
    When I click on "Drains & Sewer Lines" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/drains-and-sewer-lines"
    When I navigate back
    When I click on "Water Treatment" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/water-treatment"
    When I navigate back
    When I click on "Gas Lines" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/gas-lines"
    When I navigate back
    When I click on "Well Pumps" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/well-pumps"

  Scenario: Validate Offer at the bottom of the Water Heaters Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Plumbing
    When I click on "Water Heaters" button in category header submenu
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"