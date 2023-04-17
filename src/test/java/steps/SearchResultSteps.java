package steps;

import pages.SearchResultPage;

public class SearchResultSteps {
    private SearchResultPage searchResultPage = new SearchResultPage();

    public SearchResultSteps verifyThatTopValueIsCorrect(String expectedValue) {
        searchResultPage.assertThatExpectedValueIsOnSearchTop(expectedValue);
        return this;
    }

    public SearchResultSteps verifyThatAllResultsContainWord(String expectedValue) {
        searchResultPage.assertThatAllSearchResultsContainsWord(expectedValue);
        return this;
    }
}
