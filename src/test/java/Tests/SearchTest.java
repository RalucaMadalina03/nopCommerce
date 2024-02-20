package Tests;

import ObjectData.SearchObj;
import Pages.Search.SearchPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class SearchTest extends Hooks {
    @Test
    public void testMethod(){

        SearchObj searchObj = new SearchObj(testData);

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.validateSearchesSuggestions(searchObj);
        searchPage.searchBox(searchObj);
        searchPage.validateSearches();
        searchPage.selectProduct1();
        searchPage.validateProduct1(searchObj);
        searchPage.selectProduct2();
        searchPage.validateProduct2(searchObj);
        searchPage.selectProduct3();
        searchPage.validateProduct3(searchObj);
        searchPage.accessURL(searchObj);
        searchPage.validateEmptySearch(searchObj);
        searchPage.validateInvalidSearch(searchObj);
        searchPage.deleteSearch(searchObj);
        searchPage.validateAdvancedSearch(searchObj);
    }
}
