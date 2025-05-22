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
        Assert.assertEquals("URL does not match ", url, driver.getCurrentUrl());
    }


}
