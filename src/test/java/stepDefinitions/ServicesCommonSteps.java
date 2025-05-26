package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ServicesCommon;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class ServicesCommonSteps {
    private final ServicesCommon servicesCommon;
    private final WebDriver driver;

    public ServicesCommonSteps() {
        this.driver = DriverFactory.getDriver();
        servicesCommon = new ServicesCommon(driver);
    }

    @When ("I click on service page Book Now Button")
    public void clickOnServicePageBookNowButton() {
        Helper.clickElementUsingActions(driver, servicesCommon.getServiceBookNowButton(), Duration.ofSeconds(20));
    }

    @When("I click on service page Phone number button")
    public void iClickOnServicePagePhoneNumberButton() {
        servicesCommon.getServicePhoneButton().click();
    }

    @When("I click on Explore Membership button")
    public void iClickOnExploreMembershipButton() {
        Helper.clickElementUsingActions(driver, servicesCommon.getExploreMembershipButton(), Duration.ofSeconds(20));
    }

    @When("I click on Explore Financing button")
    public void iClickOnExploreFinancingButton() {
        Helper.clickElementUsingActions(driver, servicesCommon.getExploreFinancingButton(), Duration.ofSeconds(20));
    }

    @When("I navigate back")
    public void iNavigateBack() {
        driver.navigate().back();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String service) {
        String[] servicesSplit = service.split(" ");
        servicesCommon.getOtherServiceButton(servicesSplit).click();
    }

    @When("I click on Answers to common questions Phone number button")
    public void iClickOnAnswersToCommonQuestionsPhoneNumberButton() {
        servicesCommon.getAnswersDivPhoneNumber().click();
    }
}
