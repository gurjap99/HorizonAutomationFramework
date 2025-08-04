package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver = BrowserFactory.createInstance(browser);
        DriverFactory.setDriver(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}