package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Check empty fields login")
    public void emptyLogin() {
        loginPage.openPage();
        loginPage.pressLoginButton();
    }

    @Test(description = "Login successfully")
    public void login() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.waitTillOpened();
    }
}
