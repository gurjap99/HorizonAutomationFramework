package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WaysToSavePage {
    WebDriver driver;

    public WaysToSavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Offer Details")
    private List<WebElement> offerDetailsLinks;
    @FindBy(id = "se-widget-iframe")
    private WebElement waysToSaveBookOnlineNowFrame;
    @FindBy(xpath = "(//button[@data-testid= 'close-button'])[2]")
    private WebElement waysToSaveBookNowWindowCloseButton;
    @FindBy(css = "div[class='visible opacity-100'] div[role='Close'] svg")
    private WebElement waysToSaveCloseCTAButton;
    @FindBy(xpath = "//span[text()='Book Now']/ancestor::a")
    private WebElement waysToSaveOfferBookNowButton;
    @FindBy(xpath = "//span[contains(@id,'phoneNumber')]/ancestor::a")
    private WebElement waysToSaveOfferPhoneNumber;
    @FindBy(xpath = "//article[contains(@class, 'mt-5')]")
    private List<WebElement> waysToSaveOfferExpiryDate;

    public List<WebElement> getOfferDetailsLinks() {
        return offerDetailsLinks;
    }

    public WebElement getWaysToSaveBookOnlineNowFrame() {
        return waysToSaveBookOnlineNowFrame;
    }

    public WebElement getWaysToSaveBookNowWindowCloseButton() {
        return waysToSaveBookNowWindowCloseButton;
    }

    public WebElement getWaysToSaveCloseCTAButton() {
        return waysToSaveCloseCTAButton;
    }

    public WebElement getWaysToSaveOfferBookNowButton() {
        return waysToSaveOfferBookNowButton;
    }

    public WebElement getWaysToSaveOfferPhoneNumber() {
        return waysToSaveOfferPhoneNumber;
    }

    public List<WebElement> getWaysToSaveOfferExpiryDate() {
        return waysToSaveOfferExpiryDate;
    }
}
