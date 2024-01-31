package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnvironmentsPage {
    private final String NEW_ENVRMNT_BTN_TEXT = "Create new environment";
    private final String TITLE_INPUT_ID = "title";
    private final String SLUG_INPUT_ID = "Slug";
    private final String CREATE_BTN_CSS = "[type=submit]";

    public void openPage(String projectAbbreviation) {
        open(String.format("/environment/%s", projectAbbreviation));
    }

    public void createEnvironment(String title, String slug) {
        $(byText(NEW_ENVRMNT_BTN_TEXT)).click();
        $(By.id(TITLE_INPUT_ID)).sendKeys(title);
        $(By.id(SLUG_INPUT_ID)).sendKeys(slug);
        $(CREATE_BTN_CSS).click();
        $(byText(title)).shouldBe(Condition.visible);
    }
}
