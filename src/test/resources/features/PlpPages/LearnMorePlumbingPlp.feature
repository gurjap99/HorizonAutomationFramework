Feature: Learn More Plumbing PLP page scenarios

  Scenario: Navigate to Learn More Plumbing PLP page and Verify Book today and call buttons in image
    Given I navigate to "https://test.horizonservices.com/learn-more/plumbing"
    When I click on Book Now button in Image on home screen
    Then I should see Book Online Now Window and close it
    When I click on Phone Number button in PLP page Image
    Then I can verify Phone call popup
