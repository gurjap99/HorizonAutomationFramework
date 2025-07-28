package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LearnPage;
import utils.DriverFactory;
import org.assertj.core.api.SoftAssertions;


import java.time.Duration;
import java.util.List;

public class LearnPageSteps {
    private final LearnPage learnPage;
    private final WebDriver driver;

    public LearnPageSteps() {
        this.driver = DriverFactory.getDriver();
        learnPage = new LearnPage(driver);
    }

    @Then("I Validate that each article link works and all option opening correct page url and navigate to all article pages")
    public void validateEachPageUrl() {
        SoftAssertions softly = new SoftAssertions();
        boolean hasNextPage = true;

        while (hasNextPage) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(learnPage.getLearningHubLinks()));

            List<WebElement> links = learnPage.getLearningHubLinks();
            for (int i = 0; i < links.size(); i++) {
                links = learnPage.getLearningHubLinks(); // Re-locate to avoid stale element
                WebElement link = links.get(i);
                String expectedUrl = link.getAttribute("href");
                String linkText = link.getText();
                System.out.println("Clicking on: " + linkText);

                try {
                    link.click();
                    wait.until(ExpectedConditions.urlToBe(expectedUrl));
                    String currentUrl = driver.getCurrentUrl();

                    softly.assertThat(currentUrl)
                            .as("Link text: " + linkText)
                            .isEqualTo(expectedUrl);
                } catch (Exception e) {
                    softly.fail("Exception while clicking link '" + linkText + "': " + e.getMessage());
                }

                driver.navigate().back();
            }

            try {
                WebElement nextButton = learnPage.getLearnNextButton();
                String styleAttr = nextButton.getAttribute("style");
                if (styleAttr != null && !styleAttr.contains("pointer-events: none")) {
                    nextButton.click();
                } else {
                    hasNextPage = false;
                }
            } catch (NoSuchElementException e) {
                hasNextPage = false;
            }
        }

        softly.assertAll(); // Report all failures at the end
    }

}