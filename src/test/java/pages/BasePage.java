package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        this.webDriverWait = BaseTest.getWebDriverWait();
//        PageFactory.initElements(driver,this);
    }
}
