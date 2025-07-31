package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    public static WebDriver createInstance(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

//                //options to run in background
//                firefoxOptions.addArguments("--headless");
//                firefoxOptions.addArguments("--disable-gpu");
//                firefoxOptions.addArguments("--width=1920");
//                firefoxOptions.addArguments("--height=1080");

                firefoxOptions.addArguments("--disable-application-cache");
                firefoxOptions.addArguments("--disk-cache-size=0");

                firefoxOptions.addPreference("geo.enabled", true);
                firefoxOptions.addPreference("permissions.default.geo", 1);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();

//                //options to run in background
//                edgeOptions.addArguments("--headless=new");
//                edgeOptions.addArguments("--disable-gpu");
//                edgeOptions.addArguments("--window-size=1920,1080");

                edgeOptions.addArguments("--disable-application-cache");
                edgeOptions.addArguments("--disk-cache-size=0");

                Map<String, Object> edgePrefs = new HashMap<>();
                edgePrefs.put("profile.default_content_setting_values.geolocation", 1);
                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

//                //options to run in background
//                chromeOptions.addArguments("--headless=new");
//                chromeOptions.addArguments("--disable-gpu");
//                chromeOptions.addArguments("--window-size=1920,1080");

                chromeOptions.addArguments("--disable-application-cache");
                chromeOptions.addArguments("--disk-cache-size=0");

                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_setting_values.geolocation", 1);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }
}