package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Constats.Common.*;


public class ProductPage extends BaseTest {

    public static WebElement productNameInPage () {
        return driver.findElement(By.xpath(PRODUCT_NAME_XPATH));
    }

    public static WebElement addToFavorite () {
        List <WebElement> buttons = driver.findElements(By.xpath(GET_LINK_BUTTON_PATH));
        return buttons.get(0);
    }

    public static WebElement getLink () {
        List <WebElement> buttons = driver.findElements(By.xpath(GET_LINK_BUTTON_PATH));
        return buttons.get(1);
    }

    public static WebElement addToCartButton () {
        return driver.findElement(By.xpath(CART_BUTTON_XPATH));
    }

    public static WebElement moveToCartButton () {
        List <WebElement> buttons = driver.findElements(By.xpath(PRODUCT_ADDED_TO_CART_ALERT_BUTTON));
        return buttons.get(3);
    }

    public static WebElement buyNowButton () {
        return driver.findElement(By.xpath(BUY_NOW_BUTTON_PATH));
    }

    public static WebElement colourOption () {
        return driver.findElement(By.xpath(OPTION_COLOUR_BUTTON_XPATH));
    }

    public static WebElement sizeOption () {
        return driver.findElement(By.xpath(OPTION_SIZE_BUTTON_XPATH));
    }

    public static WebElement colourStatus () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(NOT_CHOOSING_COLOUR_OPTION_ALERT_XPATH))));
    }

    public static WebElement sizeStatus () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH))));
    }

    public static WebElement productShareLink () {
        return driver.findElement(By.xpath(LINK_ON_PRODUCT_PATH));
    }

    public static WebElement profile () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(PROFILE_XPATH))));
    }

    public static WebElement favoriteList () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(FAVORITE_BUTTON_XPATH))));
    }

    public static WebElement alert () {
        return (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_ALERT_PATH))));
    }

}
