package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PlpPages {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@data-testid,'cta-ParagraphLinkCtum')]//a[.//span[contains(text(),'Schedule')]]")
    private WebElement sameDayAppointmentScheduleTodayButton;
    @FindBy(xpath = "(//div[contains(@data-testid,'cta-ParagraphLinkCtum')]//a[.//span[contains(text(),'Schedule')]])[2]")
    private WebElement sameDayAppointmentScheduleTodayButton2;
    @FindBy(xpath = "(//div[contains(@data-testid,'cta-ParagraphLinkCtum')]//a[.//span[contains(text(),'Schedule')]])[3]")
    private WebElement sameDayAppointmentScheduleTodayButton3;
    @FindBy(xpath = "//div[contains(@data-testid,'two-column-right')]//a[.//span[contains(text(),'Book')]]")
    private WebElement bookNowButtonByImages;
    @FindBy(xpath = "//div[contains(@data-testid,'two-column-right')]//a[.//span[contains(@id,'phoneNumber')]]")
    private WebElement phoneButtonByImages;
    @FindBy(xpath = "//div[contains(@class, 'ti-no-profile-img')]//div[contains(@class, 'source-Google')]")
    private List<WebElement> googleRatingDivs;

    public PlpPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getBookNowButtonByImages() {
        return bookNowButtonByImages;
    }

    public WebElement getPhoneButtonByImages() {
        return phoneButtonByImages;
    }

    public WebElement getSameDayAppointmentScheduleTodayButton() {
        return sameDayAppointmentScheduleTodayButton;
    }

    public WebElement getActiveScheduleTodayButton() {
        // XPath to locate all potential 'Schedule Today' buttons within relevant CTA containers
        // Assuming the structure is similar to the 'Book Now' button, just with different text.
        String scheduleTodayButtonXPath = "//div[contains(@class,'w-[22.625rem]') and contains(@class,'sm:w-[29.5rem]')" +
                " and .//article[contains(text(),'Expires')]]//a[.//span[contains(text(),'Schedule Today')]]";

        List<WebElement> scheduleTodayButtons = driver.findElements(By.xpath(scheduleTodayButtonXPath));

        if (scheduleTodayButtons.isEmpty()) {
            throw new NoSuchElementException("No 'Schedule Today' buttons found on the page using XPath: " +
                    scheduleTodayButtonXPath);
        }

        System.out.println("Found " + scheduleTodayButtons.size() + " potential 'Schedule Today' buttons.");

        for (WebElement button : scheduleTodayButtons) {
            try {
                // Check if the button is displayed and then wait for it to be clickable.
                // This ensures we only interact with visible and active buttons.
                if (button.isDisplayed()) {
                    return wait.until(ExpectedConditions.elementToBeClickable(button));
                }
            } catch (TimeoutException e) {
                // The button was not clickable within the wait time.
                // This is expected for inactive buttons. Continue to the next.
                System.out.println("Button not currently clickable. Trying next.");
            } catch (NoSuchElementException e) {
                // The button became stale or was not found, though this is less likely given the initial findElements.
                System.out.println("Button element is stale or not found. Trying next.");
            }
        }

        throw new NoSuchElementException("No active or clickable 'Schedule Today' button found among the available" +
                " elements.");
    }

    public WebElement getSameDayAppointmentScheduleTodayButton2() {
        return sameDayAppointmentScheduleTodayButton2;
    }

    public WebElement getSameDayAppointmentScheduleTodayButton3() {
        return sameDayAppointmentScheduleTodayButton3;
    }

    public List<WebElement> getGoogleRatingDivs() {
        return googleRatingDivs;
    }
}
