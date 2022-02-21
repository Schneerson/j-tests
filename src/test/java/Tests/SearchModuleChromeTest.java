package Tests;

import Application.app;
import Helper.SearchResultAnalysisHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static Constats.Common.NOTHING_IS_FOUNDED_ALERT_TEXT;

public class SearchModuleChromeTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_valid_search.csv", numLinesToSkip = 1)
    void enterValidValueInSearchBar(String input, String expectedTag1, String expectedTag2) throws InterruptedException {
        app.openMainPage();
        app.closeMainPageAlert();
        app.makeSearchRequest(input);

         Assertions.assertTrue(SearchResultAnalysisHelper.isInSearch(app.getProductNamesFromSearchResult(),
               new String[] {expectedTag1,expectedTag2}));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_invalid_search.csv", numLinesToSkip = 1)
    void enterInvalidValueInSearchBar(String input) throws InterruptedException {
        app.openMainPage();
        app.closeMainPageAlert();
        app.makeSearchRequest(input);

        Assertions.assertEquals(NOTHING_IS_FOUNDED_ALERT_TEXT,app.nothingIsFoundedAlertText());
    }

}
