package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MilestonesPage {
    private final String NEW_MILESTONES_BTN_TEXT = "Create milestone";
    private final String MILESTONE_NAME_INPUT_ID = "title";
    private final String DESCRIPTION_TEXTAREA_XPATH = "//p[@data-placeholder]";
    private final String CREATE_BTN_CSS = "[type=submit]";

    @Step("Opening milestone page")
    public void openPage(String projectAbbreviation) {
        open(String.format("/milestone/%s", projectAbbreviation));
    }

    @Step("Creating milestone \"{milestoneName}\" with description: \"{description}\" ")
    public void createNewMilestone(String milestoneName, String description) {
        $(byText(NEW_MILESTONES_BTN_TEXT)).click();
        $(By.id(MILESTONE_NAME_INPUT_ID)).sendKeys(milestoneName);
        $(By.xpath(DESCRIPTION_TEXTAREA_XPATH)).sendKeys(description);
        $(CREATE_BTN_CSS).click();
        $(byText(milestoneName)).shouldBe(Condition.visible);
    }
}