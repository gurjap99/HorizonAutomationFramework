package stepDefinitions;

import io.cucumber.java.en.When;
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
        Helper.clickElementUsingActions(driver, plpPages.getSameDayAppointmentScheduleTodayButton(),
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
}
