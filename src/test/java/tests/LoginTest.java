package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Check empty fields login")
    public void emptyLogin() {
        loginPage.openPage();
        loginPage.pressLoginButton();
        loginPage.checkIfErrorIsAppeared();
    }

    @Test(description = "Login successfully")
    public void login() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
    }
}
