package Tests;

import Application.app;
import helper.searchResultAnalysisHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static Constats.Common.PRODUCTS_IN_SEARCH_RESULT;

public class ParameterizedChromeTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void enterValidValueInSearchBar(String input, String expectedTag1, String expectedTag2) throws InterruptedException {
        app.openMainPage();
        app.closeMainPageAlert();
        app.makeSearchRequest(input);
        String[] productNamesFromSearchResult = app.getProductNamesFromSearchResult();

        for (int i = 0; i < PRODUCTS_IN_SEARCH_RESULT; i++) {
            System.out.println(productNamesFromSearchResult[i]);
        }
       // Assertions.assertTrue(searchResultAnalysisHelper.isInSearch(productNamesFromSearchResult, expectedTag1));
       // Assertions.assertTrue(searchResultAnalysisHelper.isInSearch(productNamesFromSearchResult, expectedTag2));
    }

}
