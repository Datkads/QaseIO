package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class RepositoryPage {
    private final String NEW_SUITE_BTN_ID = "create-suite-button";
    private final String NEW_CASE_BTN_ID = "create-case-button";
    private final String SUITE_TITLE_INPUT_ID = "title";
    private final String CREATE_SUITE_BTN_TEXT = "Create";
    private final String REPOSITORY_NAME_XPATH = "//div[@id='application-content']//h1[text()=' repository']";
    private final String QUICK_CASE_BTN_XPATH = "//input[@placeholder='+ Create quick test']";
    private final String QUICK_CASE_INPUT_XPATH = "//input[@placeholder='Test case title']";

    @Step("Opening '{projectAbbreviation}' project page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening '{}' project page", projectAbbreviation);
        open(String.format("/project/%s", projectAbbreviation));
    }

    @Step("Checking if the project created")
    public void isNewProjectCreated() {
        log.info("Checking if the project created");
        $(By.xpath(REPOSITORY_NAME_XPATH)).shouldBe(Condition.visible);
    }

    @Step("Creating new '{suiteTitle}' suite")
    public void createNewSuite(String suiteTitle) {
        log.info("Creating new '{}' suite", suiteTitle);
        $(By.id(NEW_SUITE_BTN_ID)).click();
        $(By.id(SUITE_TITLE_INPUT_ID)).sendKeys(suiteTitle);
        $(byText(CREATE_SUITE_BTN_TEXT)).click();
        $(String.format("[title='%s']", suiteTitle)).shouldBe(Condition.visible);
    }

    @Step("Pressing 'New Case' button")
    public void pressNewCaseButton() {
        log.info("Pressing 'New Case' button");
        $(By.id(NEW_CASE_BTN_ID)).click();
    }

    @Step("Creating a quick case '{caseTitle}'")
    public void createNewQuickCase(String caseTitle) {
        log.info("Creating a quick case '{}'", caseTitle);
        $(By.xpath(QUICK_CASE_BTN_XPATH)).click();
        $(By.xpath(QUICK_CASE_INPUT_XPATH)).sendKeys(caseTitle);
        $(By.xpath(QUICK_CASE_INPUT_XPATH)).pressEnter();
        $(byText(caseTitle)).shouldBe(Condition.visible);
    }
}
