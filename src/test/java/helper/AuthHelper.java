package helper;

import Pages.AuthPage;
import Tests.BaseTest;

import static Constats.Common.EMAIL;
import static Constats.Common.PASSWORD;

public class AuthHelper extends BaseTest {

    public static void toSignInWithEmail() throws InterruptedException {
        AuthPage.authorisation().click();
        AuthPage.variantsAuthorisation().click();
        AuthPage.withEmailVariant().click();
        AuthPage.emailInput().sendKeys(EMAIL);
        AuthPage.passwordInput().sendKeys(PASSWORD);
        AuthPage.enterButton().click();
        Thread.sleep(3000);
    }

}
