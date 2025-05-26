Feature: Horizon Services Learns Page tests

  Scenario: Validate list of services in Overview of Heating & Cooling
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Learn
    Then I Validate each option opening correct page url
