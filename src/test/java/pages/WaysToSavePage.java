package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//div[contains(@class,'SloganBar_sloganBar__9cxuq') and .//h1]//a[.//span[contains(@id,'phoneNumber')]]")
    private WebElement financeCallButton;

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

    public WebElement getWaysToSaveOfferBookNowButton(WebElement cta) {
        return cta.findElement(By.xpath(".//a[.//span[contains(text(),'Book') " +
                "or contains(text(),'Schedule')]]"));
    }

    public WebElement getWaysToSaveOfferPhoneNumber(WebElement cta) {
        return cta.findElement(By.xpath(".//a[.//span[@id='phoneNumber']]"));
    }

//    public List<WebElement> getWaysToSaveOfferExpiryDate() {
//        return waysToSaveOfferExpiryDate;
//    }

    public WebElement offerCTAExpiryDate(WebElement cta) {
        return cta.findElement(By.xpath(".//article[contains(@class, 'mt-5')]"));
    }

    public WebElement getFinanceCallButton() {
        return financeCallButton;
    }

    public WebElement getVisibleOfferCTA() {
        List<WebElement> els = driver.findElements(By.xpath("//div[contains(@class, " +
                "'w-[22.625rem] sm:w-[29.5rem] flex-col rounded-l-lg')]"));
        WebElement vEl = null;
        int count = 0;
        // Find the first visible element
        for (WebElement el : els) {
            if (el.isDisplayed()) {
                vEl = el;
                count++;
            }
        }
        System.out.println("Visible CTA count = " + count);
        return vEl;
    }

    public WebElement getCTAOfferTitle(WebElement expiryDateEl){
        return expiryDateEl.findElement(By.xpath(".//preceding::p[1]"));
    }
}
