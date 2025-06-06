package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ServicesOverView {
    WebDriver driver;
    
    @FindBy(xpath = "//div[@data-testid='flyout-cta-list-view-container']" +
            "//div[contains(@data-testid, 'df-button')]")
    private List<WebElement> servicesListButtons;
    @FindBy(xpath = "//div[contains(text(), 'Explore Offers & Rebates ')]")
    private WebElement exclusiveOffersAndRebates;
    @FindBy(xpath = "//div[contains(text(), 'Explore Financing ')]")
    private WebElement flexibleFinancing;
    @FindBy(xpath = "//div[contains(text(), 'Explore Membership ')]")
    private WebElement comfortMembership;

    public ServicesOverView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCtaBookNowButton(String[] ctaNames) {
        // Build the XPath condition for each ctaName using contains()
        StringBuilder h2Conditions = new StringBuilder();
        for (int i = 0; i < ctaNames.length; i++) {
            h2Conditions.append(String.format("contains(., '%s')", ctaNames[i]));
            if (i < ctaNames.length - 1) {
                h2Conditions.append(" and ");
            }
        }
        // Final XPath with dynamic h2 conditions
        String xpath = String.format(
                "(//div[contains(@class, 'sm:w-[29.5rem]') and .//h2[%s]]//span[contains(text(),'Book Now')])[1]",
                h2Conditions
        );

        return this.driver.findElement(By.xpath(xpath));
    }

    public WebElement getCtaPhoneButton(String[] ctaNames) {
        // Build the XPath condition for each ctaName using contains()
        StringBuilder h2Conditions = new StringBuilder();
        for (int i = 0; i < ctaNames.length; i++) {
            h2Conditions.append(String.format("contains(., '%s')", ctaNames[i]));
            if (i < ctaNames.length - 1) {
                h2Conditions.append(" and ");
            }
        }

        // Final XPath with dynamic h2 conditions
        String xpath = String.format(
                "//div[contains(@class, 'sm:w-[29.5rem]') and .//h2[%s]]//span[@id='phoneNumber']",
                h2Conditions
        );

        return this.driver.findElement(By.xpath(xpath));
    }

    public WebElement getCtaLearnMoreButton(String[] ctaNames) {
        // Build the XPath condition for each ctaName using contains()
        StringBuilder h2Conditions = new StringBuilder();
        for (int i = 0; i < ctaNames.length; i++) {
            h2Conditions.append(String.format("contains(., '%s')", ctaNames[i]));
            if (i < ctaNames.length - 1) {
                h2Conditions.append(" and ");
            }
        }

        // Final XPath with dynamic h2 conditions
        String xpath = String.format(
                "//div[contains(@class, 'sm:w-[29.5rem]') and .//h2[%s]]//div[contains(text(),'Learn More')]",
                h2Conditions
        );

        return this.driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getServicesListButtons() {
        return servicesListButtons;
    }

    public WebElement getOverviewImgBookNowButton(String page) {
        String xpathExpression = String.format("(//img[@alt='%s']/ following::span[contains(text(),'Book Now')])[1]", page);
        return driver.findElement(By.xpath(xpathExpression));
    }

    public WebElement getOverviewImgPhoneNumber(String page) {
        String xpathExpression = String.format("(//img[@alt='%s']/ following::span[contains(@id,'phoneNumber')])[1]", page);
        return driver.findElement(By.xpath(xpathExpression));
    }

    public WebElement getBottomServices(String type, String category) {
        String xpathExpression = String.format("(//*[self::h2 or self::h3][text()= '%s']/following::a//div[contains(text(), '%s')])[1]", type, category);
        return driver.findElement(By.xpath(xpathExpression));
    }

    public WebElement getExclusiveOffersAndRebates() {
        return exclusiveOffersAndRebates;
    }

    public WebElement getFlexibleFinancing() {
        return flexibleFinancing;
    }

    public WebElement getComfortMembership() {
        return comfortMembership;
    }


}
