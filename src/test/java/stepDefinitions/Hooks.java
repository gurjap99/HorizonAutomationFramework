package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.initializeDriver();
        DriverFactory.setDriver(driver);

        // Clear cookies
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}