package helpers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;


public class TestBase {

    @BeforeClass
    public void driverStart() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
    }

    @AfterClass
    public void driverEnd() {
    }
}
