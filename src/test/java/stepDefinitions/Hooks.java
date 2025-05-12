package stepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverFactory;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
public class Hooks {
    @Before
    public void setUp() throws MalformedURLException {
        String platform = ConfigReader.get("platform"); // read from config.properties
        WebDriver driver = DriverFactory.initializeDriver(platform); // pass the right variable
        DriverFactory.setDriver(driver);
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}