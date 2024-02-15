package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final String  EMAIL_CSS = "[name=email]";
    private final String  PASSWORD_CSS = "[name=password]";
    private final String  SUBMIT_BTN_CSS = "[type=submit]";
    private final String ERROR_MSG_TEXT = "This field is required";

    @Step("Opening login page")
    public void openPage() {
        open("/login");
    }

    @Step("Login by \"{user}\", \"{pass}\"")
    public void login(String user, String pass) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(pass);
        $(SUBMIT_BTN_CSS).click();
    }

    @Step("Press login button and check for error message")
    public void pressLoginButton() {
        $(SUBMIT_BTN_CSS).click();
        $(byText(ERROR_MSG_TEXT)).shouldBe(Condition.visible);
    }
}
