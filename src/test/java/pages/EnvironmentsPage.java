package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class EnvironmentsPage {
    private final String NEW_ENVRMNT_BTN_TEXT = "Create new environment";
    private final String TITLE_INPUT_ID = "title";
    private final String SLUG_INPUT_ID = "Slug";
    private final String CREATE_BTN_CSS = "[type=submit]";

    @Step("Opening environment page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening environment page");
        open(String.format("/environment/%s", projectAbbreviation));
    }

    @Step("Creating environment '{title}', with slug '{slug}'")
    public void createEnvironment(String title, String slug) {
        log.info("Creating environment '{}', with slug '{}'", title, slug);
        $(byText(NEW_ENVRMNT_BTN_TEXT)).click();
        $(By.id(TITLE_INPUT_ID)).sendKeys(title);
        $(By.id(SLUG_INPUT_ID)).sendKeys(slug);
        $(CREATE_BTN_CSS).click();
    }

    @Step("Checking if environment '{title}' is created")
    public void checkIfEnvironmentIsCreated(String title) {
        log.info("Checking if environment '{}' is created", title);
        $(byText(title)).shouldBe(Condition.visible);
    }
}
