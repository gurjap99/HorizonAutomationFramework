Feature: Horizon Services Plumbing Kitchen & Bathroom page tests

  Scenario: Validate Book Now, call button, explore membership button in Kitchen & Bathroom page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Plumbing
    When I click on "Kitchen & Bathroom" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/plumbing-services/kitchen-and-bathroom"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Membership button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    When I navigate back
    When I click on Answers to common questions Phone number button
     Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/plumbing-services"

  Scenario: Validate other services buttons and links
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Plumbing
    When I click on "Kitchen & Bathroom" button in category header submenu
    When I click on "Water Heaters" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/water-heaters"
    When I navigate back
    When I click on "Sump Pumps" button
    Then it navigates to "https://test.horizonservices.com/plumbing-services/sump-pumps"
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

  Scenario: Validate Offer at the bottom of the Page
    Given I navigate to "https://test.horizonservices.com/"
    When I Click on Plumbing
    When I click on "Kitchen & Bathroom" button in category header submenu
    When I go to bottom of the homepage
    Then I should see 2 offers is displaying
    When I click on the 1 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 1 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    When I click on phone number button in 1 offer Details CTA
    Then I can verify Phone call popup
    Then I close bottom offer CTA
    When I click on the 2 offer
    Then I can verify the Offer Detail CTA alignment at bottom of the Page
    And I verify 2 Offer expiry date in offer detail CTA
    When I click on Book Now button in offer detail CTA
    Then I should see Book Online Now Window and close it
    When I click on phone number button in 2 offer Details CTA
    Then I can verify Phone call popup
    Then I close bottom offer CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"