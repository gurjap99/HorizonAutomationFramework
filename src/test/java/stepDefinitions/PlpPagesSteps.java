package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PlpPages;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class PlpPagesSteps {
    private final PlpPages plpPages;
    private final WebDriver driver;

    public PlpPagesSteps() {
        this.driver = DriverFactory.getDriver();
        plpPages = new PlpPages(driver);
    }
    @When("I click on Schedule Today button under same-day appointment now")
    public void iClickOnScheduleTodayButtonUnderSameDayAppointment() {
        Helper.clickElement(driver, plpPages.getSameDayAppointmentScheduleTodayButton(),
                Duration.ofSeconds(20));
    }

    @When("I click on Book Now button by the images")
    public void iClickOnBookNowByButtonImages() {
        Helper.clickElementUsingActions(driver, plpPages.getBookNowButtonByImages(), Duration.ofSeconds(20));
    }

    @When("I click on Phone Number button by the images")
    public void iClickOnPhoneButtonByImages() {
        Helper.clickElementUsingActions(driver, plpPages.getPhoneButtonByImages(), Duration.ofSeconds(20));
    }

    @When("I click on Schedule Today button in offer detail CTA")
    public void iClickOnScheduleTodayButtonInOfferDetailCTA() {
        Helper.clickElement(driver, plpPages.getActiveScheduleTodayButton(), Duration.ofSeconds(15));
    }

    @When("I click on 3rd Schedule Today button")
    public void iClickOnRdScheduleTodayButton() {
        Helper.clickElement(driver, plpPages.getSameDayAppointmentScheduleTodayButton2(), Duration.ofSeconds(15));
    }

    @When("I click on 4th Schedule Today button")
    public void iClickOnRthScheduleTodayButton() {
        Helper.clickElement(driver, plpPages.getSameDayAppointmentScheduleTodayButton3(), Duration.ofSeconds(15));
    }

    @Then("PLP google reviews are visible")
    public void plpGoogleReviewIsVisible() {
        Helper.scrollToBottomOfPage(driver);
        Helper.retry(()-> Assert.assertEquals("Google reviews are not visible in PLP page",
                2, plpPages.getGoogleRatingDivs().size()), Duration.ofSeconds(20));
    }
}
