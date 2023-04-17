package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SearchResultPage extends BasePage {
    private By searchResultURLsBy =
            By.xpath("//cite[contains(@class,'iUh30')]");


    private By searchResultULRsH3 =
            By.xpath("//cite[contains(@class,'iUh30')]/../../h3[not(contains(@style,'display:none'))]");
    //cite[contains(@class,'iUh30')]/../../h3[not(contains(@style,'display:none'))]
    //cite[contains(@class,'iUh30')]/../../h3[contains(@style,'display:none')]

    public SearchResultPage(){ super();}

    public void assertThatExpectedValueIsOnSearchTop(String expectedValue) {
        List<WebElement> searchResultURLs =
                driver.findElements(searchResultURLsBy);

        assertEquals(searchResultURLs.get(0).getText(),
                expectedValue, expectedValue + " is not the first result!");
    }

    public void assertThatAllSearchResultsContainsWord(String expectedValue) {
        List<WebElement> searchResultURLs =
                driver.findElements(searchResultULRsH3);

        List<WebElement> notEmpty = searchResultURLs
                .stream().
                filter(Objects::nonNull)
                .collect(Collectors.toList());

        for(int i = 0;i<searchResultURLs.size();i++) {
            System.out.println(notEmpty.get(i).getText());
        }

        searchResultURLs.forEach(e-> {
            boolean result = e.getText().toLowerCase().contains(expectedValue.toLowerCase());
            assertTrue(result);
        });

    }
}

