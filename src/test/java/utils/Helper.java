package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

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
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(webElement)));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void clickElement(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(
                ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void scrollToViewAndClickElement(WebDriver driver, WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webElement);
        // Wait until it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        System.out.println("Element is visible and clickable");
    }

    // Retry methods
    // Retry method with optional polling interval (default 500ms)
    public static <T> T retry(Supplier<T> action, Duration timeout) {
        return retry(action, timeout, DEFAULT_POLLING_INTERVAL);
    }

    public static <T> T retry(Supplier<T> action, Duration timeout, Duration pollingInterval) {
        Instant endTime = Instant.now().plus(timeout);
        Throwable lastException = null;

        while (Instant.now().isBefore(endTime)) {
            try {
                return action.get();
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
}
