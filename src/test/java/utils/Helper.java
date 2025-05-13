package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    private static final WebDriver driver = DriverFactory.getDriver();

    private static WebElement waitForElement(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void alternateClick(WebElement element, Duration timeout) {
        waitForPageLoad(30);
        WebElement webElement = waitForElement(element, timeout);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    public static void clickElementUsingActions(WebElement element, Duration timeout) {
        waitForPageLoad(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = waitForElement(element, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void clickElement(WebElement element, Duration timeout) {
        waitForPageLoad(30);
        WebElement webElement = waitForElement(element, timeout);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        System.out.println("Element is visible and clickable");
        driver.switchTo().defaultContent();
    }

    public static void waitForPageLoad(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        try {
            // Wait for document ready state
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            System.out.println("Page load timeout: " + e.getMessage());
            throw e;
        }
    }

}
