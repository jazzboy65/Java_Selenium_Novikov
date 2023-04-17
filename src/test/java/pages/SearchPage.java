package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

//    @FindBy(name = "q")
    private final By searchFieldBy = By.xpath("//div/input[@class='gLFyf gsfi']");

    public SearchPage() {
        super();
    }

    public void fillTheSearchField(String keyword) {
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(keyword);
    }

    public void pressEnter() {
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(Keys.RETURN);
    }
}
