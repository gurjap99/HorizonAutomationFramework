Feature: Horizon Services About Us Contact Us Page tests

  Scenario: Open About Us Why horizon page and verify Book Now, Call buttons, Service buttons:
    Given I navigate to "https://test.horizonservices.com"
    When I Click on About Us
    When I click on "Contact Us" button in category header submenu
    Then it navigates to "https://test.horizonservices.com/about-us/contact-us"
    When I click on service page Book Now Button
    Then I should see Book Online Now Window and close it
    When I click on service page Phone number button
    Then I can verify Phone call popup
    When I click on Explore Heating & Cooling, it opens Heating & Cooling webpage
    Then I navigate back
    When I click on Explore Plumbing, it opens Plumbing webpage
    When I navigate back
    When I click on Explore Electrical, it opens Electrical webpage
    When I navigate back
    When I click on breadcrumb button
    Then it navigates to "https://test.horizonservices.com/about-us"

  Scenario: Validate Map Zipcode Input and Book Now
    Given I navigate to "https://www.horizonservices.com"
    When I Click on About Us
    When I click on "Contact Us" button in category header submenu
    When I update Zipcode "19808" using map zipcode input in Contact Us page
    Then Map should get updated
    And "Your home is in our service area!" appears, Zip code "19808" should be update in the home page
    When I update Zipcode "21244" using map zipcode input in Contact Us page
    Then Map should get updated
    And "Your home is in our service area!" appears, Zip code "21244" should be update in the home page
    When I click map Input Book Now button
    Then I should see Book Online Now Window and close it
