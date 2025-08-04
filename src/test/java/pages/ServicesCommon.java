package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServicesCommon {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'sm:py-[6.25rem]') and contains(@class, 'bg-background_color_1')]" +
            "//a[.//span[contains(text(), 'Book')]]")
    private WebElement serviceBookNowButton;
    @FindBy(xpath = "//div[contains(@class, 'sm:py-[6.25rem]') and contains(@class, 'bg-background_color_1')]" +
            "//a[.//span[@id = 'phoneNumber']]")
    private WebElement servicePhoneButton;
    @FindBy(xpath = "//a[.//span[contains(text(), 'Explore Membership')]]")
    private WebElement exploreMembershipButton;
    @FindBy(xpath = "//a[.//span[contains(text(), 'Explore Financing')]]")
    private WebElement exploreFinancingButton;
    @FindBy(xpath = "//a[.//span[contains(text(), 'Explore Offers')]]")
    private WebElement exploreOffersRebatesButton;
    @FindBy(xpath = "//div[*[contains(text(), 'Answers')]]//span[@id='phoneNumber']")
    private WebElement answersDivPhoneNumber;
    @FindBy(xpath = "//div[contains(@class, 'sm:py-[6.25rem]') and contains(@class, 'bg-background_color_1')]//a")
    private WebElement breadCrumbButton;

    public ServicesCommon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getServiceBookNowButton() {
        return serviceBookNowButton;
    }

    public WebElement getServicePhoneButton() {
        return servicePhoneButton;
    }

    public WebElement getExploreMembershipButton() {
        return exploreMembershipButton;
    }

    public WebElement getOtherServiceButton(String[] ctaNames) {
        // Build the XPath condition for each ctaName using contains()
        StringBuilder conditions = new StringBuilder();
        for (int i = 0; i < ctaNames.length; i++) {
            conditions.append(String.format("contains(text(), '%s')", ctaNames[i]));
            if (i < ctaNames.length - 1) {
                conditions.append(" and ");
            }
        }

        // Final XPath with dynamic h2 conditions
        String xpath = String.format(
                "//a[div[contains(@class, 'sm:min-h-[7.5rem]') and ./p[%s]]]",
                conditions
        );
        return this.driver.findElement(By.xpath(xpath));
    }

    public WebElement getAnswersDivPhoneNumber() {
        return answersDivPhoneNumber;
    }

    public WebElement getExploreFinancingButton() {
        return exploreFinancingButton;
    }

    public WebElement getExploreOffersRebatesButton() {
        return exploreOffersRebatesButton;
    }

    public WebElement getBreadCrumbButton() {
        return breadCrumbButton;
    }
}
