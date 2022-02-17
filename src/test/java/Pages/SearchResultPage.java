package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Constats.Common.NAME_IN_FAVORITE;


public class SearchResultPage extends BaseTest {

    public static List<WebElement> productNamesInSearchResult() {
        return driver.findElements(By.xpath(NAME_IN_FAVORITE));
    }
}
