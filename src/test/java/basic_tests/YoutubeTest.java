package basic_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class YoutubeTest {

    @Test
    public void openYoutubeTest() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().refresh();

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
