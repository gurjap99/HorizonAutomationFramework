package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
public class Hooks {
    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.initializeDriver(); // pass the right variable
        DriverFactory.setDriver(driver);
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}