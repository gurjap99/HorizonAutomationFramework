Feature: Home Comfort PLP page scenarios

  Scenario: Navigate to Home Comfort PLP page and Verify Schedule today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/ready/hzn/home-comfort"
    When I click on Schedule Today Button in PLP page Image
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup

#  Scenario: Verify page Images and Verify Schedule today and call buttons
#    Given I navigate to "https://test.horizonservices.com/ready/hzn/home-comfort"
#    When I click on Schedule Today button under same-day appointment now
#    Then I should see Book Online Now Window and close it
#    When I click on 3rd Schedule Today button
#    Then I should see Book Online Now Window and close it
#    When I click on 4th Schedule Today button
#    Then I should see Book Online Now Window and close it

  Scenario: Validate Offer at the bottom of the Home comfort PLP Page
    Given I navigate to "https://test.horizonservices.com/ready/hzn/home-comfort"
    When I go to bottom of the homepage
    When I should be able to click on each offer details link and validate CTA
    And I click on View All Offers & Rebates button
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"