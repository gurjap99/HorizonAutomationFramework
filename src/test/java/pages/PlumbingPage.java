package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlumbingPage {

    WebDriver driver;

    @FindBy(xpath = "(//a[contains(text(), 'Overview')])[2]")
    private WebElement plumbingOverviewLink;



    public PlumbingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This method can be used to locate any element by its selector
    public WebElement getPlumbingOverviewLink() {
        return plumbingOverviewLink;
    }

    public WebElement getOverviewImgBookNowButton(String page) {
        String xpathExpression = String.format("(//img[@alt='%s']/ following::span[contains(text(),'Book Now')])[1]", page);
        WebElement bookNow = driver.findElement(By.xpath(xpathExpression));
        return bookNow;
    }

    public WebElement getOverviewImgPhoneNumber(String page) {
        String xpathExpression = String.format("(//img[@alt='%s']/ following::span[contains(@id,'phoneNumber')])[1]", page);
        WebElement phoneNumber = driver.findElement(By.xpath(xpathExpression));
        return phoneNumber;
    }
}
