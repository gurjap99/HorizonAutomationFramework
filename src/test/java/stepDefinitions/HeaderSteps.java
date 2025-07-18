package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Header;
import utils.Data;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;


public class HeaderSteps {
    private final Header header;
    private final WebDriver driver;

    public HeaderSteps() {
        this.driver = DriverFactory.getDriver();
        header = new Header(driver);
    }

    @When("I get the Menu list")
    public void iGetTheMenuList() {
        WebElement menu = header.getMenu();
        String menuText = menu.getText();
        String[] actualOrder = menuText.split("\n");
        for (String item : actualOrder) {
            System.out.println("Menu items are " + item);
        }
    }

    @Then("I Should see the Menu order is displayed in correct order")
    public void validateMenuOrder() {
        String[] expectedOrder = {"Heating & Cooling", "Plumbing", "Electrical", "Ways to Save", "Learn", "About Us"};
        WebElement menu = header.getMenu();
        String menuText = menu.getText();
        String[] actualOrder = menuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("Menu Order does not match", expectedOrder, actualOrder);
    }

    @When("I Click on Heating & Cooling")
    public void iClickOnHeatingAndCooling() {
        Helper.clickElementUsingActions(driver, header.getHeatingAndCooling(), Duration.ofSeconds(15));
        System.out.println("Clicked on Heating and Cooling option menu");
    }

    @Then("I should see the Heating & Cooling Sub Menu order is displayed in correct order")
    public void iShouldSeeTheSubMenuOrderIsDisplayedInCorrectOrder() {
        String[] expectedSubMenu = {"Overview", "Heating Maintenance", "Heating Repair", "Heating Installation",
                "AC Maintenance", "AC Repair", "AC Installation", "Ductless Mini-Splits", "HVAC Accessories",
                "Indoor Air Quality"};
        WebElement subMenu = header.getHeatingAndCoolingSubMenu();
        String subMenuText = subMenu.getText();
        String[] actualSubMenu = subMenuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("The Heating & Cooling subMenu Order does not match", expectedSubMenu, actualSubMenu);
    }

    @When("I Click on Plumbing")
    public void iClickOnPlumbing() {
        Helper.clickElementUsingActions(driver, header.getPlumbing(), Duration.ofSeconds(15));
        System.out.println("Clicked on Plumbing option menu");
    }

    @When("I Click on Electrical")
    public void iClickOnElectrical() {
        Helper.clickElementUsingActions(driver, header.getElectrical(), Duration.ofSeconds(15));
        System.out.println("Clicked on Electrical option menu");
    }

    @When("I Click on Ways to Save")
    public void iClickOnWaysToSave() {
        Helper.clickElementUsingActions(driver, header.getWaysToSave(), Duration.ofSeconds(15));
        System.out.println("Clicked on Ways to Save option menu");
    }

    @When("I Click on Learn")
    public void iClickOnLearn() {
        Helper.clickElementUsingActions(driver, header.getLearn(), Duration.ofSeconds(15));
        System.out.println("Clicked on Learn option menu");
    }

    @When("I Click on About Us")
    public void iClickOnAboutUs() {
        Helper.clickElementUsingActions(driver, header.getAboutUs(), Duration.ofSeconds(15));
        System.out.println("Clicked on About Us option menu");
    }

    @Then("I should see the Plumbing Sub Menu order is displayed in correct order")
    public void iShouldSeeThePlumbingSubMenuOrderIsDisplayedInCorrectOrder() {
        String[] expectedSubMenu = {"Overview", "Water Heaters", "Water Treatment", "Water Lines", "Gas Lines", "Drains & Sewer Lines", "Sump Pumps", "Well Pumps", "Kitchen & Bathroom"};
        WebElement subMenu = header.getPlumbingSubMenu();
        String subMenuText = subMenu.getText();
        String[] actualSubMenu = subMenuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("The Plumbing subMenu Order does not match", expectedSubMenu, actualSubMenu);
    }

    @Then("I should see the Electrical Sub Menu order is displayed in correct order")
    public void iShouldSeeTheElectricalSubMenuOrderIsDisplayedInCorrectOrder() {
        String[] expectedSubMenu = {"Overview", "Electrical Wiring", "Electrical Remodeling", "Electric Vehicle Chargers", "Electrical Panels & Circuit Breakers", "Whole-House Generators", "Whole-House Surge Protectors", "Lighting & Ceiling Fans"};
        WebElement subMenu = header.getElectricalSubMenu();
        String subMenuText = subMenu.getText();
        String[] actualSubMenu = subMenuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("The Electrical subMenu Order does not match", expectedSubMenu, actualSubMenu);
    }

    @Then("I should see the Ways to Save Sub Menu order is displayed in correct order")
    public void iShouldSeeTheWaysToSaveSubMenuOrderIsDisplayedInCorrectOrder() {
        String[] expectedSubMenu = {"Overview", "Offers & Rebates", "Financing", "Membership Program"};
        WebElement subMenu = header.getWaysToSaveSubMenu();
        String subMenuText = subMenu.getText();
        String[] actualSubMenu = subMenuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("The Ways to Save subMenu Order does not match", expectedSubMenu, actualSubMenu);
    }

    @Then("I should see new page with URL {string}")
    public void iShouldSeeNewPageWithURL(String url) {
        Assert.assertEquals("Explore Electrical URL does not match ", url, driver.getCurrentUrl());
    }

    @Then("I should see the About Us Sub Menu order is displayed in correct order")
    public void iShouldSeeTheAboutUsSubMenuOrderIsDisplayedInCorrectOrder() {
        String[] expectedSubMenu = {"Overview", "Why Horizon", "Reviews", "Work With Us", "Contact Us", "In the Community", "Preferred Brands"};
        WebElement subMenu = header.getAboutUsSubMenu();
        String subMenuText = subMenu.getText();
        String[] actualSubMenu = subMenuText.split("\n");
        // Validate the order
        Assert.assertArrayEquals("The About Us subMenu Order does not match", expectedSubMenu, actualSubMenu);
    }

    @When("I click on Book Now button on header part")
    public void iClickOnBookNowButtonOnHeaderPart() {
        Helper.clickElement(driver, header.getHeaderBookNowBtn(), Duration.ofSeconds(30));
    }

    @When("I click on phone number from header part")
    public void iClickOnPhoneNumberFromHeaderPart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOf(header.getHeaderPhoneNumberButton()));
            if (phoneNumber.isDisplayed()) {
                System.out.println("Phone number is visible");
            } else {
                throw new AssertionError("Phone number is not visible.");
            }
            Actions actions = new Actions(driver);
            actions.moveToElement(phoneNumber).click().perform();
        } catch (Exception e) {
            throw new AssertionError("Failed to click Phone number: " + e.getMessage());
        }
    }

    @When("I click on Overview button in {string} header submenu")
    public void iClickOnOverviewButtonInCategorySubmenu(String category) {
        int index = Data.CATEGORY_LIST.indexOf(category);
        header.getCategoryOverviewButton(index).click();
        System.out.println("Clicked on " + category + " Overview button");
    }

    @When("I click on {string} button in category header submenu")
    public void iClickOnButtonInCategoryHeaderSubmenu(String service) {
        header.getCategoryServiceButton(service).click();
        System.out.println("Clicked on " + service + " button");
    }
}
