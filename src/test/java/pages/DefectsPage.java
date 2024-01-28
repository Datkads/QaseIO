package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DefectsPage {
    private final String NEW_DEFECT_BTN_TEXT = "Create new defect";
    private final String DEFECT_TITLE_INPUT_ID = "title";
    private final String ACTUAL_RESULT_INPUT_XPATH = "//p[@data-placeholder]";
    private final String SEVERITY_INPUT_XPATH = "//div[@id='severityGroup']/div";
    private final String CREATE_BTN_CSS = "[type=submit]";

    public void openPage(String projectAbbreviation) {
        open(String.format("/defect/%s", projectAbbreviation));
    }

    public void createNewDefect(String defectTitle, String actualResult, String severity) {
        $(byText(NEW_DEFECT_BTN_TEXT)).click();
        $(By.id(DEFECT_TITLE_INPUT_ID)).sendKeys(defectTitle);
        $(By.xpath(ACTUAL_RESULT_INPUT_XPATH)).sendKeys(actualResult);
        $$(By.xpath(SEVERITY_INPUT_XPATH)).get(0).click();
        $(byText(severity)).click();
        $(CREATE_BTN_CSS).click();
        $(byText(defectTitle)).shouldBe(Condition.visible);
    }
}
