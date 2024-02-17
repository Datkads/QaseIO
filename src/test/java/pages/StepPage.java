package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class StepPage {
    private final String CREATE_STEP_BTN_TEXT = "Create shared step";
    private final String STEP_TITLE_ID = "title";
    private final String ADD_STEP_BTN_XPATH = "//span[contains(text(), ' Add step')]";
    private final String STEP_ACTION_INPUT_XPATH = "//p[@data-placeholder='Step Action']";
    private final String CREATE_BTN_CSS = "[type=submit]";

    @Step("Opening step page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening step page");
        open(String.format("/step/%s", projectAbbreviation));
    }

    @Step("Creating step '{stepTitle}', with action '{stepAction}'")
    public void createNewStep(String stepTitle, String stepAction) {
        log.info("Creating step '{}', with action '{}'", stepTitle, stepAction);
        $(byText(CREATE_STEP_BTN_TEXT)).click();
        $(By.id(STEP_TITLE_ID)).sendKeys(stepTitle);
        $(By.xpath(ADD_STEP_BTN_XPATH)).click();
        $(By.xpath(STEP_ACTION_INPUT_XPATH)).sendKeys(stepAction);
        $(CREATE_BTN_CSS).click();
        $(byText(stepTitle)).shouldBe(Condition.visible);
    }
}