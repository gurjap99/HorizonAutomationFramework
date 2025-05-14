package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav//ul[@class='flex md:gap-4 xlg:gap-8']")
    private WebElement menu;

    @FindBy(xpath = "(//span[contains(text(),'Heating & Cooling')])[2]")
    private WebElement heatingAndCooling;

    @FindBy(xpath = "(//span[contains(text(),'Plumbing')])[2]")
    private WebElement plumbing;

    @FindBy(xpath = "(//span[contains(text(),'Electrical')])[2]")
    private WebElement electrical;

    @FindBy(xpath = "(//span[contains(text(),'Ways to Save')])[2]")
    private WebElement waysToSave;

    @FindBy(xpath = "(//a[contains(text(),'Learn')])[2]")
    private WebElement learn;

    @FindBy(xpath = "(//span[contains(text(),'About Us')])[2]")
    private WebElement aboutUs;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[1]")
    private WebElement heatingAndCoolingSubMenu;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[2]")
    private WebElement plumbingSubMenu;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[3]")
    private WebElement electricalSubMenu;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[4]")
    private WebElement waysToSaveSubMenu;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[5]")
    private WebElement learnSubMenu;

    @FindBy(xpath = "(//div[@class='basis-1/2'])[6]")
    private WebElement aboutUsSubMenu;

    @FindBy(xpath = "(//span[contains(text(),'Book Now')])[22]")
    private WebElement headerBookNowBtn;

    @FindBy(xpath = "(//span[@id='phoneNumber'])[5]")
    private WebElement headerPhoneNumberButton;

    public WebElement getMenu() {
        return menu;
    }

    public WebElement getHeatingAndCooling() {
        return heatingAndCooling;
    }

    public WebElement getHeatingAndCoolingSubMenu() {
        return heatingAndCoolingSubMenu;
    }

    public WebElement getPlumbing() {
        return plumbing;
    }

    public WebElement getElectrical() {
        return electrical;
    }

    public WebElement getWaysToSave() {
        return waysToSave;
    }

    public WebElement getLearn() {
        return learn;
    }

    public WebElement getAboutUs() {
        return aboutUs;
    }

    public WebElement getPlumbingSubMenu() {
        return plumbingSubMenu;
    }

    public WebElement getElectricalSubMenu() {
        return electricalSubMenu;
    }

    public WebElement getWaysToSaveSubMenu() {
        return waysToSaveSubMenu;
    }

    public WebElement getLearnSubMenu() {
        return learnSubMenu;
    }

    public WebElement getAboutUsSubMenu() {
        return aboutUsSubMenu;
    }

    public WebElement getHeaderBookNowBtn() {
        return headerBookNowBtn;
    }

    public WebElement getHeaderPhoneNumberButton() {
        return headerPhoneNumberButton;
    }

}
