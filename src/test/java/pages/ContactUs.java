package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
    WebDriver driver;

    @FindBy(xpath = "//div/*[contains(@data-testid, 'search-icon')]")
    private WebElement contactUsMapZipcodeInputSearchButton;
    @FindBy(id = "google-map-container")
    private WebElement map;
    @FindBy(css = "button.cursor-pointer")
    private WebElement locationButton;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getContactUsMapZipcodeInputSearchButton() {
        return contactUsMapZipcodeInputSearchButton;
    }

    public WebElement getMap() {
        return map;
    }

    public WebElement getLocationButton() {
        return locationButton;
    }
}
