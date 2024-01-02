package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RepositoryPage {
    private final String NEW_SUITE_BTN_ID = "create-suite-button";
    private final String NEW_CASE_BTN_ID = "create-case-button";
    private final String SUITE_TITLE_INPUT_ID = "title";
    private final String CREATE_SUITE_BTN_TEXT = "Create";
    private final String REPOSITORY_NAME_XPATH = "//div[@id='application-content']//h1[text()=' repository']";

    public void openPage(String projectAbbreviation) {
        open(String.format("/project/%s", projectAbbreviation));
    }

    public void isNewProjectCreated() {
        $(By.xpath(REPOSITORY_NAME_XPATH)).shouldBe(Condition.visible);
    }

    public void createNewSuite(String suiteTitle) {
        $(By.id(NEW_SUITE_BTN_ID)).click();
        $(By.id(SUITE_TITLE_INPUT_ID)).sendKeys(suiteTitle);
        $(byText(CREATE_SUITE_BTN_TEXT)).click();
        $(String.format("[title='%s']", suiteTitle)).shouldBe(Condition.visible);
    }

    public void pressNewCaseButton() {
        $(By.id(NEW_CASE_BTN_ID)).click();
    }
}
