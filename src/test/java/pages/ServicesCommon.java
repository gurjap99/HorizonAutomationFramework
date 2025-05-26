package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesCommon {
    WebDriver driver;

    @FindBy(xpath = "(//div[contains(@class, 'sm:py-[6.25rem]') and contains(@class, 'bg-background_color_1')]" +
            "//span[contains(text(), 'Book Now')])[1]")
    private WebElement serviceBookNowButton;
    @FindBy(xpath = "//div[contains(@class, 'sm:py-[6.25rem]') and contains(@class, 'bg-background_color_1')]" +
            "//span[@id = 'phoneNumber']")
    private WebElement servicePhoneButton;
    @FindBy(xpath = "(//span[contains(text(), 'Explore Membership')])[1]")
    private WebElement exploreMembershipButton;
    @FindBy(xpath = "(//span[contains(text(), 'Explore Financing')])[1]")
    private WebElement exploreFinancingButton;
    @FindBy(xpath = "//div[*[contains(text(), 'Answers')]]//span[@id='phoneNumber']")
    private WebElement answersDivPhoneNumber;

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
                "//div[contains(@class, 'sm:min-h-[7.5rem]') and ./p[%s]]",
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
}
