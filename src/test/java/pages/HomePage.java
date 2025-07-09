package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    WebDriver driver;
    private WebDriverWait wait; // Declare WebDriverWait at class level for reusability

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
    @FindBy(css = "div[class='visible opacity-100'] div[role='Close']")
    private WebElement closeCTAButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//" +
            "span[contains(text(), 'Book Now')])[1]")
    private WebElement mapBookNowButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//div)[4]" +
            "//*[contains(@data-testid, 'search-icon')]")
    private WebElement mapZipcodeInputSearchButton;
    @FindBy(xpath = "(//div[contains(@class, 'flex-col') and contains(@class, 'sm:col-start-2')]//label//div)[5]")
    private WebElement mapZipcodeInputMessage;
    @FindBy(xpath = "(//div[contains(@class, 'relative') and contains(@class, 'z-10')])[9]")
    private WebElement offerDetailCtaElement;
    @FindBy(xpath = "(//a[contains(text(), 'Offer Details')]/ following::span[contains(@id,'phoneNumber')])[2]")
    private WebElement secondOfferDetailsCTAPhoneNumber;
    @FindBy(xpath = "//span[contains(text(), 'View') and contains(text(), 'Offers') and contains(text(), 'Rebates')][1]")
    private WebElement offersRebatesButton;
    @FindBy(xpath = "//img[@class= 'ti-logo-fb']")
    private WebElement googleReview;
    @FindBy(xpath = "//span[@class= 'ti-rating']")
    private WebElement googleRating;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout slightly

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
        mapInputField.sendKeys(Keys.CONTROL + "a");
        mapInputField.sendKeys(Keys.DELETE);
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

    public WebElement getOffersAtBottom(int offerNo) {
        return driver.findElement(By.xpath(String.format("(//div[contains(@class, 'relative') and " +
                        "contains(@class, 'size-full')])[%s]", offerNo)));
    }

    public WebElement getOfferDetailsLink(int offerNo) {
        return driver.findElement(By.xpath(String.format("(//a[contains(text(), 'Offer Details')])[%s]",
                offerNo)));
    }

    public WebElement getOfferDetailCtaElement() {
        List<WebElement> offerDetailCtas = driver.findElements(By.xpath(
                "//div[contains(@class, 'relative') and contains(@class, 'z-10')]"));
        for(WebElement el : offerDetailCtas){
            if(el.isDisplayed()) return el;
        }
        return null;
    }

    public WebElement getOfferDetailExpiryDate() {
        List<WebElement> bookNowButtons = driver.findElements(By.xpath("//article[contains(@class, 'mt-5')]"));
        for(WebElement el : bookNowButtons){
            if(el.isDisplayed()) return el;
        }
        return null;
    }

    public WebElement getActiveCTABookNowButton() {
        // XPath to locate all potential CTA containers (based on your provided common structure)
        // Ensure this XPath is broad enough to catch all instances on different pages
        String commonCTAParentXPath = "//div[contains(@class,'w-[22.625rem]') and contains(@class,'sm:w-[29.5rem]')" +
                " and .//article[contains(text(),'Expires')]]";

        // Relative XPath for the "Book Now" anchor within such a CTA container
        String bookNowButtonRelativeXPath = ".//a[.//span[contains(text(),'Book')]]";

        List<WebElement> allPotentialCTACardContainers = driver.findElements(By.xpath(commonCTAParentXPath));

        if (allPotentialCTACardContainers.isEmpty()) {
            throw new NoSuchElementException("No CTA card containers found on the page using XPath: " + commonCTAParentXPath);
        }

        System.out.println("Found " + allPotentialCTACardContainers.size() + " potential CTA card containers.");

        for (WebElement ctaContainer : allPotentialCTACardContainers) {
            try {
                // Check if the container itself is visible. This is a primary filter.
                // Use a short wait for visibility on each container.
                WebElement visibleContainer = wait.until(ExpectedConditions.visibilityOf(ctaContainer));

                // If the container is visible, try to find and wait for its "Book Now" button to be clickable.
                WebElement bookNowButton = visibleContainer.findElement(By.xpath(bookNowButtonRelativeXPath));

                // This is the most important step: wait until the specific "Book Now" button is clickable.
                // If it's clickable, it means it's likely the active/interactive one.
                // Use a shorter specific wait for the button itself if the container is already visible.
                return wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));

            } catch (TimeoutException e) {
                // This container or its button was not visible/clickable within the wait time.
                // This is expected for hidden/inactive CTAs. Continue to the next.
                System.out.println("CTA container or its 'Book Now' button not currently visible/clickable. Trying next.");
            } catch (NoSuchElementException e) {
                // The "Book Now" button was not found within this specific container,
                // or the container itself became stale. Continue to the next.
                System.out.println("No 'Book Now' button found within this CTA container, or element is stale. Trying next.");
            }
        }

        throw new NoSuchElementException("No active or clickable 'Book Now' CTA found among the available containers.");
    }

    public WebElement getFirstOfferDetailsCTAPhoneNumber(int offerNo) {
        return driver.findElement(By.xpath(String.format("(//a[contains(text(), 'Offer Details')]/ " +
                        "following::span[contains(@id,'phoneNumber')])[%s]", offerNo)));
    }

    public WebElement getSecondOfferDetailsCTAPhoneNumber() {
        return secondOfferDetailsCTAPhoneNumber;
    }

    public WebElement getCloseOfferCTAButton() {
        return closeCTAButton;
    }

    public WebElement getGoogleReview() {
        return googleReview;
    }

    public WebElement getGoogleRating() {
        return googleRating;
    }

    public WebElement getOffersRebatesButton() {
        return offersRebatesButton;
    }

    public WebElement getActiveBookNowButton() {
        // XPath to locate all potential 'Book Now' buttons within relevant CTA containers
        String bookNowButtonXPath = "//div[contains(@class,'w-[22.625rem]') and contains(@class,'sm:w-[29.5rem]') and " +
                ".//article[contains(text(),'Expires')]]//a[.//span[contains(text(),'Book')]]";

        List<WebElement> bookNowButtons = driver.findElements(By.xpath(bookNowButtonXPath));

        if (bookNowButtons.isEmpty()) {
            throw new NoSuchElementException("No 'Book Now' buttons found on the page using XPath: " + bookNowButtonXPath);
        }

        System.out.println("Found " + bookNowButtons.size() + " potential 'Book Now' buttons.");

        for (WebElement button : bookNowButtons) {
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

        throw new NoSuchElementException("No active or clickable 'Book Now' button found among the available elements.");
    }
}
