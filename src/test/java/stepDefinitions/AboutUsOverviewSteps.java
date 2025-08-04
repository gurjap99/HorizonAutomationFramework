package stepDefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutUsPages;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class AboutUsOverviewSteps {
    private final AboutUsPages aboutUs;
    private final WebDriver driver;

    public AboutUsOverviewSteps() {
        this.driver = DriverFactory.getDriver();
        aboutUs = new AboutUsPages(driver);
    }
    @When("I Click on About Us Overview Image Book Now Button")
    public void iClickOnAboutUsOverviewImageBookNowButton() {
        Helper.clickElementUsingActions(driver, aboutUs.getAboutUsOverviewImageBookNow(), Duration.ofSeconds(15));
    }

    @When("I Click on About Us Overview Image Phone Button")
    public void iClickOnAboutUsOverviewImagePhoneButton() {
        Helper.clickElementUsingActions(driver, aboutUs.getAboutUsOverviewImagePhoneNow(), Duration.ofSeconds(15));
    }

    @When("I click on option {string}")
    public void iClickOnOption(String option) {
        Helper.clickElement(driver, aboutUs.getAboutUsOptionButton(option), Duration.ofSeconds(15));
    }

    @When("I click on {int} Explore Careers each takes to {string}")
    public void iClickOnExploreCareersEachTakesTo(int count, String careersUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        for(int i = 1; i <= count; i++){
            Helper.clickElement(driver, aboutUs.getExploreCareersButton(i), Duration.ofSeconds(15));
            Assert.assertTrue("URL does not match ", driver.getCurrentUrl().startsWith(careersUrl));
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(aboutUs.getExploreCareersButton(i)));
        }
    }
}
