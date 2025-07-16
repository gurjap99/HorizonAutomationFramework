package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    WebDriver driver;

    @FindBy(name = "first_name")
    private WebElement fNameInput;
    @FindBy(name = "last_name")
    private WebElement lNameInput;
    @FindBy(name = "phone_number")
    private WebElement phoneNumberInput;
    @FindBy(name = "zip_code")
    private WebElement zipCodeInput;
    @FindBy(xpath = "//a[.//span[text() = 'Sign Up']]")
    private WebElement signUpButton;
    @FindBy(id = "checkbox-sign_up_sms_text_alerts")
    private WebElement smsAlertCheckBox;
    @FindBy(id = "checkbox-sign_up_promotional_alerts")
    private WebElement promoAlertCheckBox;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFNameInput(String fName) {
        this.fNameInput.sendKeys(Keys.CONTROL + "a");
        this.fNameInput.sendKeys(Keys.DELETE);
        this.fNameInput.sendKeys(fName);
        System.out.println("Entered First name: " + fName);
    }

    public void setLNameInput(String lName) {
        this.lNameInput.sendKeys(Keys.CONTROL + "a");
        this.lNameInput.sendKeys(Keys.DELETE);
        this.lNameInput.sendKeys(lName);
        System.out.println("Entered Last name: " + lName);
    }

    public void setPhoneNumberInput(String phoneNumber) {
        // Clear the field first
        this.phoneNumberInput.sendKeys(Keys.CONTROL + "a");
        this.phoneNumberInput.sendKeys(Keys.DELETE);

        // Enter each digit one by one
        for (char digit : phoneNumber.toCharArray()) {
            this.phoneNumberInput.sendKeys(Character.toString(digit));
            try {
                Thread.sleep(100); // slight delay to mimic human typing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Entered Phone Number: " + phoneNumber);
    }

    public void setZipCodeInput(String zipCode) {
        this.zipCodeInput.sendKeys(Keys.CONTROL + "a");
        this.zipCodeInput.sendKeys(Keys.DELETE);

        // Enter each digit one by one
        for (char digit : zipCode.toCharArray()) {
            this.zipCodeInput.sendKeys(Character.toString(digit));
            try {
                Thread.sleep(100); // slight delay to mimic human typing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Entered Zip Code: " + zipCode);
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getSmsAlertCheckBox() {
        return smsAlertCheckBox;
    }

    public WebElement getPromoAlertCheckBox() {
        return promoAlertCheckBox;
    }
}
