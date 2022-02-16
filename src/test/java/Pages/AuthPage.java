package Pages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constats.Common.*;

public class AuthPage extends BaseTest {

    public static WebElement authorisation () {
        return driver.findElement(By.xpath(AUTHORIZATION_BUTTON_PATH));
    }

    public static WebElement variantsAuthorisation () {
        return driver.findElement(By.xpath(MORE_VARIANTS_FOR_AUTHORIZATION_BUTTON_PATH));
    }

    public static WebElement withEmailVariant () {
        return driver.findElement(By.xpath(AUTHORIZATION_WITH_EMAIL_BUTTON_PATH));
    }

    public static WebElement emailInput () {
        return (new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_INPUT_PATH))));
    }

    public static WebElement passwordInput () {
        return (new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASSWORD_INPUT_PATH))));
    }

    public static WebElement enterButton () {
        return (new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTER_BUTTON_PATH))));
    }

}
