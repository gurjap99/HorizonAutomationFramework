Feature: Horizon Services home page tests

  Scenario: Validate Sign Up page
    Given I navigate to "https://test.horizonservices.com/signup"
    When I populate all the fields of sign up page and check checkboxes
    Then Sign up button should be disabled
