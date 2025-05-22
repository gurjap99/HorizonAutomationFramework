package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    WebDriver driver;
    // Header Elements
    @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[1]/a[1]/div[1]/img[1]")
    private WebElement logo;
    @FindBy(css = "header nav")
    private WebElement mainNav;
    @FindBy(css = "header .phone-number")
    private WebElement phoneNumber;
    @FindBy(css = "header .cta-button")
    private WebElement headerCtaButton;
    // Hero Section Elements
    @FindBy(css = ".hero-section")
    private WebElement heroSection;
    @FindBy(css = ".hero-section h1")
    private WebElement heroHeading;
    @FindBy(css = ".hero-section .cta-button")
    private WebElement heroCtaButton;
    // Services Section Elements
    @FindBy(css = ".services-section")
    private WebElement servicesSection;
    @FindBy(css = ".services-section .service-item")
    private List<WebElement> serviceItems;
    // Testimonials Section Elements
    @FindBy(css = ".testimonials-section")
    private WebElement testimonialsSection;
    @FindBy(css = ".testimonials-section .testimonial")
    private List<WebElement> testimonials;
    // Special Offers Section Elements
    @FindBy(css = ".offers-section")
    private WebElement offersSection;
    @FindBy(css = ".offers-section .offer")
    private List<WebElement> offers;
    // Footer Elements
    @FindBy(css = "footer")
    private WebElement footer;
    @FindBy(css = "footer .footer-nav")
    private WebElement footerNav;
    @FindBy(css = "footer .social-icons a")
    private List<WebElement> socialLinks;
    @FindBy(css = "footer .copyright")
    private WebElement copyright;
    @FindBy(css = "svg[aria-label='Plus Sign']:nth-of-type(1)")
    private WebElement plusButton;
    // New Locators
    @FindBy(xpath = "(//span[contains(text(),'Book Now')])[16]")
    private WebElement offerCTABookNowButton;
    @FindBy(xpath = "(//span[contains(@id,'phoneNumber')])[4]")
    private WebElement offerCTAPhoneNumberButton;
    @FindBy(xpath = "(//span[contains(text(),'Book Now')])[31]")
    private WebElement imageBookNowButton;
    @FindBy(xpath = "(//span[contains(@id,'phoneNumber')])[8]")
    private WebElement imagePhoneNumberButton;
    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='path' and @class='fill-primary'])[2]")
    private WebElement offerBannerPlusIcon;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'z-10')])[1]")
    private WebElement ctaElement;
    @FindBy(xpath = "(//article[contains(@class, 'mt-5')])[1]")
    private WebElement offerExpiryDate;
    @FindBy(id = "se-widget-iframe")
    private WebElement bookOnlineNowFrame;
    @FindBy(css = ".a-Icon")
    private WebElement bookNowWindowCloseButton;
    @FindBy(xpath = "(//span[contains(text(), 'Explore Heating & Cooling')])[1]")
    private WebElement exploreHeatingCoolingButton;
    @FindBy(xpath = "(//span[contains(text(), 'Explore Electrical')])[1]")
    private WebElement exploreElectricalButton;
    @FindBy(xpath = "(//span[contains(text(), 'Explore Plumbing')])[1]")
    private WebElement explorePlumbingButton;
    @FindBy(xpath = "//p[contains(text(),'Help, my air conditioner won’t turn on!')]")
    private WebElement helpMyAirConditioner;
    @FindBy(xpath = "(//span[contains(text(),'Book Now ')])[1]")
    private WebElement airConditionerBookNowButton;
    @FindBy(xpath = "(//span[contains(text(),'Book Now')])[28]")
    private WebElement waterTankBookNowButton;
    @FindBy(xpath = "(//span[@id='phoneNumber'])[6]")
    private WebElement airConditionerPhoneNumberButton;
    @FindBy(xpath = "//p[contains(text(),'Do you install tankless water heaters?')]")
    private WebElement installTanklessWaterHeater;
    @FindBy(xpath = "(//span[@id='phoneNumber'])[7]")
    private WebElement waterTankPhoneNumberButton;
    @FindBy(xpath = "//p[contains(text(),'Help, I need 24/7 emergency service!')]")
    private WebElement emergencyService;
    @FindBy(xpath = "((//div[contains(@class, 'sm:pl-[2.65%]')])[2]//span)[19]")
    private WebElement eyebrowZipCode;
    @FindBy(xpath = "(//input)[3]")
    private WebElement eyebrowZipCodeInputField;
    @FindBy(xpath = "(//span[contains(text(), 'Update')])[9]")
    private WebElement eyebrowZipCodeUpdateButton;
    @FindBy(xpath = "((//div[contains(@class, 'sm:pl-[2.65%]')])[2]//label//div)[3]")
    private WebElement eyebrowZipCodeMessage;
    @FindBy(xpath = "(//input)[4]")
    private WebElement mapInputField;
    @FindBy(xpath = "//div[@aria-label='Map']")
    private WebElement map;
    @FindBy(css = "div[class='visible opacity-100'] div[role='Close'] svg")
    private WebElement closeCTAButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//" +
            "span[contains(text(), 'Book Now')])[1]")
    private WebElement mapBookNowButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//div)[4]" +
            "//*[contains(@data-testid, 'search-icon')]")
    private WebElement mapZipcodeInputSearchButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//label//div)[5]")
    private WebElement mapZipcodeInputMessage;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'size-full')])[1]")
    private WebElement firstOfferAtBottom;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'size-full')])[2]")
    private WebElement secondOfferAtBottom;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')])[1]")
    private WebElement firstOfferDetailsLink;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')])[2]")
    private WebElement secondOfferDetailsLink;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'z-10')])[9]")
    private WebElement firstOfferDetailCtaElement;
    @FindBy(xpath = "(//article[contains(@class, 'mt-5')])[3]")
    private WebElement firstOfferDetailExpiryDate;
    @FindBy(xpath = "(//article[contains(@class, 'mt-5')])[4]")
    private WebElement secondOfferDetailExpiryDate;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')]/ following::span[contains(text(),'Book Now')])[1]")
    private WebElement firstOfferDetailCTABookNowButton;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')]/ following::span[contains(@id,'phoneNumber')])[1]")
    private WebElement firstOfferDetailsCTAPhoneNumber;
    @FindBy(xpath = "(//div[@role= 'Close'])[9]")
    private WebElement closeFirstOfferCTAButton;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')]/ following::span[contains(text(),'Book Now')])[4]")
    private WebElement secondOfferDetailCTABookNowButton;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'z-10')])[9]")
    private WebElement secondOfferDetailCtaElement;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')]/ following::span[contains(@id,'phoneNumber')])[2]")
    private WebElement secondOfferDetailsCTAPhoneNumber;
    @FindBy(xpath = "//img[@class= 'ti-logo-fb']")
    private WebElement googleReview;
    @FindBy(xpath = "//span[@class= 'ti-rating']")
    private WebElement googleRating;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Map<String, Object> getAllHeaderElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("logo", logo);
        elements.put("mainNav", mainNav);
        elements.put("phoneNumber", phoneNumber);
        elements.put("headerCtaButton", headerCtaButton);

        System.out.println("Header Elements:");
        elements.forEach((key, value) -> {
            WebElement element = (WebElement) value;
            try {
                if (element != null) {
                    System.out.println(key + ": " + element.isDisplayed());
                } else {
                    System.out.println(key + ": Element not found (null)");
                }
            } catch (Exception e) {
                System.out.println(key + ": Exception occurred: " + e.getMessage());
            }
            assert element != null;
            System.out.println(key + ": " + element.isDisplayed());
        });
        return elements;

    }

    public Map<String, Object> getAllHeroSectionElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("heroSection", heroSection);
        elements.put("heroHeading", heroHeading);
        elements.put("heroCtaButton", heroCtaButton);

        System.out.println("Hero Section Elements:");
        elements.forEach((key, value) -> {
            WebElement element = (WebElement) value;
            System.out.println(key + ": " + element.isDisplayed());
        });
        return elements;
    }

    public void getAllServicesSectionElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("servicesSection", servicesSection);
        elements.put("serviceItems", serviceItems);

        System.out.println("Services Section Elements:");
        System.out.println("servicesSection: " + servicesSection.isDisplayed());
        System.out.println("Number of service items: " + serviceItems.size());

    }

    public void getAllTestimonialsSectionElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("testimonialsSection", testimonialsSection);
        elements.put("testimonials", testimonials);

        System.out.println("Testimonials Section Elements:");
        System.out.println("testimonialsSection: " + testimonialsSection.isDisplayed());
        System.out.println("Number of testimonials: " + testimonials.size());

    }

    public Map<String, Object> getAllSpecialOffersSectionElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("offersSection", offersSection);
        elements.put("offers", offers);

        System.out.println("Special Offers Section Elements:");
        System.out.println("offersSection: " + offersSection.isDisplayed());
        System.out.println("Number of offers: " + offers.size());

        return elements;
    }

    public Map<String, Object> getAllFooterElements() {
        Map<String, Object> elements = new HashMap<>();
        elements.put("footer", footer);
        elements.put("footerNav", footerNav);
        elements.put("socialLinks", socialLinks);
        elements.put("copyright", copyright);

        System.out.println("Footer Elements:");
        System.out.println("footer: " + footer.isDisplayed());
        System.out.println("footerNav: " + footerNav.isDisplayed());
        System.out.println("Number of social links: " + socialLinks.size());
        System.out.println("copyright: " + copyright.isDisplayed());

        return elements;
    }

    // This method can be used to locate any element by its selector
    public WebElement getOfferCTABookNowButton() {
        return offerCTABookNowButton;
    }

    public WebElement getOfferCTAPhoneNumberButton() {
        return offerCTAPhoneNumberButton;
    }

    public WebElement getOfferBannerPlusIcon() {
        return offerBannerPlusIcon;
    }

    public WebElement getCtaElement() {
        return ctaElement;
    }

    public WebElement getOfferExpiryDate() {
        return offerExpiryDate;
    }

    public WebElement getBookOnlineNowFrame() {
        return bookOnlineNowFrame;
    }

    public WebElement getBookNowWindowCloseButton() {
        return bookNowWindowCloseButton;
    }

    public WebElement getExploreHeatingCoolingButton() {
        return exploreHeatingCoolingButton;
    }

    public WebElement getExploreElectricalButton() {
        return exploreElectricalButton;
    }

    public WebElement getExplorePlumbingButton() {
        return explorePlumbingButton;
    }

    public WebElement getImageBookNowButton() {
        return imageBookNowButton;
    }

    public WebElement getImagePhoneNumberButton() {
        return imagePhoneNumberButton;
    }

    public WebElement getHelpMyAirConditioner() {
        return helpMyAirConditioner;
    }

    public WebElement getAirConditionerBookNowButton() {
        return airConditionerBookNowButton;
    }

    public WebElement getAirConditionerPhoneNumberButton() {
        return airConditionerPhoneNumberButton;
    }

    public WebElement getInstallTanklessWaterHeater() {
        return installTanklessWaterHeater;
    }

    public WebElement getWaterTankBookNowButton() {
        return waterTankBookNowButton;
    }

    public WebElement getWaterTankPhoneNumberButton() {
        return waterTankPhoneNumberButton;
    }

    public WebElement getEmergencyService() {
        return emergencyService;
    }

    public WebElement getEyebrowZipCode() {
        return eyebrowZipCode;
    }

    public WebElement getEyebrowZipCodeUpdateButton() {
        return eyebrowZipCodeUpdateButton;
    }

    public boolean checkEyebrowZipCodeUpdateButtonEnabled() {
        return eyebrowZipCodeUpdateButton.isEnabled();
    }

    public void setEyebrowZipCodeInputField(String ZipCode) {
        eyebrowZipCodeInputField.sendKeys(Keys.CONTROL + "a");
        eyebrowZipCodeInputField.sendKeys(Keys.DELETE);
        eyebrowZipCodeInputField.sendKeys(ZipCode);
        System.out.println("Entered Zip Code: " + ZipCode);
    }

    public WebElement getEyebrowZipCodeMessage() {
        return eyebrowZipCodeMessage;
    }

    public Boolean isInputFieldDisplayed() {
        try {
            return mapInputField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void setMapInputField(String ZipCode) {
        mapInputField.sendKeys(ZipCode);
        System.out.println("Entered Zip Code: " + ZipCode);
    }

    public Boolean isMapDisplayed() {
        try {
            return map.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getCloseCTAButton() {
        return closeCTAButton;
    }

    public WebElement getMapBookNowButton() {
        return mapBookNowButton;
    }

    public WebElement getMapZipcodeInputSearchButton() {
        return mapZipcodeInputSearchButton;
    }

    public WebElement getMapZipcodeInputMessage() {
        return mapZipcodeInputMessage;
    }

    public WebElement getFirstOfferAtBottom() {
        return firstOfferAtBottom;
    }
    public WebElement getSecondOfferAtBottom() {
        return secondOfferAtBottom;
    }

    public WebElement getFirstOfferDetailsLink() {
        return firstOfferDetailsLink;
    }

    public WebElement getSecondOfferDetailsLink() {
        return secondOfferDetailsLink;
    }

    public WebElement getFirstOfferDetailCtaElement() {
        return firstOfferDetailCtaElement;
    }

    public WebElement getFirstOfferDetailExpiryDate() {
        return firstOfferDetailExpiryDate;
    }

    public WebElement getFirstOfferDetailCTABookNowButton() {
        return firstOfferDetailCTABookNowButton;
    }

    public WebElement getFirstOfferDetailsCTAPhoneNumber() {
        return firstOfferDetailsCTAPhoneNumber;
    }

    public WebElement getSecondOfferDetailsCTAPhoneNumber() {
        return secondOfferDetailsCTAPhoneNumber;
    }

    public WebElement getCloseFirstOfferCTAButton() {
        return closeCTAButton;
    }

    public WebElement getSecondOfferDetailCTABookNowButton() {
        return secondOfferDetailCTABookNowButton;
    }

    public WebElement getSecondOfferDetailCtaElement() {
        return secondOfferDetailCtaElement;
    }

    public WebElement getSecondOfferDetailExpiryDate() {
        return secondOfferDetailExpiryDate;
    }

    public WebElement getGoogleReview() {
        return googleReview;
    }

    public WebElement getGoogleRating() {
        return googleRating;
    }
}
