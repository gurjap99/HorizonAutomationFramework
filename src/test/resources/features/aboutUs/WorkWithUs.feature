Feature: Horizon Services About Us Work With Us Page tests

  Scenario: Open About Us Work With Us page and verify Book Now, Call buttons, Service buttons:
    Given I navigate to "https://www.horizonservices.com"
    When I Click on About Us
    When I click on "Work With Us" button in category header submenu
    Then it navigates to "https://www.horizonservices.com/about-us/work-with-us"
    When I click on 3 Explore Careers each takes to "https://jobs.horizonservices.com/"

  Scenario: Open About Us Work With Us page and verify other option buttons:
    Given I navigate to "https://www.horizonservices.com"
    When I Click on About Us
    When I click on "Work With Us" button in category header submenu
    When I click on "Why Horizon" button
    Then it navigates to "https://www.horizonservices.com/about-us/why-horizon"
    When I navigate back
    When I click on "Preferred Brands" button
    Then it navigates to "https://www.horizonservices.com/about-us/preferred-brands"
    When I navigate back
    When I click on "In the Community" button
    Then it navigates to "https://www.horizonservices.com/about-us/in-the-community"
    When I navigate back
    When I click on "Reviews" button
    Then it navigates to "https://www.horizonservices.com/about-us/reviews"
    When I navigate back
    When I click on "Contact Us" button
    Then it navigates to "https://www.horizonservices.com/about-us/contact-us"
