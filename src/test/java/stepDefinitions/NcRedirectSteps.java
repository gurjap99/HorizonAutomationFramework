package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LearnPage;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class NcRedirectSteps {
    private final WebDriver driver;

    public NcRedirectSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @Then("it navigates to link starting with {string}")
    public void itNavigatesToLinkStartingWith(String url) {
        Helper.retry(()-> Assert.assertTrue("URL does not start with ",
                driver.getCurrentUrl().startsWith(url)), Duration.ofSeconds(15));
    }
}
