package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Footer {
    private final WebDriver driver;
    @FindBy(xpath = "(//div[contains(@class, 'sm:gap-8')]//span[contains(text(),'Book Now')])[1]")
    private WebElement peaceOfMindBookNowButton;
    @FindBy(xpath = "(//div[ contains(@class, 'sm:gap-8')]//span[contains(@id,'phoneNumber')])")
    private WebElement peaceOfMindCallButton;
    @FindBy(xpath = "(//div[contains(@class, 'sm:gap-8')]//div[contains(@class, 'flex-1')])[1]//a")
    private List<WebElement> servicesDivLinkElements;
    @FindBy(xpath = "(//div[contains(@class, 'sm:gap-8')]//div[contains(@class, 'flex-1')])[2]//a")
    private List<WebElement> quickLinksDivLinkElements;
    @FindBy(xpath = "(//div[contains(@class, 'sm:gap-8')]//div[contains(@class, 'flex-1')])[3]//a")
    private List<WebElement> aboutUsDivLinkElements;
    @FindBy(xpath = "(//div[contains(@class, 'sm:gap-8')]//div[contains(@class, 'flex-col')])[3]")
    private WebElement footerListDiv;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getPeaceOfMindBookNowButton() {
        return peaceOfMindBookNowButton;
    }

    public WebElement getPeaceOfMindCallButton() {
        return peaceOfMindCallButton;
    }

    public List<WebElement> getServicesDivLinkElements() {
        return servicesDivLinkElements;
    }

    public WebElement getFooterListDiv() {
        return footerListDiv;
    }

    public List<WebElement> getQuickLinksDivLinkElements() {
        return quickLinksDivLinkElements;
    }

    public List<WebElement> getAboutUsDivLinkElements() {
        return aboutUsDivLinkElements;
    }

    public WebElement getSocialMediaImage(String altText) {
        return driver.findElement(By.cssSelector(String.format("img[alt='%s']", altText)));
    }
}
