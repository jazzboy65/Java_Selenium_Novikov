package steps;

import pages.SearchPage;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage();

    public SearchResultSteps searchByKeyword(String keyword) {
        searchPage.fillTheSearchField(keyword);

        searchPage.pressEnter();

        return new SearchResultSteps();
    }

}
