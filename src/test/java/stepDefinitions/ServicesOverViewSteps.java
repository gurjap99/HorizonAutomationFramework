package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ServicesOverView;
import utils.Data;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;

public class ServicesOverViewSteps {
    private final ServicesOverView servicesOverView;
    private final WebDriver driver;

    public ServicesOverViewSteps() {
        this.driver = DriverFactory.getDriver();
        servicesOverView = new ServicesOverView(driver);
    }

    @When("I can validate the list of all {string} services and their order")
    public void validateListOfCategoryServicesAndTheirOrder(String category) {
        for (int i = 0; i < servicesOverView.getServicesListButtons().size(); i++) {
            Assert.assertEquals(category + " service doesn't match",
                    Data.categoryServiceMap.get(category).get(i),
                    servicesOverView.getServicesListButtons().get(i).getText().trim());
            System.out.println("Heating & Cooling services are " +
                    servicesOverView.getServicesListButtons().get(i).getText());
        }
    }

    @When("I click on {string} {string}")
    public void iClickOn(String category, String service) {
        int index = Data.categoryServiceMap.get(category).indexOf(service);
        servicesOverView.getServicesListButtons().get(index).click();
    }

    @Then("{string} CTA opens and Book now button can be clicked")
    public void itsCTAOpensAndBookNowButtonCanBeClicked(String service) {
        String[] servicesSplit = service.split(" ");
        Helper.clickElementUsingActions(driver, servicesOverView.getCtaBookNowButton(servicesSplit),
                Duration.ofSeconds(15));
    }

    @When("{string} Phone number button in CTA is clicked")
    public void phoneNumberButtonInCTAIsClicked(String service) {
        String[] servicesSplit = service.split(" ");
        servicesOverView.getCtaPhoneButton(servicesSplit).click();
    }

    @When("I click on {string} Learn More button")
    public void iClickLearMoreButton(String service) {
        String[] servicesSplit = service.split(" ");
        servicesOverView.getCtaLearnMoreButton(servicesSplit).click();
    }

    @Then("it navigates to {string}")
    public void itNavigatesTo(String url) {
        Helper.retry(()->
        {
            Assert.assertEquals("URL does not match ", url, driver.getCurrentUrl());
            return null;
        }, Duration.ofSeconds(15));
    }

    @When("I click on Book Now button in Image on {string} Page")
    public void iClickOnBookNowButtonInImageOnPage(String page) {
        Helper.alternateClick(driver, servicesOverView.getOverviewImgBookNowButton(page), Duration.ofSeconds(15));
    }

    @When("I click on Phone Number in Image on {string} Page")
    public void iClickOnPhoneNumberInImageOnPage(String page) {
        Helper.alternateClick(driver, servicesOverView.getOverviewImgPhoneNumber(page), Duration.ofSeconds(20));
    }

    @When("I click on {string} in {string}")
    public void iClickOnIn(String type, String category) {
        Helper.alternateClick(driver, servicesOverView.getBottomServices(category,type), Duration.ofSeconds(20));
    }

    @When("I click on Exclusive offers and Rebates")
    public void iClickOnExclusiveOffersAndRebates() {
        Helper.clickElementUsingActions(driver, servicesOverView.getExclusiveOffersAndRebates(), Duration.ofSeconds(20));
    }

    @When("I click on Flexible Financing")
    public void iClickOnFlexibleFinancing() {
        Helper.clickElementUsingActions(driver, servicesOverView.getFlexibleFinancing(), Duration.ofSeconds(20));
    }

    @When("I click on Comfort Membership")
    public void iClickOnComfortMembership() {
        Helper.clickElementUsingActions(driver, servicesOverView.getComfortMembership(), Duration.ofSeconds(20));
    }
}
