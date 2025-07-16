package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(String platform) throws MalformedURLException {
        if (platform.equalsIgnoreCase("desktop")) {
            WebDriverManager.chromedriver().setup();
            // Setting "allow location access"
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            // Set the geolocation preference to allow (1)
            // 0: Default, 1: Allow, 2: Block

            prefs.put("profile.default_content_setting_values.geolocation", 1);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
        } else if (platform.equalsIgnoreCase("mobile-browserstack")) {
            MutableCapabilities bstackOptions = new MutableCapabilities();
            //  DesiredCapabilities caps = new DesiredCapabilities();
            bstackOptions.setCapability("userName", "karunaarshakota1");
            bstackOptions.setCapability("accessKey", "kGynkxR1PJoyenp3ypNd");
            bstackOptions.setCapability("deviceName", "Samsung Galaxy S23");
            bstackOptions.setCapability("osVersion", "13.0");
            bstackOptions.setCapability("realMobile", "true");
            bstackOptions.setCapability("sessionName", "Mobile Test - BrowserStack");

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("bstack:options", bstackOptions);
            driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}