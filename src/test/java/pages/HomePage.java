package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helper;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
}
