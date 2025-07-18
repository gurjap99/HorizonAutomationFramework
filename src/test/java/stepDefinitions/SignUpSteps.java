package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SignUp;
import utils.DriverFactory;
import utils.Helper;
import utils.RandomUtil;

import java.time.Duration;
import java.util.Random;

public class SignUpSteps {
    private final SignUp signUp;
    private final WebDriver driver;

    public SignUpSteps() {
        this.driver = DriverFactory.getDriver();
        signUp = new SignUp(driver);
    }

    @When("I populate all the fields of sign up page and check checkboxes")
    public void iPopulateAllTheFieldsOfSignUpPage() {
        String fName = RandomUtil.generateRandomAlphabetic(8);
        String lName = RandomUtil.generateRandomAlphabetic(8);
        String phoneNumber = RandomUtil.generateRandomNumeric(10);
        String zipCode = "21244";

        signUp.setFNameInput(fName);
        signUp.setLNameInput(lName);
        signUp.setPhoneNumberInput(phoneNumber);
        signUp.setZipCodeInput(zipCode);
        signUp.getSmsAlertCheckBox().click();
        signUp.getPromoAlertCheckBox().click();
    }

    @Then("Sign up button should be disabled")
    public void signUpButtonShouldBeDisabled() {
        Assert.assertTrue(Boolean.parseBoolean(signUp.getSignUpButton().getAttribute("data-disabled")));
    }
}
