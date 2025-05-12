package utils;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigReader {
    static Properties prop;
    public static String get(String key) {
        try {
            if (prop == null) {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
                prop.load(fis);
            }
            return prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Error loading config: " + e.getMessage());
            return null;
        }
    }
    public static String getDriverPath(String browser) {
        String driverPath = "";
        if (browser.equalsIgnoreCase("chrome")) {
            driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
        } else if (browser.equalsIgnoreCase("edge")) {
            driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/msedgedriver";
        } else if (browser.equalsIgnoreCase("safari")) {
            driverPath = ""; // Safari driver is built-in
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }
        // Windows adjustment
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            driverPath += ".exe";
        }
        return driverPath;
    }
}