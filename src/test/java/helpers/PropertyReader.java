package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    public static String getBaseUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }

    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = Files.newInputStream(Paths.get("src/test/resources/framework.properties"));
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Cannot read property value for " + propertyName);
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        }
        return properties.getProperty(propertyName);
    }

    public static boolean getBrowserWindowSize(WebDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int width = size.getWidth();
        int height = size.getWidth();
        return !(width < 1920 & height < 1080);

    }
}
