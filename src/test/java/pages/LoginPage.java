package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final String  EMAIL_CSS = "[name=email]";
    private final String  PASSWORD_CSS = "[name=password]";
    private final String  SUBMIT_BTN_CSS = "[type=submit]";
    public void openPage() {
        open("/login");
    }

    public void login(String user, String pass) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(pass);
        $(SUBMIT_BTN_CSS).click();
    }
}
