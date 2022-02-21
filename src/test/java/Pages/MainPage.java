package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Constats.Common.*;

public class MainPage extends BaseTest {

    public static WebElement alert () {
        return driver.findElement(By.xpath(MAIN_PAGE_ALERT_XPATH));
    }

    public static WebElement searchInput () {
        return driver.findElement(By.xpath(SEARCH_INPUT_XPATH));
    }

    public static WebElement submitButton () {
        return driver.findElement(By.xpath(SUBMIT_SEARCH_BUTTON));
    }



}
