Feature: Horizon Services Learns Page tests

  Scenario: Validate list of all learning hub in Learn Page
    Given I navigate to "https://test.horizonservices.com"
    When I Click on Learn
    Then it navigates to "https://test.horizonservices.com/learning-hub"
    Then I Validate each option opening correct page url and navigate to page "3"
    And it navigates to "https://test.horizonservices.com/learning-hub/page/3"