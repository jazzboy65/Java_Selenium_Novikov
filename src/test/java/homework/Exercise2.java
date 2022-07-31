package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Exercise2 {

    @Test
    public void xpathAndCssLocatorsHowToWrite() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");

        WebElement cssSearchField = driver.findElement(By.cssSelector("div input[id='search']"));
        WebElement xpathSearchField = driver.findElement(By.xpath("//*[contains(@name,'search')]"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search-icon-legacy']"));
        List<WebElement> xpathListOfElements = driver.findElements(By.xpath("//div[@id = 'sections']/ytd-guide-section-renderer"));
        WebElement xpathType = driver.findElement(By.xpath("//*[contains(@type,'text')]"));

        driver.quit();
    }

}
