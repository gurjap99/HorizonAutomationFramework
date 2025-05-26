package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LearnPage;
import utils.Data;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public class LearnPageSteps {
    private final LearnPage learnPage;
    private final WebDriver driver;

    public LearnPageSteps() {
        this.driver = DriverFactory.getDriver();
        learnPage = new LearnPage(driver);
    }

    @Then("I Validate each option opening correct page url")
    public void validateEachPageUrl() {
        boolean hasNextPage = true;

        while (hasNextPage) {
            // Wait for links to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid gap-y-[2.56rem]']//a")));
            // Collect all links
            List<WebElement> links = driver.findElements(By.xpath("//div[@class='grid gap-y-[2.56rem]']//a"));
            for (int i = 0; i < links.size(); i++) {
                links = driver.findElements(By.xpath("//div[@class='grid gap-y-[2.56rem]']//a")); // Re-locate to avoid stale element
                WebElement link = links.get(i);
                String expectedUrl = link.getAttribute("href");
                String linkText = link.getText();
                System.out.println("Clicking on: " + linkText);
                link.click();
                wait.until(ExpectedConditions.urlToBe(expectedUrl));
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.equals(expectedUrl)) {
                    System.out.println("PASS: Navigated to " + currentUrl);
                } else {
                    System.out.println("FAIL: Expected " + expectedUrl + " but got " + currentUrl);
                }
                driver.navigate().back();
            }
            // Try to click the "Next" button if pagination exists
            try {
                WebElement nextButton = driver.findElement(By.xpath(" //a[.//span[text()='Next']]"));
                //WebElement nextButton = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
                String styleAttr = nextButton.getAttribute("style");

                if (styleAttr != null && !styleAttr.contains("pointer-events: none")) {
                    nextButton.click();
                } else {
                    System.out.println("Next button is visually disabled. Skipping click.");
                    hasNextPage = false;
                }
            } catch (NoSuchElementException e) {
                hasNextPage = false;
            }
        }

    }



}