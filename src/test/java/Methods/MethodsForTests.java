package Methods;
import Constats.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MethodsForTests  implements Common {
    public static String getProductName ( WebDriver driver ){
        WebElement productNameElement = (new WebDriverWait(driver, Duration.ofSeconds(5)).
            until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCT_NAME_XPATH))));
        return productNameElement.getText();
    }

    public static String getProductList ( WebDriver driver, Integer index ) throws InterruptedException {
        Thread.sleep(TIMING_FOR_THREAD_SLEEP/5);
        List<WebElement> productList = driver.findElements(By.xpath(PRODUCTS_IN_CART_XPATH));
        return productList.get(index).getText();
    }

    public static String getElementText ( String xpath,  WebDriver driver ){
        WebElement productNameElement = (new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
        return productNameElement.getText();
    }

    public static void clickOnButton (String xpath, String Mode, WebDriver driver) {
        if (Mode.equals("Without waiting")) {
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
        }
        if (Mode.equals("With waiting")) {
            WebElement button = (new WebDriverWait(driver,Duration.ofSeconds(3)).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
            button.click();
        }
    }

    public static void clickOnButtonFromList (String xpath, int index, WebDriver driver) {
        List<WebElement> buttons = driver.findElements(By.xpath(xpath));
        buttons.get(index).click();
    }

    public static void openWebPage (String url, WebDriver driver) throws InterruptedException {
        driver.get(url);
        Thread.sleep(TIMING_FOR_THREAD_SLEEP);
    }

    public static void toLogIn (String login, String password, WebDriver driver, String emailXpath, String passwordXpath) {
        MethodsForTests.clickOnButton(AUTHORIZATION_BUTTON_PATH, WITHOUT_WAIT_MODE, driver);

        MethodsForTests.clickOnButton(MORE_VARIANTS_FOR_AUTHORIZATION_BUTTON_PATH, WAIT_MODE, driver);

        MethodsForTests.clickOnButton(AUTHORIZATION_WITH_EMAIL_BUTTON_PATH, WAIT_MODE, driver);

        WebElement emailInput = (new WebDriverWait(driver,Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailXpath))));
        emailInput.sendKeys(login);

        WebElement passwordInput = (new WebDriverWait(driver,Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordXpath))));
        passwordInput.sendKeys(password);

        MethodsForTests.clickOnButton(ENTER_BUTTON_PATH, WAIT_MODE, driver);
    }

    public static String getTextOfElementFromList (WebDriver driver, String xpath, int index) {
        List<WebElement> button = driver.findElements(By.xpath(xpath));
        String textsOfElement = button.get(index).getText();
        return textsOfElement;
    }

}
