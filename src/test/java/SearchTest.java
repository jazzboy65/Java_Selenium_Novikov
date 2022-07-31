import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SearchTest {

    @Test
    public void openGoogleComInChromeTest() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());

        WebElement searchField = driver.findElement(By.name("q"));
        WebElement googleAppsButton = driver.findElement(By.cssSelector("a[class='gb_A']"));
        WebElement googleAppsButtonAlternative = driver.findElement(By.cssSelector("div#gbwa a"));
        WebElement googleLuck = driver.findElement(By.xpath("//input[@name='btnI']"));
        List<WebElement> googleLuckList = driver.findElements(By.xpath("//input[@name='btnI']"));
        googleLuckList.get(1).click();
//        googleLuck.click();
//        searchField.click();
//        googleAppsButton.click();
//        googleAppsButtonAlternative.click();
        driver.quit();
    }
}
