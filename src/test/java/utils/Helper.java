package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {

    private static final Duration DEFAULT_POLLING_INTERVAL = Duration.ofMillis(500);

    public static void alternateClick(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    public static void clickElementUsingActions(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //wait.until(ExpectedConditions.elementToBeClickable(webElement));
        Helper.scrollToElement(driver, webElement);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(webElement)));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void clickElement(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        scrollToElement(driver, webElement);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(webElement)));
        webElement.click();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void clickElementUsingJs(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        scrollToElement(driver, webElement);
        wait.until(
                ExpectedConditions.elementToBeClickable(webElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", webElement);
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void scrollToViewAndClickElement(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        // Scroll into view
        scrollToElement(driver, webElement);
        // Wait until it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        System.out.println("Element is visible and clickable");
    }

    public static void scrollToElement(WebDriver driver, WebElement webElement) {
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: " +
                "'smooth', block: 'center'});", webElement);
    }

    public static void scrollToMidOfPage(WebDriver driver){
        // scroll to mid
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        // Calculate the middle point
        long midPoint = scrollHeight / 2;
        // Scroll to the calculated mid-point
        js.executeScript("window.scrollTo(0, " + midPoint + ");");
    }

    public static void scrollToTopOfPage(WebDriver driver){
        // scroll to top
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollToBottomOfPage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");
        // Scroll to the calculated mid-point
        js.executeScript("window.scrollTo(0, " + scrollHeight + ");");
    }

    // In your Helper class, add this:
    public static void retry(Runnable action, Duration timeout) {
        retry(action, timeout, DEFAULT_POLLING_INTERVAL);
    }

    public static void retry(Runnable action, Duration timeout, Duration pollingInterval) {
        Instant endTime = Instant.now().plus(timeout);
        Throwable lastException = null;

        while (Instant.now().isBefore(endTime)) {
            try {
                action.run();
                return;
            } catch (Exception | Error e) {
                lastException = e;
                try {
                    Thread.sleep(pollingInterval.toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry interrupted", ie);
                }
            }
        }
        throw new RuntimeException("Retry failed after timeout", lastException);
    }

    public static String formatExpiryDate(String isoDate) {
        ZonedDateTime dateTime = ZonedDateTime.parse(isoDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        return dateTime.format(formatter) + ".";
    }

}
