package basic_tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static basic_tests.base_locators.BaseLocators.searchResult;


public class SearchWithEnterButtonTest {
    @Test
    public void searchWithEnterButton() {
        open("https://www.google.com/");

        SelenideElement googleSearchField = $(By.xpath(
                "//input[@title='Поиск']"));
        googleSearchField.clear();

        googleSearchField.sendKeys("java");
        googleSearchField.sendKeys(Keys.ENTER);

        System.out.println(searchResult.size());

        SelenideElement timeOfRequest = $(By.xpath(
                "//nobr"));
        System.out.println(timeOfRequest.getText());
    }
}
