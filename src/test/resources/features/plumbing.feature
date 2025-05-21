Feature: Horizon Services plumbing page tests


  Scenario: Validating all Plumbing services available on overview page
    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Plumbing
    And I click on plumbing overview
    And I go to bottom of the homepage
    Then I should see two offer is displaying
    When I click on the "first" offer
    Then I can verify the "first" Offer Detail CTA alignment at bottom of the Page
    And I verify "first" Offer expiry date in offer detail CTA
    When I click on Book Now button in "first" offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "first" offer Details CTA
    #Then I can verify Phone call popup
    Then I close first bottom offer CTA
    When I click on the "second" offer
    Then I can verify the "second" Offer Detail CTA alignment at bottom of the Page
    And I verify "second" Offer expiry date in offer detail CTA
    When I click on Book Now button in "second" offer detail CTA
    Then I should see Book Online Now Window and close it
    #When I click on phone number button in "second" offer Details CTA
    #Then I can verify Phone call popup

  Scenario: Validating Google Review on Plumbing overview page
    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Plumbing
    And I click on plumbing overview
    Then I should see Google review in the home page

  Scenario: Validate Image Call and Book Now buttons on Plumbing overview page

    Given I navigate to "https://www.horizonservices.com/"
    When I Click on Plumbing
    And I click on plumbing overview
    When I click on Book Now button in Image on "Horizon Services plumbing" Page
    Then I should see Book Online Now Window and close it
    When I click on Phone Number in Image on "Horizon Services plumbing" Page
    #Then I can verify Phone call popup

