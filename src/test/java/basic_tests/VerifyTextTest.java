package basic_tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.base_locators.BaseLocators.*;
import static org.assertj.core.api.Assertions.*;



public class VerifyTextTest {

    @Test
    public void verifyTextFromGoogleSearchField() {
        open("https://www.google.com/");

        googleSearchField.setValue("selenium webdriver").pressEnter();

        SelenideElement fr = $(By.xpath(
                "//div[@class='Z26q7c UK95Uc uUuwM']/parent::div//h3[1]"));

        assertThat(fr.getText()).as
                ("words 'selenium' and 'webdriver' must be " +
                        "present in the first result row").containsAnyOf(
                "Webdriver","Selenium");



    }
}
