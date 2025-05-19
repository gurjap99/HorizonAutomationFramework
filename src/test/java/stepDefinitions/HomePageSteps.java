package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Footer;
import pages.Header;
import pages.HomePage;
import utils.ConfigReader;
import utils.Data;
import utils.DriverFactory;
import utils.Helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class HomePageSteps {
    private final HomePage homePage;
    private final String platform;
    private WebDriver driver;
    private String phoneNumber = null;

    public HomePageSteps() {
        this.driver = DriverFactory.getDriver();
        platform = ConfigReader.get("platform");
        homePage = new HomePage(driver);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1512, 712));
    }


    @Then("I should see the page title as {string}")
    public void i_should_see_the_page_title_as(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //  driver.quit();
        //driver = DriverFactory.getDriver();
        //assertTrue(driver.getTitle().contains(title));
    }

    @Then("all the links on the page should be valid")
    public void all_the_links_on_the_page_should_be_valid() {
        driver = DriverFactory.getDriver();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or null: " + link.getText());
                continue;
            }
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("Broken link: " + url + " --> Code: " + responseCode);
                } else {
                    System.out.println("Valid link: " + url + " --> Code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println("Error checking link: " + url + " --> " + e.getMessage());
            }
        }
    }

    @When("I extract all the elements based on tag from config")
    public void i_extract_all_elements_from_config() {
        String tagName = ConfigReader.get("htmltag");
        assert tagName != null;
        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        System.out.println("Total <" + tagName + "> elements found: " + elements.size());
        for (WebElement e : elements) {
            String url = e.getAttribute("href");
            System.out.println("Found: " + url);
        }
    }

    @Then("I verify each link is working")
    public void i_verify_each_link_is_working() {
        String tag = ConfigReader.get("htmltag");
        if (tag == null || tag.trim().isEmpty()) {
            throw new IllegalArgumentException("htmlTag is not defined or is empty in config.properties");
        }
        List<WebElement> elements = DriverFactory.getDriver().findElements(By.tagName(tag));
        List<String> validLinks = new ArrayList<>();
        List<String> brokenLinks = new ArrayList<>();
        System.out.println("Number of elements found with tag <" + tag + ">: " + elements.size());
        for (WebElement e : elements) {
            String url = e.getAttribute("href");
            if (url == null || url.isEmpty() || !url.startsWith("http")) {
                continue;
            }


            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                conn.connect();
                int code = conn.getResponseCode();
                if (code >= 400) {
                    brokenLinks.add(url + " -- Code: " + code);
                } else {
                    validLinks.add(url + " -- Code: " + code);
                }
            } catch (Exception ex) {
                brokenLinks.add(url + " -- Error: " + ex.getMessage());
            }
            writeToFile("target/valid_links.txt", validLinks);
            writeToFile("target/broken_links.txt", brokenLinks);
            System.out.println("Links written to files.");
        }
    }

    private void writeToFile(String fileName, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    @Then("I should see the text {string}")
    public void i_should_see_the_text(String expectedText) {
        String pageSource = driver.getPageSource();
        if (pageSource.contains(expectedText)) {
            System.out.println("Text is visible: " + expectedText);
        } else {
            throw new AssertionError("Expected text not found: " + expectedText);
        }
    }

    @Then("I click on the Offer Details link")
    public void i_click_on_the_offer_details_link() {
        try {
            //  By offerDetailsSelector = By.cssSelector("body > div:nth-child(24) > div:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > a:nth-child(1)");
            By offerDetailsSelector = By.xpath("//body/div[6]/div[9]/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // WebElement offerLink = wait.until(ExpectedConditions.elementToBeClickable(offerDetailsSelector));
            WebElement offerLink = wait.until(ExpectedConditions.presenceOfElementLocated(offerDetailsSelector));
            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", offerLink);
            // Wait until it's clickable
            wait.until(ExpectedConditions.elementToBeClickable(offerLink));

            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", offerLink);
            offerLink.click();
            System.out.println("Clicked on Offer Details link using CSS selector.");
            // Step 2: Switch to iframe (adjust selector as needed)
            //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//div[contains(@class,'relative z-10 flex h-[inherit] w-[22.625rem] sm:w-[29.5rem] flex-col rounded-lg bg-white p-[1.438rem] shadow-lg sm:py-[2.375rem] sm:pl-[2.375rem] sm:pr-[2.813rem]')])[5]")));
            // System.out.println("Switched to iframe.");

            // Wait and verify Book Now button is present
            By bookNowBtn = By.xpath("(//span[contains(text(), 'Book') and contains(text(), 'now')])[1]");

            WebElement bookNow = wait.until(ExpectedConditions.visibilityOfElementLocated(bookNowBtn));
            if (bookNow.isDisplayed()) {
                System.out.println("Book Now button is visible after clicking Offer Details.");
            } else {
                throw new AssertionError("Book Now button is not visible.");
            }
        } catch (Exception e) {
            throw new AssertionError("Failed to click Offer Details or find Book Now: " + e.getMessage());
        }

    }

    @Then("I should see all phone numbers with id phonenumber displayed and clickable")
    public void all_phone_numbers_with_same_id_are_displayed_and_clickable() {
        List<WebElement> phoneElements = driver.findElements(By.xpath("//span[@id='phoneNumber']"));
        if (phoneElements.isEmpty()) {
            throw new AssertionError("No phone numbers found with id='phonenumber'");
        }
        System.out.println("Total phone number elements found: " + phoneElements.size());
        int count = 1;
        for (WebElement phone : phoneElements) {
            System.out.println("\n--- Checking phone number #" + count + " ---");
            count++;
            try {
                // Scroll into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phone);
                Thread.sleep(500); // brief pause to allow scroll
                // Check visibility
                if (!phone.isDisplayed()) {
                    System.out.println("Phone number not visible: " + phone.getText());
                    continue;
                }
                // Check if clickable wrapper exists
                WebElement clickableParent = null;
                try {
                    clickableParent = phone.findElement(By.xpath("ancestor::*[self::a or @onclick or @role='button']"));
                } catch (Exception ignored) {
                }
                if (clickableParent != null && clickableParent.isDisplayed()) {
                    System.out.println("Phone number is wrapped in a clickable element.");
                } else {
                    throw new AssertionError("Phone number is not wrapped in a clickable element.");
                }
            } catch (Exception e) {
                throw new AssertionError("Error with phone number element: " + e.getMessage());
            }
        }
    }

    @Then("I should locate all header elements")
    public void iShouldLocateAllHeaderElements() {
        homePage.getAllHeaderElements();
    }

    @Then("I should locate all hero section elements")
    public void iShouldLocateAllHeroSectionElements() {
        homePage.getAllHeroSectionElements();
    }

    @Then("I should locate all services section elements")
    public void iShouldLocateAllServicesSectionElements() {
        homePage.getAllServicesSectionElements();
    }

    @Then("I should locate all testimonial section elements")
    public void iShouldLocateAllTestimonialSectionElements() {
        homePage.getAllTestimonialsSectionElements();
    }

    @Then("I should locate all special offers section elements")
    public void iShouldLocateAllSpecialOffersSectionElements() {
        homePage.getAllSpecialOffersSectionElements();
    }

    @Then("I should locate all footer elements")
    public void iShouldLocateAllFooterElements() {
        homePage.getAllFooterElements();
    }

    @Then("both CTAs with plus icons should be clickable and show Book Now button")
    public void both_ctas_with_plus_icons_should_be_clickable_and_show_book_now_button() {
        String[] ctaCssSelectors = {
                "body > div:nth-child(24) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1)",
                "body > div:nth-child(24) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1)"
        };
        for (int i = 0; i < ctaCssSelectors.length; i++) {
            try {
                WebElement svgIcon = driver.findElement(By.cssSelector(ctaCssSelectors[i]));
                svgIcon.click();
                Thread.sleep(1000);
                // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", svgIcon);
                //  Thread.sleep(1000);
                // Click the parent anchor or button around the SVG

                String headerText = driver.findElement(By.xpath("(//h2[normalize-space()='No sweat. We offer same-day service.'])[1]")).getText();
                System.out.println(headerText);
                WebElement clickable = svgIcon.findElement(By.cssSelector("div[class='visible opacity-100'] div[class='mb-4 h-[3.125rem] w-full rounded-lg py-3 text-[1.125rem] leading-[1.575rem] text-white sm:block sm:w-[12.563rem]'] a[role='button']"));
                ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", clickable);
                Thread.sleep(1000);

                if (clickable.isDisplayed() && clickable.isEnabled()) {
                    System.out.println("Clicking CTA #" + (i + 1));
                    // clickable.click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Book Now')]")));
                    homePage.getCloseCTAButton().click();
                    //  WebElement bookNow = driver.findElement(By.xpath("//button[contains(text(), 'Book Now')]"));
                    //if (bookNow.isDisplayed() && bookNow.isEnabled()) {
                    //  System.out.println("Book Now button is visible and clickable for CTA #" + (i + 1));
                    // WebElement closeCTA = driver.findElement(By.cssSelector("div[class='visible opacity-100'] div[role='Close'] svg"));
                    //closeCTA.click();
                    //} else {
                    //  System.out.println("Book Now button not clickable for CTA #" + (i + 1));
                    //}
                    driver.navigate().back();
                    Thread.sleep(2000);
                } else {
                    System.out.println("CTA #" + (i + 1) + " not clickable.");
                }
            } catch (Exception e) {
                System.out.println("Error with CTA #" + (i + 1) + ": " + e.getMessage());
            }
        }
    }

    @When("I click on offer banner")
    public void iClickOnOfferBanner() {
        Helper.alternateClick(driver, homePage.getOfferBannerPlusIcon(), Duration.ofSeconds(15));
    }

    @Then("I can verify the Offer Banner CTA alignment")
    public void verifyOfferBannerCTAAlignmentIsLeftForDesktopAndRightForMobile() {
        WebElement ctaElement = homePage.getCtaElement();
        int xCoordinate = ctaElement.getLocation().getX();
        System.out.println("CTA Position - X: " + xCoordinate);

        if (platform.equalsIgnoreCase("desktop")) {
            Assert.assertEquals("CTA alignment is not correct for Desktop ", 0, xCoordinate);
            System.out.println("CTA is on the left side of the screen.");
        } else if (platform.equalsIgnoreCase("mobile-browserstack")) {
            Assert.assertTrue("CTA alignment is not correct for Mobile ", xCoordinate > 0);
        } else {
            Assert.fail("Platform is incorrect");
        }
    }

    @And("Offer expiry date in offer banner CTA")
    public void iCanVerifyOfferCTAExpiryDate() {
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        String formattedDate = lastDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        String expectedFormattedDate = "Expires " + formattedDate + ".";

        WebElement actualDateElement = homePage.getOfferExpiryDate();
        String actualDate = actualDateElement.getAttribute("textContent");
        Assert.assertEquals(expectedFormattedDate, actualDate);
    }

    @When("I click on Book Now button in offer banner CTA")
    public void iClickOnBookNowButtonInOfferCTA() {
        Helper.clickElementUsingActions(driver, homePage.getOfferCTABookNowButton(), Duration.ofSeconds(15));
    }

    @Then("I should see Book Online Now Window and close it")
    public void iShouldSeeBookOnlineNowWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(homePage.getBookOnlineNowFrame()));
        WebElement close = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(homePage.getBookNowWindowCloseButton()));
        close.click();
        driver.switchTo().defaultContent();
    }

    @When("I click on phone number button in offer banner CTA")
    public void iClickOnPhoneNumberButtonInOfferBannerCTA() {
        Helper.clickElement(driver, homePage.getOfferCTAPhoneNumberButton(), Duration.ofSeconds(30));
    }

    @When("I click on Explore Heating & Cooling, it opens Heating & Cooling webpage")
    public void iClickOnExploreHeatingCoolingICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(driver, homePage.getExploreHeatingCoolingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Heating & Cooling URL does not match ",
                Data.HEATING_COOLING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Plumbing, it opens Plumbing webpage")
    public void iClickOnExplorePlumbingICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(driver, homePage.getExplorePlumbingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Plumbing URL does not match ", Data.PLUMBING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Electrical, it opens Electrical webpage")
    public void iClickOnExploreElectricalICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(driver, homePage.getExploreElectricalButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Electrical URL does not match ", Data.ELECTRICAL_URL, driver.getCurrentUrl());
    }

    @Then("I can navigate back to home page")
    public void iCanNavigateBackToHomePage() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1500);
    }

    @When("I click on Book Now button in Image on home screen")
    public void iClickOnBookNowButtonInImageOnHomeScreen() {
        Helper.clickElementUsingActions(driver, homePage.getImageBookNowButton(), Duration.ofSeconds(15));
    }

    @When("I click on phone number button in in Image on home screen")
    public void iClickOnPhoneNumberButtonInInImageOnHomeScreen() {
        Helper.clickElement(driver, homePage.getImagePhoneNumberButton(), Duration.ofSeconds(15));
    }

    @When("Click on Help my air conditioner won’t turn on! option")
    public void clickOnHelpMyAirConditionerWonTTurnOnOption() {
        Helper.scrollToViewAndClickElement(driver, homePage.getHelpMyAirConditioner(), Duration.ofSeconds(15));
        System.out.println("Clicked on Help my air conditioner won’t turn on! option");
    }

    @Then("I should see and click on Book Now button on flashed air conditioner frame")
    public void iShouldSeeBookNowButtonOnFlasedFrame() {
        try {
            Helper.clickElementUsingActions(driver, homePage.getAirConditionerBookNowButton(), Duration.ofSeconds(15));
        } catch (Exception e) {
            throw new AssertionError("Failed to click Book Now: " + e.getMessage());
        }
    }



    @Then("I should see and click on phone number on flashed air conditioner frame")
    public void iShouldSeePhoneNumberOnFlashedFrame() {
        try {
            Helper.clickElementUsingActions(driver, homePage.getAirConditionerPhoneNumberButton(), Duration.ofSeconds(15));
        } catch (Exception e) {
            throw new AssertionError("Failed to click Phone number: " + e.getMessage());
        }
    }

    @When("Click on Do you install tankless water heaters option")
    public void clickOnDoYouInstallTanklessWaterHeatersOption() {
        Helper.scrollToViewAndClickElement(driver, homePage.getInstallTanklessWaterHeater(), Duration.ofSeconds(15));
        System.out.println("Clicked on Do you install tankless water heaters option");
    }

    @Then("I should see and click on Book Now button on flashed water tank frame")
    public void iShouldSeeBookNowButtonOnFlashedWaterTankFrame() {
        try {
            Helper.clickElementUsingActions(driver, homePage.getWaterTankBookNowButton(), Duration.ofSeconds(15));
        } catch (Exception e) {
            throw new AssertionError("Failed to click Book Now: " + e.getMessage());
        }

    }

    @Then("I should see and click on phone number on flashed water tank frame")
    public void iShouldSeePhoneNumberOnFlashedWaterTankFrame() {
        try {
            Helper.clickElementUsingActions(driver, homePage.getWaterTankPhoneNumberButton(), Duration.ofSeconds(15));
        } catch (Exception e) {
            throw new AssertionError("Failed to click Phone number: " + e.getMessage());
        }
    }

    @When("Click on emergency service option")
    public void clickOnEmergencyServiceOption() {
        Helper.scrollToViewAndClickElement(driver, homePage.getEmergencyService(), Duration.ofSeconds(15));
        System.out.println("Clicked on Help, I need 24/7 emergency service! option");
    }

    @Given("I navigate to {string} with javaScript turned off, then I visible phone numbers should be same as static" +
            " phone number")
    public void iNavigateToWithJavaScriptTurnedOff(String url) {
        if (platform.equalsIgnoreCase("desktop")) {
            // turn javaScript off
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.managed_default_content_settings.javascript", 2); // 2 = Block
            options.setExperimentalOption("prefs", prefs);

            WebDriver driver = new ChromeDriver(options);
            HomePage homePage = new HomePage(driver);
            Header header = new Header(driver);
            Footer footer = new Footer(driver);
            driver.get(url);
            driver.manage().window().setSize(new Dimension(1512, 712));

            String headerPhoneNumber = header.getHeaderPhoneNumberButton().getText();
            String imagePhoneNumber = homePage.getImagePhoneNumberButton().getText();
            String peaceOfMindPhoneNumber = footer.getPeaceOfMindCallButton().getText();

            Assert.assertEquals("Header Phone number does not match static number ",
                    Data.STATIC_PHONE_NUMBER, headerPhoneNumber);
            Assert.assertEquals("homepage image number does not match static number ",
                    Data.STATIC_PHONE_NUMBER, imagePhoneNumber);
            Assert.assertEquals("Footer Phone number does not match static number ",
                    Data.STATIC_PHONE_NUMBER, peaceOfMindPhoneNumber);
            driver.quit();
        }
    }

    @When("I update Zipcode {string} using eyebrow button")
    public void iUpdateZipcodeUsingEyebrowButton(String zipcode) {
        homePage.getEyebrowZipCode().click();
        homePage.setEyebrowZipCodeInputField(zipcode);
        homePage.setEyebrowZipCodeInputField(zipcode);
    }

    @Then("{string} appears, {string} Zipcode gets updates properly, Map and map zipcode input disappears")
    public void appearsZipcodeGetsUpdatesProperlyMapAndMapZipcodeInputDisappears(String updateMessage, String zipcode) {
        try {
            Thread.sleep(2000);
            String actualUpdateMessage = homePage.getEyebrowZipCodeMessage().getText();
            Assert.assertEquals("message does not match", updateMessage, actualUpdateMessage);

            Helper.retry(() -> {
                homePage.getEyebrowZipCodeUpdateButton().click();
                return null;
            }, Duration.ofSeconds(10));

            Thread.sleep(2000);
            String eyeBrowZipcode = homePage.getEyebrowZipCode().getText();
            Assert.assertEquals("zipcode does not match", eyeBrowZipcode, zipcode);
            Assert.assertFalse("Map is visible", homePage.isMapDisplayed());
            Assert.assertFalse("Map Input is visible", homePage.isInputFieldDisplayed());
            if (!Objects.equals(zipcode, "27606") && !Objects.equals(zipcode, "28025")) {
                phoneNumber = homePage.getImagePhoneNumberButton().getText();
            }
        } catch (Exception e) {
            throw new AssertionError("Issue with zip code update: " + e.getMessage());
        }
    }

    @Then("North Carolina phone number appears instead of existing phone number")
    public void northCarolinaPhoneNumberAppearsInsteadOfExistingPhoneNumber() {
        Header header = new Header(driver);
        Footer footer = new Footer(driver);
        if (phoneNumber != null) {
            Assert.assertNotEquals("Phone number is not of NC", phoneNumber,
                    homePage.getImagePhoneNumberButton().getText());
            Assert.assertNotEquals("Phone number is not of NC", phoneNumber,
                    header.getHeaderPhoneNumberButton().getText());
            Assert.assertNotEquals("Phone number is not of NC", phoneNumber,
                    footer.getPeaceOfMindCallButton().getText());
        }
        else {
            Assert.fail("Phone number is null");
        }
    }

    @Then("{string} appears and update Zipcode is disabled, Map and map zipcode Input is visible")
    public void appearsAndUpdateZipcodeIsDisabled(String updateMessage) throws InterruptedException {
        Thread.sleep(2000);
        String actualUpdateMessage = homePage.getEyebrowZipCodeMessage().getText();
        Assert.assertEquals("message does not match", updateMessage, actualUpdateMessage);
        homePage.getCloseCTAButton().click();
        Thread.sleep(2000);
        Assert.assertTrue("Map is not visible", homePage.isMapDisplayed());
        Assert.assertTrue("Map Input is not visible", homePage.isInputFieldDisplayed());
    }

    @When("I update Zipcode {string} using map zipcode input")
    public void iUpdateZipcodeUsingMapZipcodeInput(String zipcode) {
        homePage.setMapInputField(zipcode);
        Helper.clickElementUsingActions(driver, homePage.getMapZipcodeInputSearchButton(), Duration.ofSeconds(20));
    }

    @Then("{string} appears, Zip code {string} should be update in the home page")
    public void zipCodeShouldBeUpdateInTheHomePage(String message, String zipcode) {
        String actualMessage = homePage.getMapZipcodeInputMessage().getText();
        String actualEyebrowZipcode = homePage.getEyebrowZipCode().getText();
        Assert.assertEquals("zipcode message does not match", message, actualMessage);
        Assert.assertEquals("zipcode does not match with eyebrow zipcode", zipcode, actualEyebrowZipcode);
    }

    @When("I click map Input Book Now button")
    public void iClickMapInputBookNowButton() {
        Helper.clickElementUsingActions(driver, homePage.getMapBookNowButton(), Duration.ofSeconds(20));
    }

    @When("I go to bottom of the homepage")
    public void iGoToBottomOfTheHomepage() {
        WebElement element = homePage.getFirstOfferAtBottom();
        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    @Then("I should see two offer is displaying")
    public void iShouldSeeTwoOfferIsDisplaying() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the element to be visible
        WebElement firstOffer = wait.until(ExpectedConditions.visibilityOf(homePage.getFirstOfferAtBottom()));
        WebElement secondOffer = wait.until(ExpectedConditions.visibilityOf(homePage.getSecondOfferAtBottom()));
        // Assert that the element is displayed
        assert firstOffer.isDisplayed() : "First offer is not visible on the page";
        assert secondOffer.isDisplayed() : "Second offer is not visible on the page";
    }

    @When("I click on the {string} offer")
    public void iClickOnTheOffer(String offer) {
        if(offer.equalsIgnoreCase("first")) {
            Helper.scrollToViewAndClickElement(driver, homePage.getFirstOfferDetailsLink(), Duration.ofSeconds(15));
            System.out.println("Clicked on the first offer details link");
        }else{
            Helper.scrollToViewAndClickElement(driver, homePage.getSecondOfferDetailsLink(), Duration.ofSeconds(15));
            System.out.println("Clicked on the second offer details link");
        }
    }

    @When("I click on Book Now button in {string} offer detail CTA")
    public void iClickOnBookNowButtonInOfferDetailCTA(String offer) {
        if(offer.equalsIgnoreCase("first")) {
            Helper.clickElementUsingActions(driver, homePage.getFirstOfferDetailCTABookNowButton(), Duration.ofSeconds(30));
        } else{
            Helper.clickElementUsingActions(driver, homePage.getSecondOfferDetailCTABookNowButton(), Duration.ofSeconds(30));
        }
    }

    @Then("I can verify the {string} Offer Detail CTA alignment at bottom of the Page")
    public void iCanVerifyTheOfferDetailCTAAlignmentAtBottomOfThePage(String offer) {
        WebElement ctaElement;
        if(offer.equalsIgnoreCase("first")) {
            ctaElement = homePage.getFirstOfferDetailCtaElement();
        }else {
            ctaElement = homePage.getSecondOfferDetailCtaElement();
        }
        int xCoordinate = ctaElement.getLocation().getX();
        System.out.println("CTA Position - X: " + xCoordinate);

        if (platform.equalsIgnoreCase("mobile-browserstack")) {
            Assert.assertEquals("CTA alignment is not correct for Mobile ", 0, xCoordinate);
            System.out.println("CTA is on the left side of the screen.");
        } else if (platform.equalsIgnoreCase("desktop")) {
            Assert.assertTrue("CTA alignment is not correct for Desktop ", xCoordinate > 0);
            System.out.println("CTA is on the right side of the screen.");
        } else {
            Assert.fail("Platform is incorrect");
        }
    }

    @And("I verify {string} Offer expiry date in offer detail CTA")
    public void iVerifyOfferExpiryDateInOfferDetailCTA(String offer) {
        WebElement actualDateElement;
        if(offer.equalsIgnoreCase("first")){
            actualDateElement = homePage.getFirstOfferDetailExpiryDate();
        }else{
            actualDateElement = homePage.getSecondOfferDetailExpiryDate();
        }
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        String formattedDate = lastDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        String expectedFormattedDate = "Expires " + formattedDate + ".";
        String actualDate = actualDateElement.getAttribute("textContent");
        Assert.assertEquals(expectedFormattedDate, actualDate);
    }

    @When("I click on phone number button in {string} offer Details CTA")
    public void iClickOnPhoneNumberButtonInOfferDetailsCTA(String offer) {
        if(offer.equalsIgnoreCase("first")){
            Helper.clickElement(driver, homePage.getFirstOfferDetailsCTAPhoneNumber(), Duration.ofSeconds(30));
        }else{
            Helper.clickElement(driver, homePage.getSecondOfferDetailsCTAPhoneNumber(), Duration.ofSeconds(30));
        }
    }

    @Then("I close first bottom offer CTA")
    public void iCloseFirstBottomOfferCTA() {
        Helper.clickElement(driver, homePage.getCloseFirstOfferCTAButton(), Duration.ofSeconds(30));
    }
}




