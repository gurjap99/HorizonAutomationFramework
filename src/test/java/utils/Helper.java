package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    private static WebDriver driver = DriverFactory.getDriver();

    private static WebElement waitForElement(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void alternateClick(WebElement element, Duration timeout) {
        try {
            WebElement webElement = waitForElement(element, timeout);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).click().perform();
        } catch (Exception e) {
            System.err.println("Error during alternateClick: " + e.getMessage());
        }
    }

    public static WebElement explicitWait(WebElement element, Duration timeout) {
        try {
            return waitForElement(element, timeout);
        } catch (Exception e) {
            System.err.println("Error during explicitWait: " + e.getMessage());
            return null;
        }
    }

    public static void clickElementUsingActions(WebElement element, Duration timeout) {
        try {
            WebElement webElement = waitForElement(element, timeout);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).click().perform();
            System.out.println("Element is visible and clickable");
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            throw new AssertionError("Failed to click element: " + e.getMessage());
        }
    }

    public static void clickElement(WebElement element, Duration timeout) {
        try {
            WebElement webElement = waitForElement(element, timeout);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            System.out.println("Element is visible and clickable");
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            throw new AssertionError("Failed to click element: " + e.getMessage());
        }
    }
}
