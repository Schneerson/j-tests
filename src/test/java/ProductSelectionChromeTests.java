import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import Constats.Common;
import org.openqa.selenium.chrome.ChromeOptions;
import Methods.MethodsForTests;
import java.time.Duration;
import static java.lang.Integer.parseInt;

class ProductSelectionChromeTest implements Common {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments( CHROME_ARGUMENTS );
        driver = new ChromeDriver( options );
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void addingProductWithoutOptionsToCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
        driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH,WITHOUT_WAIT_MODE,driver );
        MethodsForTests.clickOnButtonFromList( PRODUCT_ADDED_TO_CART_ALERT_BUTTON,3, driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        Assert.assertEquals(productNameInPage,productNameInCart);
    }

    @Test
    void addingProductWithOptionsToCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButton( OPTION_SIZE_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButtonFromList( PRODUCT_ADDED_TO_CART_ALERT_BUTTON,3,driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITH_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
    }

    @Test
    void noChoosingAnyOptionsWhenAddToCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        String notChooseColourOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_COLOUR_OPTION_ALERT_XPATH,
                driver );
        String notChooseSizeOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH,
                driver );

        Assert.assertEquals( NOT_CHOOSING_COLOUR_OPTION_ALERT, notChooseColourOptionAlertText );
        Assert.assertEquals( NOT_CHOOSING_SIZE_OPTION_ALERT, notChooseSizeOptionAlertText );
    }

    @Test
    void noChoosingOneOptionWhenAddToCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.clickOnButton (OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        String notChooseSizeOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH,
                driver );

        Assert.assertEquals( NOT_CHOOSING_SIZE_OPTION_ALERT, notChooseSizeOptionAlertText );
    }

    @Test
    void buyNowProductWithoutOptions() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
    }

    @Test
    void buyNowProductWithOptions() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButton( OPTION_SIZE_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );
        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITH_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
    }

    @Test
    void noChoosingAnyOptionsWhenBuyNow() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver );

        String notChooseColourOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_COLOUR_OPTION_ALERT_XPATH,
                driver );

        String notChooseSizeOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH,
                driver );

        Assert.assertEquals( NOT_CHOOSING_COLOUR_OPTION_ALERT, notChooseColourOptionAlertText );
        Assert.assertEquals( NOT_CHOOSING_SIZE_OPTION_ALERT, notChooseSizeOptionAlertText );
    }

    @Test
    void noChoosingOneOptionWhenAddBuyNow() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.clickOnButton( OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver );

        String notChooseSizeOptionAlertText = MethodsForTests.getProductName( NOT_CHOOSING_SIZE_OPTION_ALERT_XPATH,
                driver );

        Assert.assertEquals( NOT_CHOOSING_SIZE_OPTION_ALERT, notChooseSizeOptionAlertText );
    }

    @Test
    void getLinkForProduct() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameBeforeFollowingLink = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButtonFromList( GET_LINK_BUTTON_PATH,1, driver );

        String linkOnProduct =  MethodsForTests.getProductName( LINK_ON_PRODUCT_PATH,
                driver );

        MethodsForTests.openWebPage( linkOnProduct, driver );

        String productNameAfterFollowingLink = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        Assert.assertEquals( productNameBeforeFollowingLink, productNameAfterFollowingLink );
    }

    @Test
    void addToFavorite() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.toLogIn( EMAIL, PASSWORD, driver, EMAIL_INPUT_PATH,PASSWORD_INPUT_PATH );

        Thread.sleep(TIMING_FOR_THREAD_SLEEP);

        String productNameBeforeAdding = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButtonFromList( GET_LINK_BUTTON_PATH,0, driver );

        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String statusOfProduct = MethodsForTests.getTextOfElementFromList( driver, GET_LINK_BUTTON_PATH,0 );

        Assert.assertEquals( ADDED_TO_FAVORITE_STATUS, statusOfProduct);

        MethodsForTests.clickOnButton( PROFILE_XPATH, WAIT_MODE, driver );

        MethodsForTests.clickOnButton( FAVORITE_BUTTON_XPATH, WAIT_MODE, driver );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String productNameAfterAdding = MethodsForTests.getProductName( PRODUCT_NAME_IN_FAVORITE_PATH,
                driver );

        Assert.assertEquals( productNameBeforeAdding, productNameAfterAdding );
    }

    @Test
    void doubleClickForAddingProductToCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( CLOSE_ALERT_PATH, WAIT_MODE, driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WAIT_MODE, driver);

        MethodsForTests.clickOnButtonFromList( PRODUCT_ADDED_TO_CART_ALERT_BUTTON,3, driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        String productQuantityInCart = MethodsForTests.getProductName( COUNT_OF_PRODUCT_IN_CART_PATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
        Assert.assertEquals( PRODUCT_COUNT, parseInt(productQuantityInCart) );
    }

    @Test
    void addingProductToCartWithPushBuyNowButton() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH,WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( CLOSE_ALERT_PATH, WAIT_MODE, driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WAIT_MODE, driver );

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        String productQuantityInCart = MethodsForTests.getProductName( COUNT_OF_PRODUCT_IN_CART_PATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
        Assert.assertEquals( PRODUCT_COUNT, parseInt(productQuantityInCart) );
    }

    @Test
    void doubleClickForBuyNow() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String productNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WITHOUT_WAIT_MODE, driver);

        String productNameInCart = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_CART_XPATH,
                driver );

        String productQuantityInCart = MethodsForTests.getProductName( COUNT_OF_PRODUCT_IN_CART_PATH,
                driver );

        Assert.assertEquals( productNameInPage, productNameInCart );
        Assert.assertEquals( PRODUCT_COUNT, parseInt(productQuantityInCart) );
    }

    @Test
    void addingThreeProductInCart() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.toLogIn( EMAIL, PASSWORD, driver, EMAIL_INPUT_PATH, PASSWORD_INPUT_PATH );

        Thread.sleep( TIMING_FOR_THREAD_SLEEP );

        String firstProductNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WAIT_MODE, driver );

        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String secondProductNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( OPTION_SIZE_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.openWebPage( PRODUCT_PAGE_URL, driver );

        String thirdProductNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( CART_BUTTON_XPATH ,WITHOUT_WAIT_MODE ,driver );

        MethodsForTests.clickOnButtonFromList( PRODUCT_ADDED_TO_CART_ALERT_BUTTON,3,driver );

        String firstProductNameInCart = MethodsForTests.getProductName( THIRD_PRODUCT_IN_CART_NAME_PATH,
                driver );

        String secondProductNameInCart = MethodsForTests.getProductName( SECOND_PRODUCT_IN_CART_NAME_PATH,
                driver );

        String thirdProductNameInCart = MethodsForTests.getProductName( FIRST_PRODUCT_IN_CART_NAME_PATH,
                driver );

        Assert.assertEquals( firstProductNameInPage, firstProductNameInCart );
        Assert.assertEquals( secondProductNameInPage, secondProductNameInCart );
        Assert.assertEquals( thirdProductNameInPage, thirdProductNameInCart );
    }

    @Test
    void addingTwoProductInCartWithBuyNowButton() throws InterruptedException {
        MethodsForTests.openWebPage( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_PAGE_URL, driver );

        MethodsForTests.toLogIn( EMAIL, PASSWORD, driver, EMAIL_INPUT_PATH, PASSWORD_INPUT_PATH );

        Thread.sleep( TIMING_FOR_THREAD_SLEEP );

        String firstProductNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WAIT_MODE, driver );

        MethodsForTests.openWebPage( PRODUCT_WITH_SELECTABLE_OPTIONS_PAGE_URL, driver );

        String secondProductNameInPage = MethodsForTests.getProductName( PRODUCT_WITHOUT_SELECTABLE_OPTIONS_NAME_IN_PAGE_XPATH,
                driver );

        MethodsForTests.clickOnButton( OPTION_COLOUR_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( OPTION_SIZE_BUTTON_XPATH, WITHOUT_WAIT_MODE, driver );

        MethodsForTests.clickOnButton( BUY_NOW_BUTTON_PATH, WAIT_MODE, driver );

        String firstProductNameInCart = MethodsForTests.getProductName( THIRD_PRODUCT_IN_CART_NAME_PATH,
                driver );

        String secondProductNameInCart = MethodsForTests.getProductName( SECOND_PRODUCT_IN_CART_NAME_PATH,
                driver );

        Assert.assertEquals( firstProductNameInPage, firstProductNameInCart );
        Assert.assertEquals( secondProductNameInPage, secondProductNameInCart );
    }

}