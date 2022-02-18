package Tests;

import Application.app;
import Helper.AuthHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Constats.Common.*;

class ProductSelectionChromeTest extends BaseTest  {
    @Test
    void addingProductWithoutOptionsToCart() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        String productNameInPage = app.rememberProductName();
        app.addProductInCart();
        app.moveToCart();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
    }


    @Test
    void addingProductWithOptionsToCart() throws InterruptedException {
        app.openWebPageForProductWithParams();
        String productNameInPage = app.rememberProductName();
        app.chooseColourOption();
        app.chooseSizeOption();
        app.addProductInCart();
        app.moveToCart();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
    }

    @Test
    void noChoosingAnyOptionsWhenAddToCart() throws InterruptedException {
        app.openWebPageForProductWithParams();
        app.addProductInCart();

        Assertions.assertEquals(NOT_CHOOSING_COLOUR_OPTION_ALERT, app.getColourOptionStatus());
        Assertions.assertEquals(NOT_CHOOSING_SIZE_OPTION_ALERT, app.getSizeOptionStatus());
    }

    @Test
    void noChoosingOneOptionWhenAddToCart() throws InterruptedException {
        app.openWebPageForProductWithParams();
        app.chooseColourOption();
        app.addProductInCart();

        Assertions.assertEquals(NOT_CHOOSING_SIZE_OPTION_ALERT, app.getSizeOptionStatus());
    }

    @Test
    void buyNowProductWithoutOptions() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        String productNameInPage = app.rememberProductName();
        app.pushBuyNow();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
    }

    @Test
    void buyNowProductWithOptions() throws InterruptedException {
        app.openWebPageForProductWithParams();
        String productNameInPage = app.rememberProductName();
        app.chooseColourOption();
        app.chooseSizeOption();
        app.pushBuyNow();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
    }

    @Test
    void noChoosingAnyOptionsWhenBuyNow() throws InterruptedException {
        app.openWebPageForProductWithParams();
        app.pushBuyNow();

        Assertions.assertEquals(NOT_CHOOSING_COLOUR_OPTION_ALERT, app.getColourOptionStatus());
        Assertions.assertEquals(NOT_CHOOSING_SIZE_OPTION_ALERT, app.getSizeOptionStatus());
    }

    @Test
    void noChoosingOneOptionWhenAddBuyNow() throws InterruptedException {
        app.openWebPageForProductWithParams();
        app.chooseColourOption();
        app.pushBuyNow();

        Assertions.assertEquals(NOT_CHOOSING_SIZE_OPTION_ALERT, app.getSizeOptionStatus());
    }

    @Test
    void getLinkForProduct() throws InterruptedException {
        app.openWebPageForProductWithParams();
        String productNameBeforeFollowingLink = app.rememberProductName();
        app.pushShareButton();
        app.openWebPageWithReceivedLink(app.getLinkFromShareWindow());

        Assertions.assertEquals(productNameBeforeFollowingLink, app.rememberProductName());
    }

    @Test
    void addToFavorite() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        AuthHelper.toSignInWithEmail();
        String productNameBeforeAdding = app.rememberProductName();
        app.addToFavorite();

        Assertions.assertEquals(ADDED_TO_FAVORITE_STATUS, app.getProductStatus());

        app.moveToFavorite();

        Assertions.assertEquals(productNameBeforeAdding, app.getProductNameFromFavoriteList());
        app.removeFromFavorite();  // this command is needed to be able to use the test several times in a row
    }

    @Test
    void doubleClickForAddingProductToCart() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        String productNameInPage = app.rememberProductName();
        app.addProductInCart();
        // The following command must close the pop-up alert, however, this alert stopped appearing recently
        //app.closeAlert();
        app.addProductInCart();
        app.moveToCart();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
        Assertions.assertEquals(PRODUCT_COUNT, app.getProductQuantityFromCart(0));
    }

    @Test
    void addingProductToCartWithPushBuyNowButton() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        String productNameInPage = app.rememberProductName();
        app.addProductInCart();
        // The following command must close the pop-up alert, however, this alert stopped appearing recently
        //app.closeAlert();
        app.pushBuyNow();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
        Assertions.assertEquals(PRODUCT_COUNT, app.getProductQuantityFromCart(0));
    }

    @Test
    void doubleClickForBuyNow() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        String productNameInPage = app.rememberProductName();
        app.pushBuyNow();
        app.openWebPageForProductWithoutParams();
        app.pushBuyNow();

        Assertions.assertEquals(productNameInPage, app.getProductNameFromCart(0));
        Assertions.assertEquals(PRODUCT_COUNT, app.getProductQuantityFromCart(0));
    }

    @Test
    void addingThreeProductInCart() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        AuthHelper.toSignInWithEmail();
        String firstProductNameInPage = app.rememberProductName();
        app.addProductInCart();
        app.openWebPageForProductWithParams();
        String secondProductNameInPage = app.rememberProductName();
        app.chooseColourOption();
        app.chooseSizeOption();
        app.addProductInCart();
        app.openWebPageForSecondProductWithoutParams();
        String thirdProductNameInPage = app.rememberProductName();
        app.addProductInCart();
        app.moveToCart();

        Assertions.assertEquals(firstProductNameInPage, app.getProductNameFromCart(2));
        Assertions.assertEquals(secondProductNameInPage, app.getProductNameFromCart(1));
        Assertions.assertEquals(thirdProductNameInPage, app.getProductNameFromCart(0));
    }

    @Test
    void addingTwoProductInCartWithBuyNowButton() throws InterruptedException {
        app.openWebPageForProductWithoutParams();
        AuthHelper.toSignInWithEmail();
        String firstProductNameInPage = app.rememberProductName();
        app.pushBuyNow();
        app.openWebPageForProductWithParams();
        String secondProductNameInPage = app.rememberProductName();
        app.chooseColourOption();
        app.chooseSizeOption();
        app.pushBuyNow();

        Assertions.assertEquals(firstProductNameInPage, app.getProductNameFromCart(1));
        Assertions.assertEquals(secondProductNameInPage, app.getProductNameFromCart(0));
    }

}