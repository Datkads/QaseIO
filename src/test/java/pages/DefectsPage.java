package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DefectsPage {
    private final String NEW_DEFECT_BTN_TEXT = "Create new defect";
    private final String DEFECT_TITLE_INPUT_ID = "title";
    private final String ACTUAL_RESULT_INPUT_XPATH = "//p[@data-placeholder]";
    private final String SEVERITY_INPUT_XPATH = "//div[@id='severityGroup']/div";
    private final String CREATE_BTN_CSS = "[type=submit]";

    @Step("Opening defects page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening defects page");
        open(String.format("/defect/%s", projectAbbreviation));
    }

    @Step("Creating defect '{defectTitle}' with severity '{severity}', and result '{actualResult}'")
    public void createNewDefect(String defectTitle, String actualResult, String severity) {
        log.info("Creating defect '{}' with severity '{}', and result '{}'", defectTitle, severity, actualResult);
        $(byText(NEW_DEFECT_BTN_TEXT)).click();
        $(By.id(DEFECT_TITLE_INPUT_ID)).sendKeys(defectTitle);
        $(By.xpath(ACTUAL_RESULT_INPUT_XPATH)).sendKeys(actualResult);
        $$(By.xpath(SEVERITY_INPUT_XPATH)).get(0).click();
        $(byText(severity)).click();
        $(CREATE_BTN_CSS).click();
    }

    @Step("Checking if defect '{defectTitle}' is created")
    public void checkIfDefectIsCreated(String defectTitle) {
        log.info("Checking if defect '{}' is created", defectTitle);
        $(byText(defectTitle)).shouldBe(Condition.visible);
    }
}
