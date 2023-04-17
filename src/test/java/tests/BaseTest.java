package tests;

import helpers.DriverFactory;
import helpers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;

import java.time.Duration;


public abstract class BaseTest {
    private static WebDriver driver;
    private static WebDriverWait webDriverWait;
    SearchSteps steps;

    @BeforeClass
    public void setUp() {

//        File file = new File("src/test/resources/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        driver = new ChromeDriver();

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.navigate().to(PropertyReader.getBaseUrl());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium java"},/* {"selenium javascript"}*/};
    }
}
