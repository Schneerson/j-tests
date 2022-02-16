package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Constats.Common.COUNT_OF_PRODUCT_IN_CART_PATH;
import static Constats.Common.NAME_IN_CART_PATH;

public class CartPage extends BaseTest {

    public static List<WebElement> productNamesInCart() {
        return driver.findElements(By.xpath(NAME_IN_CART_PATH));
    }

    public static List<WebElement> productCountsInCart() {
        return driver.findElements(By.xpath(COUNT_OF_PRODUCT_IN_CART_PATH));
    }

}
