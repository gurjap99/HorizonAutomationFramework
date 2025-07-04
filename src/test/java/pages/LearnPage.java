package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LearnPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='grid gap-y-[2.56rem]']//a")
    private List<WebElement> learningHubLinks;
    @FindBy(xpath = "//a[.//span[text()='Next']]")
    private WebElement learnNextButton;

    public LearnPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLearningHubLinks() {
        return learningHubLinks;
    }

    public WebElement getLearnNextButton() {
        return learnNextButton;
    }

    public WebElement getPageButton(String pageNo) {
        String xpath = String.format("//a[text()='%s']", pageNo);
        return driver.findElement(By.xpath(xpath));
    }
}
