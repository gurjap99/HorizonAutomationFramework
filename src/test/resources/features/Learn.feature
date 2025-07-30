Feature: Horizon Services Learns Page tests

  @Smoke
  Scenario: Validate list of all learning hub in Learn Page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Learn
    Then it navigates to "https://test.horizonservices.com/learning-hub"
    Then I Validate that each article link works and all option opening correct page url and navigate to all article pages