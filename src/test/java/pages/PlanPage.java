package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PlanPage {
    private final String CREATE_BTN_ID = "createButton";
    private final String TITLE_INPUT_ID = "title";
    private final String ADD_CASES_BTN_ID = "edit-plan-add-cases-button";
    private final String CHECKBOX_CSS = "[type=checkbox]";
    private final String DONE_BTN_TEXT = "Done";
    private final String SAVE_BTN_ID = "save-plan";

    @Step("Opening plan page")
    public void openPage(String projectAbbreviation) {
        open(String.format("/plan/%s", projectAbbreviation));
    }

    @Step("Creating new plan \"{testPlanName}\"")
    public void createNewPlan(String testPlanName) {
        $(By.id(CREATE_BTN_ID)).click();
        $(By.id(TITLE_INPUT_ID)).sendKeys(testPlanName);
        $(By.id(ADD_CASES_BTN_ID)).click();
        $(CHECKBOX_CSS).click();
        $(byText(DONE_BTN_TEXT)).click();
        $(By.id(SAVE_BTN_ID)).click();
        $(byText(testPlanName)).shouldBe(Condition.visible);
    }
}
