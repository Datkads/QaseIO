package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class RunPage {
    private final String NEW_TEST_RUN_BTN_TEXT = "Start new test run";
    private final String RADIO_BTN_CSS = "[type=radio]";
    private final String TEST_PLAN_INPUT_XPATH = "//input[@placeholder='Choose tests from test plan']";
    private final String SELECT_CASES_BTN_TEXT = "Select cases";
    private final String SUITE_CHECKBOX_XPATH = "//*[contains(text(), '%s')]/preceding-sibling::span";
    private final String PLAN_TITLE_TEXT = "%s";
    private final String DONE_BTN_TEXT = "Done";
    private final String START_RUN_BTN_TEXT = "Start a run";

    @Step("Opening run page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening run page");
        open(String.format("/run/%s", projectAbbreviation));
    }

    @Step("Creating new run with plan '{planTitle}'")
    public void createNewRun(String planTitle) {
        log.info("Creating new run with plan '{}'", planTitle);
        $(byText(NEW_TEST_RUN_BTN_TEXT)).click();
        $$(RADIO_BTN_CSS).get(1).click();
        $(By.xpath(TEST_PLAN_INPUT_XPATH)).click();
        $(byText(String.format(PLAN_TITLE_TEXT, planTitle))).click();
        $(byText(START_RUN_BTN_TEXT)).click();
    }

    @Step("Creating new run with test cases")
    public void createNewRunWithCases(String suiteTitle) {
        log.info("Creating new run with test cases");
        $(byText(NEW_TEST_RUN_BTN_TEXT)).click();
        $(byText(SELECT_CASES_BTN_TEXT)).click();
        $(By.xpath(String.format(SUITE_CHECKBOX_XPATH, suiteTitle))).click();
        $(byText(DONE_BTN_TEXT)).click();
        $(byText(START_RUN_BTN_TEXT)).click();
    }
}
