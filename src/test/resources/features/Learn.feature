Feature: Horizon Services Learns Page tests

  Scenario: Validate list of all learning hub in Learn Page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Learn
    Then I Validate each option opening correct page url
