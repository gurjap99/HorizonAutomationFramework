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
}