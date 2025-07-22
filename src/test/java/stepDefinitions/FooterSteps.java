package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Footer;
import utils.Data;
import utils.DriverFactory;
import utils.Helper;

import java.time.Duration;
import java.util.List;

public class FooterSteps {
    private final Footer footer;
    private final WebDriver driver;

    public FooterSteps() {
        this.driver = DriverFactory.getDriver();
        footer = new Footer(driver);
    }

    @When("I click on Book Now button in Peace of mind is on the way bar")
    public void iClickOnBookNowButtonInPeaceOfMindIsOnTheWayBar() {
        Helper.scrollToElement(driver, footer.getPeaceOfMindBookNowButton());
        Helper.clickElement(driver, footer.getPeaceOfMindBookNowButton(), Duration.ofSeconds(30));
    }

    @When("I click on phone number button in Peace of mind is on the way bar")
    public void iClickOnPhoneNumberButtonInPeaceOfMindIsOnTheWayBar() {
        Helper.clickElement(driver, footer.getPeaceOfMindCallButton(), Duration.ofSeconds(15));
    }

    @Then("I should see the footer menu list in correct order")
    public void iShouldSeeTheSubMenuOrderIsDisplayedInCorrectOrder() {
        WebElement subMenu = footer.getFooterListDiv();
        String footerList = subMenu.getText();
        String[] actualFooterList = footerList.split("\n");
        // Validate the order
        Assert.assertArrayEquals("Footer list does not match", Data.FOOTER_MENU_ITEMS, actualFooterList);
    }

    @When("Links in Services column are clicked, they redirect to correct webpages")
    public void linksInServicesColumnAreClickedTheyRedirectToCorrectWebpages() {
        List<WebElement> servicesDivLinkElements = footer.getServicesDivLinkElements();
        String[] servicesLinks = {Data.HEATING_COOLING_URL, Data.PLUMBING_URL, Data.ELECTRICAL_URL};
        for (int i = 0; i < servicesDivLinkElements.size(); i++) {
            if (driver.getCurrentUrl().equals(servicesLinks[i])) continue;
            servicesDivLinkElements.get(i).click();
            Assert.assertEquals("URL does not match ", servicesLinks[i], driver.getCurrentUrl());
            driver.navigate().back();
        }
    }

    @When("Links in Quick Links column are clicked, they redirect to correct webpages")
    public void linksInQuickLinksColumnAreClickedTheyRedirectToCorrectWebpages() {
        List<WebElement> quickLinksDivLinkElements = footer.getQuickLinksDivLinkElements();
        String[] quickLinks = {Data.LEARN_URL, Data.FINANCING_URL, Data.MEMBERSHIP_URL, Data.OFFERS_REBATES_URL};
        for (int i = 0; i < quickLinksDivLinkElements.size(); i++) {
            if (driver.getCurrentUrl().equals(quickLinks[i])) continue;
            quickLinksDivLinkElements.get(i).click();
            Assert.assertEquals("URL does not match ", quickLinks[i], driver.getCurrentUrl());
            driver.navigate().back();
        }
    }

    @When("Links in About Us column are clicked, they redirect to correct webpages")
    public void linksInAboutUsColumnAreClickedTheyRedirectToCorrectWebpages() {
        List<WebElement> aboutUsDivLinkElements = footer.getAboutUsDivLinkElements();
        String[] aboutUsLinks = {Data.WHY_HORIZON_URL, Data.REVIEWS_URL, Data.WORK_WITH_US_URL, Data.CONTACT_US_URL};
        for (int i = 0; i < aboutUsDivLinkElements.size(); i++) {
            if (driver.getCurrentUrl().equals(aboutUsLinks[i])) continue;
            aboutUsDivLinkElements.get(i).click();
            Assert.assertEquals("URL does not match ", aboutUsLinks[i], driver.getCurrentUrl());
            driver.navigate().back();
        }
    }

    @Then("Social media button image is loaded properly for {string}")
    public void socialMediaButtonImageIsLoadedProperlyFor(String altText) {
        // Locate the image element (you can refine this locator as needed)
        WebElement image = footer.getSocialMediaImage(altText);
        // Use JavaScript to check if the image is completely loaded
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean imageLoaded = (Boolean) js.executeScript(
                "return arguments[0].complete && " +
                        "typeof arguments[0].naturalWidth != 'undefined' && " +
                        "arguments[0].naturalWidth > 0;", image);
        if (imageLoaded) {
            System.out.println("✅ Image loaded successfully.");
        } else {
            System.out.println("❌ Image not loaded.");
            Assert.fail("Social media button image is not loaded properly for " + altText);
        }
    }

    @When("I click on Privacy Policy Link")
    public void iClickOnPrivacyPolicyLink() {
        Helper.clickElement(driver, footer.getPrivacyPolicyButton(), Duration.ofSeconds(20));
    }

    @When("I click on ADA Notice Link")
    public void iClickOnADANoticeLink() {
        Helper.clickElement(driver, footer.getAdaNoticeButton(), Duration.ofSeconds(20));
    }
}
