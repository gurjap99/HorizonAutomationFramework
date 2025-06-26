Feature: Validate phone numbers on Horizon Services homepage
  Scenario: Verify all phone numbers with id 'phonenumber' are visible and clickable
    Given I navigate to "https://test.horizonservices.com"
    Then I should see all phone numbers with id phonenumber displayed and clickable