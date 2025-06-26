Feature: Horizon Services Homepage Elements

  Scenario: Locate all elements on the Horizon Services homepage
    Given I navigate to "https://test.horizonservices.com"
    Then I should locate all header elements
    And I should locate all hero section elements
    And I should locate all services section elements
    And I should locate all testimonial section elements
    And I should locate all special offers section elements
    And I should locate all footer elements
