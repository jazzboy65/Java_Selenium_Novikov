package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Exercise3 {
    @Test
    public void searchWithEnterButton() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        WebElement googleSearchField = driver.findElement(By.xpath("//input[@title='Поиск']"));
        googleSearchField.clear();

        googleSearchField.sendKeys("java");
        googleSearchField.sendKeys(Keys.ENTER);

        List <WebElement> searchResult = driver.findElements(By.xpath("//h1[.='Результаты поиска']/../div/div[contains(@class,'g')]"));
        System.out.println(searchResult.size());
        driver.quit();
    }
}
