package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactUs;
import pages.HomePage;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.DriverFactory;
import utils.Helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class ContactUsSteps {
    private final ContactUs contactUs;
    private final HomePage homePage;
    private final WebDriver driver;
    private WebDriverWait wait;

    public ContactUsSteps() {
        this.driver = DriverFactory.getDriver();
        contactUs = new ContactUs(driver);
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @When("I update Zipcode {string} using map zipcode input in Contact Us page")
    public void iUpdateZipcodeUsingMapZipcodeInputInContactUsPage(String zipCode) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(contactUs.getLocationButton()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUs.getMap());
        Thread.sleep(1000); // wait for scroll to complete

        File mapScreenshot = contactUs.getMap().getScreenshotAs(OutputType.FILE);
        Files.copy(mapScreenshot.toPath(), Paths.get("map_before.png"), StandardCopyOption.REPLACE_EXISTING);

        homePage.setMapInputField(zipCode);
        Helper.clickElement(driver, contactUs.getContactUsMapZipcodeInputSearchButton(),
                Duration.ofSeconds(20));
        Thread.sleep(3000);
    }

    @Then("Map should get updated")
    public void mapShouldGetUpdated() {
        BufferedImage img1;
        BufferedImage img2;
        // Compare images
        ImageDiffer imgDiff = new ImageDiffer();
        try {
            File mapScreenshot = contactUs.getMap().getScreenshotAs(OutputType.FILE);
            Files.copy(mapScreenshot.toPath(), Paths.get("map_after.png"), StandardCopyOption.REPLACE_EXISTING);
            img1 = ImageIO.read(new File("map_before.png"));
            img2 = ImageIO.read(new File("map_after.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageDiff diff = imgDiff.makeDiff(img1, img2);
        Assert.assertTrue("Map has not changed.", diff.hasDiff());
    }
}

