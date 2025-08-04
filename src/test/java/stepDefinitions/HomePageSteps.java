package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Footer;
import pages.Header;
import pages.HomePage;
import utils.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    private static final String VERCEL_BYPASS_SECRET = ConfigReader.get("VERCEL_BYPASS_SECRET");

    // Optional: Set to true if you want Vercel to set a bypass cookie for subsequent requests
    private static final boolean SET_BYPASS_COOKIE = true;
    // Optional: Set to "samesitenone" if accessing indirectly (e.g., iframe)
    private static final String BYPASS_COOKIE_SAMESITE = ConfigReader.get("VERCEL_BYPASS_COOKIE");
    // or "samesitenone"

    public String iNavigateToWithVercelBypass(String url) {
        // Construct the URL with the bypass query parameters
        StringBuilder bypassUrl = new StringBuilder(url);

        bypassUrl.append("?x-vercel-protection-bypass=").append(VERCEL_BYPASS_SECRET);

        // Add the cookie bypass parameter if enabled
        if (SET_BYPASS_COOKIE) {
            bypassUrl.append("&x-vercel-set-bypass-cookie=").append(BYPASS_COOKIE_SAMESITE);
        }
        return bypassUrl.toString();
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        if (url.startsWith("https://test") || url.startsWith("https://dev")){
            url = iNavigateToWithVercelBypass(url);
        }
        driver.get(url);
//        driver.manage().window().setSize(new Dimension(1980, 1080));
        driver.manage().window().maximize();
    }


    @Then("I should see the page title as {string}")
    public void i_should_see_the_page_title_as(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
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
        String headerOfferTitle = homePage.getHeaderOfferTitle().getAttribute("textContent");
        String expectedIsoDate = ApiUtil.getExpiryDateByTitle(headerOfferTitle);
        String expectedFormattedDate = "Expires " + Helper.formatExpiryDate(expectedIsoDate);
        WebElement actualDateElement = homePage.getOfferExpiryDate();
        String actualDate = actualDateElement.getAttribute("textContent");
        Assert.assertEquals(expectedFormattedDate, actualDate);
    }

    @When("I click on Book Now button in offer banner CTA")
    public void iClickOnBookNowButtonInOfferCTA() {
        Helper.clickElement(driver, homePage.getOfferCTABookNowButton(), Duration.ofSeconds(20));
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
        Helper.clickElement(driver, homePage.getExploreHeatingCoolingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Heating & Cooling URL does not match ",
                Data.HEATING_COOLING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Plumbing, it opens Plumbing webpage")
    public void iClickOnExplorePlumbingICanNavigateBackToHomePage() {
        Helper.scrollToElement(driver, homePage.getExplorePlumbingButton());
        Helper.clickElement(driver, homePage.getExplorePlumbingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Plumbing URL does not match ", Data.PLUMBING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Electrical, it opens Electrical webpage")
    public void iClickOnExploreElectricalICanNavigateBackToHomePage() throws InterruptedException {
        Helper.scrollToElement(driver, homePage.getExploreElectricalButton());
        Thread.sleep(1000);
        Helper.clickElement(driver, homePage.getExploreElectricalButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Electrical URL does not match ", Data.ELECTRICAL_URL, driver.getCurrentUrl());
    }

    @Then("I can navigate back to home page")
    public void iCanNavigateBackToHomePage() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1500);
    }

    @When("I click on Book Now button in Image on home screen")
    public void iClickOnBookNowButtonInImageOnHomeScreen() {
        Helper.scrollToElement(driver, homePage.getImageBookNowButton());
        Helper.clickElement(driver, homePage.getImageBookNowButton(), Duration.ofSeconds(15));
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
    public void iShouldSeeBookNowButtonOnFlashedFrame() {
        try {
            Helper.clickElement(driver, homePage.getAirConditionerBookNowButton(), Duration.ofSeconds(15));
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
            if (url.startsWith("https://test") || url.startsWith("https://dev")){
                url = iNavigateToWithVercelBypass(url);
            }
            driver.get(url);
            driver.manage().window().maximize();

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
    }

    @Then("{string} appears, {string} Zipcode gets updates properly, Map and map zipcode input disappears")
    public void appearsZipcodeGetsUpdatesProperlyMapAndMapZipcodeInputDisappears(String updateMessage, String zipcode) {
        try {
            Thread.sleep(3000);
            String actualUpdateMessage = homePage.getEyebrowZipCodeMessage().getText();
            Assert.assertEquals("message does not match", updateMessage, actualUpdateMessage);

            Helper.retry(() -> homePage.getEyebrowZipCodeUpdateButton().click(), Duration.ofSeconds(10));

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
        } else {
            Assert.fail("Phone number is null");
        }
    }

    @Then("{string} appears and update Zipcode is disabled, Map and map zipcode Input is visible")
    public void appearsAndUpdateZipcodeIsDisabled(String updateMessage) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the update message is visible and has the expected text
            wait.until(driver -> {
                String text = homePage.getEyebrowZipCodeMessage().getText();
                return text != null && !text.trim().isEmpty();
            });

            String actualUpdateMessage = homePage.getEyebrowZipCodeMessage().getText();
            Assert.assertEquals("message does not match", updateMessage, actualUpdateMessage);

            homePage.getCloseCTAButton().click();

            // scroll to mid
            JavascriptExecutor js = (JavascriptExecutor) driver;
            long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
            // Calculate the middle point
            long midPoint = scrollHeight / 2;
            // Scroll to the calculated mid-point
            js.executeScript("window.scrollTo(0, " + midPoint + ");");

            // Wait until the map is visible
            wait.until(driver -> homePage.isMapDisplayed());
            Assert.assertTrue("Map is not visible", homePage.isMapDisplayed());

            // Wait until the input field is visible
            wait.until(driver -> homePage.isInputFieldDisplayed());
            Assert.assertTrue("Map Input is not visible", homePage.isInputFieldDisplayed());
        }


    @When("I update Zipcode {string} using map zipcode input")
    public void iUpdateZipcodeUsingMapZipcodeInput(String zipcode) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        // Calculate the middle point
        long midPoint = scrollHeight / 2;
        // Scroll to the calculated mid-point
        js.executeScript("window.scrollTo(0, " + midPoint + ");");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(homePage.getMap()));
        homePage.setMapInputField(zipcode);
        Helper.clickElement(driver, homePage.getMapZipcodeInputSearchButton(), Duration.ofSeconds(20));
    }

    @Then("{string} appears, Zip code {string} should be update in the home page")
    public void zipCodeShouldBeUpdateInTheHomePage(String message, String zipcode) {
        Helper.retry(()->{
        String actualMessage = homePage.getMapZipcodeInputMessage().getText();
        String actualEyebrowZipcode = homePage.getEyebrowZipCode().getText();
        Assert.assertEquals("zipcode message does not match", message, actualMessage);
        Assert.assertEquals("zipcode does not match with eyebrow zipcode", zipcode, actualEyebrowZipcode);
        }, Duration.ofSeconds(30));
    }

    @When("I click map Input Book Now button")
    public void iClickMapInputBookNowButton() {
        Helper.clickElement(driver, homePage.getMapBookNowButton(), Duration.ofSeconds(20));
    }

    @When("I go to bottom of the homepage")
    public void iGoToBottomOfTheHomepage() {
        WebElement element = homePage.getOffersAtBottom(1);
        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    @Then("I should see {int} offers is displaying")
    public void iShouldSeeTwoOfferIsDisplaying(int offers) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i =1; i <= offers; i++){
            // Wait for the element to be visible
            WebElement offer = wait.until(ExpectedConditions.visibilityOf(homePage.getOffersAtBottom(i)));
            // Assert that the element is displayed
            assert offer.isDisplayed() : i + " offer is not visible on the page";
        }
    }

    @When("I click on the {int} offer")
    public void iClickOnTheOffer(int offer) {
        Helper.scrollToViewAndClickElement(driver, homePage.getOfferDetailsLink(offer), Duration.ofSeconds(15));
        System.out.println("Clicked on the offer: " +  offer + " details link");
    }

    @When("I click on Book Now button in offer detail CTA")
    public void iClickOnBookNowButtonInOfferDetailCTA() throws InterruptedException {
        Thread.sleep(1500);
        Helper.clickElement(driver, homePage.getActiveBookNowButton(), Duration.ofSeconds(15));
    }

    @Then("I can verify the Offer Detail CTA alignment at bottom of the Page")
    public void iCanVerifyTheOfferDetailCTAAlignmentAtBottomOfThePage() {
        WebElement ctaElement = homePage.getOfferDetailCtaElement();
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

    @And("I verify {int} Offer expiry date in offer detail CTA")
    public void iVerifyOfferExpiryDateInOfferDetailCTA(int offerNo) {
        WebElement actualDateElement = homePage.getOfferDetailExpiryDate();
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        String formattedDate = lastDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        String expectedFormattedDate = "Expires " + formattedDate + ".";
        String actualDate = actualDateElement.getAttribute("textContent");

        String keyword = "Expires";
        String result = null;
        int index = actualDate.indexOf(keyword);
        if (index != -1) {
            result = actualDate.substring(index); // includes "Expires"
            System.out.println("Extracted: " + result);
        } else {
            System.out.println("'Expires' not found in the text.");
        }

        Assert.assertEquals(expectedFormattedDate, result.trim());
    }

    @When("I click on phone number button in {int} offer Details CTA")
    public void iClickOnPhoneNumberButtonInOfferDetailsCTA(int offerNo) {
        Helper.clickElement(driver, homePage.getFirstOfferDetailsCTAPhoneNumber(offerNo), Duration.ofSeconds(30));
    }

    @Then("I close bottom offer CTA")
    public void iCloseBottomOfferCTA() {
        Helper.clickElement(driver, homePage.getCloseOfferCTAButton(), Duration.ofSeconds(30));
    }

    @Then("I should see Google review in the home page")
    public void iShouldSeeGoogleReviewInTheHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePage.getGoogleReview()));
        Assert.assertTrue(element.isDisplayed());
        System.out.println("Google Review is available on home page");
        WebElement ratingElement = homePage.getGoogleRating();
        String ratingText = ratingElement.getText();

        if (!ratingText.isEmpty()) {
            System.out.println("Rating is available: " + ratingText);
        } else {
            System.out.println("Rating is not available.");
        }

    }

    @And("I click on View All Offers & Rebates button")
    public void iClickOnViewAllOffersRebatesButton() {
        Helper.scrollToElement(driver, homePage.getOffersRebatesButton());
        Helper.clickElement(driver, homePage.getOffersRebatesButton(), Duration.ofSeconds(30));
    }

    @Then("NC region customer care contact CTA is visible")
    public void ncRegionCustomerCareContactCTAIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePage.getNcRegionCustomerCareCta()));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("I click on first call button in customer care contact CTA")
    public void iClickOnFirstCallButtonInCustomerCareContactCTA() {
        Helper.clickElement(driver, homePage.getNcRegionCustomerCareCtaCallButton1(), Duration.ofSeconds(20));
    }

    @When("I click on second call button in customer care contact CTA")
    public void iClickOnSecondCallButtonInCustomerCareContactCTA() {
        Helper.clickElement(driver, homePage.getNcRegionCustomerCareCtaCallButton2(), Duration.ofSeconds(20));
    }

    @When("I open zip code CTA and click on Use My Current Location button")
    public void iOpenZipCodeCTAAndClickOnUseMyCurrentLocationButton() throws InterruptedException {
        Helper.clickElement(driver, homePage.getEyebrowZipCode(), Duration.ofSeconds(20));
        Thread.sleep(5000);
        Helper.clickElement(driver, homePage.getUseCurrentLocButton(), Duration.ofSeconds(20));
    }

    @Then("Current zipcode should be updated in the input box")
    public void currentZipcodeShouldBeUpdatedInTheInputBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            String value = wait.until(driver -> {
                Helper.scrollToElement(driver, homePage.getEyebrowZipCodeInputField());
                String val = homePage.getEyebrowZipCodeInputField().getAttribute("value");
                return (val != null && !val.trim().isEmpty()) ? val : null;
            });

            System.out.println("Input was populated: " + value);

        } catch (TimeoutException e) {
            Assert.fail("Zipcode input was not populated within timeout.");
        }
    }

    @Then("Customer care dialog opens up")
    public void customerCareDialogOpensUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePage.getCustomerCareModal()));
        Assert.assertTrue(element.isDisplayed());
    }

    @When("I click on first call button in customer care dialog")
    public void iClickOnFirstCallButtonInCustomerCareDialog() {
        Helper.clickElement(driver, homePage.getCustomerCareModalCallButton1(), Duration.ofSeconds(20));
    }

    @When("I click on second call button in customer care dialog")
    public void iClickOnSecondCallButtonInCustomerCareDialog() {
        Helper.clickElement(driver, homePage.getCustomerCareModalCallButton2(), Duration.ofSeconds(20));
    }

    @Then("I can close customer care modal")
    public void iCanCloseCustomerCareModal() {
        Helper.clickElement(driver, homePage.getCloseCustomerCareModalButton(), Duration.ofSeconds(20));
    }

    @Then("I can verify Phone call popup")
    public void iCanVerifyPhoneCallPopup() throws AWTException, InterruptedException {
        Thread.sleep(1000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
    }
}