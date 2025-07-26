Feature: Horizon Services About Us Preferred Brands Page tests

  Scenario: Open About Us Preferred Brands page and verify Book Now, Call buttons, Service buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Preferred Brands" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/about-us/preferred-brands"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Heating & Cooling, it opens Heating & Cooling webpage
    Then I navigate back
    When I click on Explore Plumbing, it opens Plumbing webpage
    When I navigate back
    When I click on Explore Electrical, it opens Electrical webpage

  Scenario: Open About Us Preferred Brands page and verify Offers&Rebates, Financing, Membership buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Preferred Brands" button in category header submenu
    When I click on Exclusive offers and Rebates
    Then it navigates to "https://test.horizonservices.com/ways-to-save/offers-and-rebates"
    And I navigate back
    When I click on Flexible Financing
    Then it navigates to "https://test.horizonservices.com/ways-to-save/financing"
    And I navigate back
    When I click on Comfort Membership
    Then it navigates to "https://test.horizonservices.com/ways-to-save/membership-program"
    And I navigate back
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/about-us"

  Scenario: Open About Us Preferred Brands page and verify other option buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Preferred Brands" button in category header submenu
    When I click on "Reviews" button
    Then it navigates to "https://test.horizonservices.com/about-us/reviews"
    When I navigate back
    When I click on "In the Community" button
    Then it navigates to "https://test.horizonservices.com/about-us/in-the-community"
    When I navigate back
    When I click on "Why Horizon" button
    Then it navigates to "https://test.horizonservices.com/about-us/why-horizon"
    When I navigate back
    When I click on "Work With Us" button
    Then it navigates to "https://test.horizonservices.com/about-us/work-with-us"
    When I navigate back
    When I click on "Contact Us" button
    Then it navigates to "https://test.horizonservices.com/about-us/contact-us"
