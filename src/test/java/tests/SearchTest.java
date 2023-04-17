package tests;

import helpers.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class SearchTest extends BaseTest {


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
        driver.quit();
    }

    @Test
    public void openGoogleOrgContainsFeelingLuckyButtonTest() {
        WebElement feelingLuckyButton =
                getDriver().findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='RNmpXc']"));
        assertEquals(feelingLuckyButton.getAttribute("aria-label"), "Мне повезёт!",
                "Wrong text has been displayed!");
    }


    @Test
    public void searchKeywordSeleniumHaveToFindSeleniumhqOrgInTop() {
        steps.searchByKeyword("Selenium")
                .verifyThatTopValueIsCorrect("https://www.selenium.dev");
        System.out.println(PropertyReader.getBrowserWindowSize(getDriver()));
    }

    @Test
    public void searchKeywordSeleniumHaveToPlaceInEveryRow() {
        steps.searchByKeyword("Selenium")
                .verifyThatAllResultsContainWord("Selenium");
    }

    @Test
    public void searchKeywordWithWaits() {
        getWebDriverWait()
                .until(ExpectedConditions.visibilityOf(getDriver()
                        .findElement(By.xpath("//header[@class]"))));

        getWebDriverWait()
                .until(ExpectedConditions.elementToBeClickable(getDriver()
                        .findElement(By.xpath("//div[@class='CcAdNb']"))));

        steps.searchByKeyword("Java");

        getWebDriverWait().until(ExpectedConditions.invisibilityOf(getDriver()
                .findElement(By.xpath("//header[@class]"))));

    }

}
