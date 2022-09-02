package helpers.base_locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class BaseLocators {
    public static SelenideElement googleSearchField = $(By.name
            ("q"));
    public static SelenideElement searchButton = $(By.xpath
            ("//*[@id='search-icon-legacy']"));
    public static List<SelenideElement> searchResult = $$(By.xpath(
            "//h1[.='Результаты поиска']/following-sibling::div/div"));
}
