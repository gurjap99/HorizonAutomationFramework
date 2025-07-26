Feature: Horizon Services About Us Why horizon Page tests

  Scenario: Open About Us Why horizon page and verify Book Now, Call buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Why Horizon" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/about-us/why-horizon"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/about-us"

  Scenario: Open About Us Why horizon page and verify other option buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Why Horizon" button in category header submenu
    When I click on "Reviews" button
    Then it navigates to "https://test.horizonservices.com/about-us/reviews"
    When I navigate back
    When I click on "Preferred Brands" button
    Then it navigates to "https://test.horizonservices.com/about-us/preferred-brands"
    When I navigate back
    When I click on "In the community" button
    Then it navigates to "https://test.horizonservices.com/about-us/in-the-community"
    When I navigate back
    When I click on "Work With Us" button
    Then it navigates to "https://test.horizonservices.com/about-us/work-with-us"
    When I navigate back
    When I click on "Contact Us" button
    Then it navigates to "https://test.horizonservices.com/about-us/contact-us"
