Feature: Horizon Services Plumbing Overview Page tests

  Scenario: Validate list of services in Overview of Plumbing
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    Then I can validate the list of all "Plumbing" services and their order

  Scenario: Validate Water Heaters of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Water Heaters"
    Then "Water Heaters" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Water Heaters" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Water Heaters" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/water-heaters"

  Scenario: Validate Kitchen & Bathroom of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Kitchen & Bathroom"
    Then "Kitchen & Bathroom" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Kitchen & Bathroom" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Kitchen & Bathroom" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/kitchen-and-bathroom"

  Scenario: Validate Water Lines of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Water Lines"
    Then "Water Lines" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Water Lines" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Water Lines" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/water-lines"

  Scenario: Validate Drains & Sewer Lines of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Drains & Sewer Lines"
    Then "Drains & Sewer Lines" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Drains & Sewer Lines" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Drains & Sewer Lines" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/drains-and-sewer-lines"

  Scenario: Validate Gas Lines of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Gas Lines"
    Then "Gas Lines" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Gas Lines" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Gas Lines" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/gas-lines"

  Scenario: Validate Sump Pumps of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Sump Pumps"
    Then "Sump Pumps" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Sump Pumps" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Sump Pumps" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/sump-pumps"

  Scenario: Validate Well Pumps of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Well Pumps"
    Then "Well Pumps" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Well Pumps" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Well Pumps" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/well-pumps"

  Scenario: Validate Water Treatment of Plumbing services CTA
    Given I navigate to "https://www.horizonservices.com"
    When I Click on Plumbing
    When I click on Overview button in "Plumbing" header submenu
    When I click on "Plumbing" "Water Treatment"
    Then "Water Treatment" CTA opens and Book now button can be clicked
    Then I should see Book Online Now Window and close it
    #When "Water Treatment" Phone number button in CTA is clicked
    #Then I can verify Phone call popup
    When I click on "Water Treatment" Learn More button
    Then it navigates to "https://www.horizonservices.com/plumbing-services/water-treatment"
