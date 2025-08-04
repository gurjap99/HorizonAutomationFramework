package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void clickOnServicePageBookNowButton() throws InterruptedException {
        Thread.sleep(2000);
        Helper.scrollToElement(driver, servicesCommon.getServiceBookNowButton());
        Helper.clickElement(driver, servicesCommon.getServiceBookNowButton(), Duration.ofSeconds(30));
    }

    @When("I click on service page Phone number button")
    public void iClickOnServicePagePhoneNumberButton() {
        Helper.clickElement(driver, servicesCommon.getServicePhoneButton(), Duration.ofSeconds(20));
    }

    @When("I click on Explore Membership button")
    public void iClickOnExploreMembershipButton() {
        Helper.clickElement(driver, servicesCommon.getExploreMembershipButton(), Duration.ofSeconds(20));
    }

    @When("I click on Explore Financing button")
    public void iClickOnExploreFinancingButton() {
        Helper.scrollToElement(driver, servicesCommon.getExploreFinancingButton());
        Helper.clickElement(driver, servicesCommon.getExploreFinancingButton(), Duration.ofSeconds(20));
    }

    @When("I click on Explore Offers and Rebates button")
    public void iClickOnExploreOffersAndRebatesButton() {
        Helper.clickElement(driver, servicesCommon.getExploreOffersRebatesButton(), Duration.ofSeconds(20));
    }

    @When("I navigate back")
    public void iNavigateBack() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String service) throws InterruptedException {
        String[] servicesSplit = service.split(" ");
        WebElement element = servicesCommon.getOtherServiceButton(servicesSplit);
        Helper.scrollToElement(driver, element);
        Thread.sleep(700);
        Helper.clickElementUsingActions(driver, element, Duration.ofSeconds(20));
    }

    @When("I click on Answers to common questions Phone number button")
    public void iClickOnAnswersToCommonQuestionsPhoneNumberButton() {
        Helper.clickElement(driver, servicesCommon.getAnswersDivPhoneNumber(), Duration.ofSeconds(20));
    }

    @When("I click on breadcrumb button")
    public void iClickOnBreadcrumbButton() throws InterruptedException {
        Thread.sleep(500);
        Helper.scrollToTopOfPage(driver);
        Helper.clickElement(driver, servicesCommon.getBreadCrumbButton(), Duration.ofSeconds(20));

    }
}
