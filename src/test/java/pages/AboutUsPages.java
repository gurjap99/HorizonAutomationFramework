package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPages {
    WebDriver driver;

    @FindBy(xpath = "//div[./div/h1[contains(text(), 'About us')]]//a[.//span[contains(text(), 'Book')]]")
    private WebElement aboutUsOverviewImageBookNow;
    @FindBy(xpath = "//div[./div/h1[contains(text(), 'About us')]]//a[.//span[@id='phoneNumber']]")
    private WebElement aboutUsOverviewImagePhoneNow;

    public AboutUsPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAboutUsOptionButton(String option){
        return driver.findElement(By.xpath(String.format("//div[./article[contains(text(),'%s')]]//a", option)));
    }

    public WebElement getAboutUsOverviewImageBookNow() {
        return aboutUsOverviewImageBookNow;
    }

    public WebElement getAboutUsOverviewImagePhoneNow() {
        return aboutUsOverviewImagePhoneNow;
    }

    public WebElement getExploreCareersButton(int index) {
        By by = By.xpath(String.format("(//a[.//span[contains(text(),'Explore Careers')]])[%s]",
                index));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }
}
