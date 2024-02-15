package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RunDashboardPage {
    private final String OPEN_WIZARD_BTN_TEXT = "Open wizard";
    private final String CASE_CHECKBOX_XPATH = "//*[contains(text(), '%s')]//parent::div/preceding-sibling::div";
    private final String STATUS_BTN_TEXT = "%s";
    private final String STATUS_ICON_XPATH = "//*[contains(text(), 'Test 1')]//parent:" +
            ":div//div[contains(text(), '%s')]";

    @Step("Checking if test run is created")
    public void isTestRunCreated() {
        $(byText(OPEN_WIZARD_BTN_TEXT)).shouldBe(Condition.visible);
    }

    @Step("Simulating test run")
    public void testRunSimulation(String caseTitle, String caseStatus) {
        $(byText(OPEN_WIZARD_BTN_TEXT)).click();
        $(By.xpath(String.format(CASE_CHECKBOX_XPATH, caseTitle))).click();
        $(byText(String.format(STATUS_BTN_TEXT, caseStatus))).click();
        $(By.xpath(String.format(STATUS_ICON_XPATH, caseStatus))).shouldBe(Condition.visible);
    }
}
