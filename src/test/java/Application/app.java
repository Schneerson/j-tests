package Application;

import Pages.*;
import Tests.BaseTest;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Constats.Common.*;
import static java.lang.Integer.parseInt;

public class app extends BaseTest {

    public static void openWebPageForProductWithoutParams() throws InterruptedException {
        driver.get(PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL);
        Thread.sleep(3000);
    }

    public static void openWebPageForProductWithParams() throws InterruptedException {
        driver.get(PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL);
        Thread.sleep(3000);
    }

    public static void openWebPageWithReceivedLink(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
    }

    public static void openWebPageForSecondProductWithoutParams() throws InterruptedException {
        driver.get(PRODUCT_PAGE_URL);
        Thread.sleep(3000);
    }

    public static String rememberProductName () {
        return ProductPage.productNameInPage().getText();
    }

    public static void addProductInCart () throws InterruptedException {
        ProductPage.addToCartButton().click();
        Thread.sleep(3000);
    }

    public static void moveToCart () throws InterruptedException {
        ProductPage.moveToCartButton().click();
        Thread.sleep(1000);
    }

    public static String getProductNameFromCart (Integer index) {
        List<WebElement> products = CartPage.productNamesInCart();
        return products.get(index).getText();
    }

    public static Integer getProductQuantityFromCart (Integer index) {
        List<WebElement> counts = CartPage.productCountsInCart();
        return parseInt(counts.get(index).getText());
    }

    public static void chooseSizeOption () {
        ProductPage.sizeOption().click();
    }

    public static void chooseColourOption () {
        ProductPage.colourOption().click();
    }

    public static String getSizeOptionStatus () {
        return ProductPage.sizeStatus().getText();
    }

    public static String getColourOptionStatus () {
        return ProductPage.colourStatus().getText();
    }

    public static void pushBuyNow () throws InterruptedException {
        ProductPage.buyNowButton().click();
        Thread.sleep(3000);
    }

    public static void pushShareButton () throws InterruptedException {
        ProductPage.getLink().click();
        Thread.sleep(3000);
    }

    public static String getLinkFromShareWindow () {
        return ProductPage.productShareLink().getText();
    }

    public static String getProductStatus () {
        return ProductPage.addToFavorite().getText();
    }

    public static void addToFavorite () throws InterruptedException {
        ProductPage.addToFavorite().click();
        Thread.sleep(3000);
    }

    public static void moveToFavorite () throws InterruptedException {
        ProductPage.profile().click();
        Thread.sleep(1000);
        ProductPage.favoriteList().click();
        Thread.sleep(3000);
    }

    public static String getProductNameFromFavoriteList () {
        return FavoritePage.productNameInFavorite().getText();
    }

    public static void removeFromFavorite () throws InterruptedException {
        FavoritePage.removeFromFavoriteButton().click();
        Thread.sleep(1000);
    }

    public static void closeAlert () throws InterruptedException {
        ProductPage.alert().click();
        Thread.sleep(2000);
    }

    public static void openMainPage () throws InterruptedException {
        driver.get(MAIN_PAGE_URL);
        Thread.sleep(3000);
    }

    public static void closeMainPageAlert () throws InterruptedException {
        MainPage.alert().click();
        Thread.sleep(2000);
    }

    public static void makeSearchRequest (String input) throws InterruptedException {
        MainPage.searchInput().sendKeys(input);
        MainPage.submitButton().click();
        Thread.sleep(3000);
    }

    public static String[] getProductNamesFromSearchResult () {
        List<WebElement> elementsNames = SearchResultPage.productNamesInSearchResult();
        String[] productNames = new String[PRODUCTS_IN_SEARCH_RESULT];
        for (int i = 0; i < PRODUCTS_IN_SEARCH_RESULT; i++) {
            productNames[i] = elementsNames.get(i).getText();
        }
        return productNames;
    }

}
