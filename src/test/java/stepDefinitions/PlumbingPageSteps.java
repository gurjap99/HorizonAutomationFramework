package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PlumbingPage;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class PlumbingPageSteps {
    private final PlumbingPage plumbingPage;
    private final WebDriver driver;

    public PlumbingPageSteps(){
        this.driver = DriverFactory.getDriver();
        plumbingPage = new PlumbingPage(driver);
    }

    @When("I click on Book Now button in Image on {string} Page")
    public void iClickOnBookNowButtonInImageOnPage(String page) {
        Helper.alternateClick(driver, plumbingPage.getOverviewImgBookNowButton(page), Duration.ofSeconds(100));

    }

    @When("I click on Phone Number in Image on {string} Page")
    public void iClickOnPhoneNumberInImageOnPage(String page) {
        Helper.alternateClick(driver, plumbingPage.getOverviewImgPhoneNumber(page), Duration.ofSeconds(20));
    }
}
