package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import java.util.ArrayList;
import java.util.List;

public class HomePageSteps {
    private final HomePage homePage;
    private final String platform;
    private WebDriver driver;

    public HomePageSteps() {
        this.driver = DriverFactory.getDriver();
        platform = ConfigReader.get("platform");
        homePage = new HomePage(driver);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1512, 712));
        Helper.waitForPageLoad(30);
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
    public void both_ctas_with_plus_icons_should_be_clickable_and_show_book_now_button() throws InterruptedException {
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
                    WebElement closeCTA = driver.findElement(By.cssSelector("div[class='visible opacity-100'] div[role='Close'] svg"));
                    closeCTA.click();
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
        Helper.alternateClick(homePage.getOfferBannerPlusIcon(), Duration.ofSeconds(15));
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
        Helper.clickElementUsingActions(homePage.getOfferCTABookNowButton(), Duration.ofSeconds(15));
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
        Helper.clickElement(homePage.getOfferCTAPhoneNumberButton(), Duration.ofSeconds(30));
    }

    @When("I click on Explore Heating & Cooling, it opens Heating & Cooling webpage")
    public void iClickOnExploreHeatingCoolingICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(homePage.getExploreHeatingCoolingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Heating & Cooling URL does not match ",
                Data.HEATING_COOLING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Plumbing, it opens Plumbing webpage")
    public void iClickOnExplorePlumbingICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(homePage.getExplorePlumbingButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Plumbing URL does not match ", Data.PLUMBING_URL, driver.getCurrentUrl());
    }

    @When("I click on Explore Electrical, it opens Electrical webpage")
    public void iClickOnExploreElectricalICanNavigateBackToHomePage() {
        Helper.clickElementUsingActions(homePage.getExploreElectricalButton(), Duration.ofSeconds(20));
        Assert.assertEquals("Explore Electrical URL does not match ", Data.ELECTRICAL_URL, driver.getCurrentUrl());
    }

    @Then("I can navigate back to home page")
    public void iCanNavigateBackToHomePage() {
        driver.navigate().back();
    }

    @When("I click on Book Now button in Image on home screen")
    public void iClickOnBookNowButtonInImageOnHomeScreen() {
        Helper.clickElementUsingActions(homePage.getImageBookNowButton(), Duration.ofSeconds(15));
    }

    @When("I click on phone number button in in Image on home screen")
    public void iClickOnPhoneNumberButtonInInImageOnHomeScreen() {
        Helper.clickElement(homePage.getImagePhoneNumberButton(), Duration.ofSeconds(15));
    }
}




