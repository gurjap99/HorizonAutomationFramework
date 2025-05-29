package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WaysToSavePage;
import utils.DriverFactory;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;


public class WaysToSaveSteps {
    private final WaysToSavePage waysToSavePage;
    private final WebDriver driver;

    public WaysToSaveSteps() {
        this.driver = DriverFactory.getDriver();
        waysToSavePage = new WaysToSavePage(driver);
    }

    @And("I should be able to click on each offer details link and validate CTA")
    public void iShouldBeAbleToClickOnEachOfferDetailsLinkAndValidateCTA() throws InterruptedException {
        List<WebElement> offerLinks = waysToSavePage.getOfferDetailsLinks();
        for (int i = 0; i < offerLinks.size(); i++) {
            // Re-fetch the list to avoid stale element reference
            offerLinks = waysToSavePage.getOfferDetailsLinks();
            // Click the link
            offerLinks.get(i).click();
            System.out.println("Clicking on " +i+ " link");
            List<WebElement> expiryDate = waysToSavePage.getWaysToSaveOfferExpiryDate();
            if (i < expiryDate.size()) {
                List<WebElement> actualDateElement = waysToSavePage.getWaysToSaveOfferExpiryDate();
                LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
                String formattedDate = lastDayOfMonth.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
                String expectedFormattedDate = "Expires " + formattedDate + ".";
                String actualDate = actualDateElement.get(i+2).getAttribute("textContent").replace(",", "").trim();
                String keyword = "Expires";
                String result = null;
                int index = actualDate.indexOf(keyword);
                if (index != -1) {
                    result = actualDate.substring(index); // includes "Expires"
                    System.out.println("Extracted: " + result);
                } else {
                    System.out.println("'Expires' not found in the text.");
                }

                Assert.assertEquals(expectedFormattedDate.replace(",", ""), result);
            }
                WebElement bookNow = waysToSavePage.getWaysToSaveOfferBookNowButton();
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookNow);
                System.out.println("Clicked on Book Now Button");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(waysToSavePage.getWaysToSaveBookOnlineNowFrame()));
                WebElement bookNowWindow = wait.until(ExpectedConditions.visibilityOf(waysToSavePage.getWaysToSaveBookNowWindowCloseButton()));
                bookNowWindow.click();
                System.out.println("Closing book online window");
//            driver.switchTo().defaultContent();
//            WebElement phone = waysToSavePage.getWaysToSaveOfferPhoneNumber();
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phone);
                driver.switchTo().defaultContent();
                WebElement offerCTAClose = wait.until(ExpectedConditions.visibilityOf(waysToSavePage.getWaysToSaveCloseCTAButton()));
                Thread.sleep(30);
                offerCTAClose.click();
                System.out.println("Closing CTA");
            }
        }
    }


