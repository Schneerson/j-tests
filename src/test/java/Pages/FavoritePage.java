package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constats.Common.*;

public class FavoritePage extends BaseTest {

    public static WebElement productNameInFavorite () {
        return driver.findElement(By.xpath(NAME_IN_FAVORITE));
    }

    public static WebElement removeFromFavoriteButton () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE_FROM_FAVORITE_BUTTON_XPATH))));
    }

}
