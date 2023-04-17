package basic_tests;

import tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VerifyTextSelenideAndSeleniumTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void verifyTextFromGoogleSearchFieldSelenium(String text) throws InterruptedException {
        WebElement SearchField = getDriver().findElement(By.name("q"));
        SearchField.click();
        SearchField.sendKeys(text);
        SearchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement fr = getDriver().findElement(By.xpath(
                "//div[@class='g']//h3"));

        assertThat(fr.isDisplayed()).as("Element has not been displayed").isTrue();
        assertThat(fr.getText()).as("Wrong text has been displayed").
                isEqualToIgnoringCase("WebDriver - Selenium.dev");
        assertThat(fr.getAttribute("class")).as("Wrong attribute text").contains("LC20lb");
    }
}
