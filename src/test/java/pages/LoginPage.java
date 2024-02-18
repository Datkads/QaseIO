package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {
    private final String  EMAIL_CSS = "[name=email]";
    private final String  PASSWORD_CSS = "[name=password]";
    private final String  SUBMIT_BTN_CSS = "[type=submit]";
    private final String ERROR_MSG_TEXT = "This field is required";

    @Step("Opening login page")
    public void openPage() {
        log.info("Opening login page");
        open("/login");
    }

    @Step("Logging with personal credentials")
    public void login(String user, String pass) {
        log.info("Logging with personal credentials");
        $(EMAIL_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(pass);
        $(SUBMIT_BTN_CSS).click();
    }

    @Step("Pressing login button")
    public void pressLoginButton() {
        log.info("Pressing login button");
        $(SUBMIT_BTN_CSS).click();
    }

    @Step("Checking if error message is appeared")
    public void checkIfErrorIsAppeared() {
        log.info("Checking if error message is appeared");
        $(byText(ERROR_MSG_TEXT)).shouldBe(Condition.visible);
    }
}
