package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.WaysToSavePage;
import utils.ApiUtil;
import utils.DriverFactory;
import utils.Helper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;


public class WaysToSaveSteps {
    private final WaysToSavePage waysToSavePage;
    private final HomePage homePage;
    private final WebDriver driver;

    public WaysToSaveSteps() {
        this.driver = DriverFactory.getDriver();
        waysToSavePage = new WaysToSavePage(driver);
        homePage = new HomePage(driver);
    }

    @When("I click on call us today phone number button")
    public void iClickOnCallUsTodayPhoneNumberButton() {
        Helper.clickElementUsingActions(driver, waysToSavePage.getFinanceCallButton(), Duration.ofSeconds(15));
    }

    private void bookOnlineWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(homePage.getBookOnlineNowFrame()));
        WebElement close = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(homePage.getBookNowWindowCloseButton()));
        close.click();
        driver.switchTo().defaultContent();
    }

    @And("I should be able to click on each offer details link and validate CTA")
    public void iShouldBeAbleToClickOnEachOfferDetailsLinkAndValidateCTA() throws InterruptedException,
            AWTException {
        Thread.sleep(1000);
        List<WebElement> offerLinks = waysToSavePage.getOfferDetailsLinks();
        for (int i = 0; i < offerLinks.size(); i++){
            Thread.sleep(500);
            Helper.clickElement(driver, offerLinks.get(i), Duration.ofSeconds(20));
            WebElement visibleCTAEl = waysToSavePage.getVisibleOfferCTA();

            // get actual expiry date
            WebElement expiryDateEl = waysToSavePage.offerCTAExpiryDate(visibleCTAEl);
            String wholeText = expiryDateEl.getText();
            int index = wholeText.indexOf("Expires ");
            String actualDate = wholeText.substring(index + 8);

            // get expected expiry date
            String offerTitle = waysToSavePage.getCTAOfferTitle(expiryDateEl).getAttribute("textContent");
            String expectedIsoDate = ApiUtil.getExpiryDateByTitle(offerTitle);
            String expectedFormattedDate = Helper.formatExpiryDate(expectedIsoDate);

            // verify both dates
            Assert.assertEquals("expiry dates doe snot match", expectedFormattedDate, actualDate);

            // Click Book Now button and close book now modal
            WebElement bookNow = waysToSavePage.getWaysToSaveOfferBookNowButton(visibleCTAEl);
            Helper.clickElement(driver, bookNow, Duration.ofSeconds(15));
            System.out.println("Clicked on Book Now Button");
            bookOnlineWindow();
            System.out.println("Closed book online window");
            Thread.sleep(30);

            // Click Phone Button and close alert
            WebElement callButton = waysToSavePage.getWaysToSaveOfferPhoneNumber(visibleCTAEl);
            Helper.clickElement(driver, callButton, Duration.ofSeconds(15));
            System.out.println("Clicked on call Button");
            closePhoneCallPopup();
            System.out.println("Closed call alert");
            Thread.sleep(30);

            Helper.clickElement(driver, waysToSavePage.getWaysToSaveCloseCTAButton(), Duration.ofSeconds(10));
            System.out.println("Closing CTA");
        }
    }

    private void closePhoneCallPopup() throws AWTException, InterruptedException {
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


