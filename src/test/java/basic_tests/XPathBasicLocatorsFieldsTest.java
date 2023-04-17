package basic_tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class XPathBasicLocatorsFieldsTest {

    @Test
    public void xpathAndCssLocatorsHowToWrite() {
        open("https://www.youtube.com");

        SelenideElement cssSearchField = $(By.cssSelector("div input[id='search']"));
        SelenideElement xpathSearchField = $(By.xpath("//*[contains(@name,'search')]"));

        List<SelenideElement> xpathListOfElements = $$(By.xpath(
                "//div[@id = 'sections']/ytd-guide-section-renderer"));
        SelenideElement xpathType = $(By.xpath("//*[contains(@type,'text')]"));

    }

}
