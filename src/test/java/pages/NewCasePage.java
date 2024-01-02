package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewCasePage {
    private final String CASE_TITLE_ID = "title";
    private final String SAVE_CASE_BTN_ID = "save-case";

    public void openPage(String projectAbbreviation) {
        open(String.format("/case/%s/create", projectAbbreviation));
    }

    public void createNewCase(String caseTitle) {
        $(By.id(CASE_TITLE_ID)).sendKeys(caseTitle);
        $(By.id(SAVE_CASE_BTN_ID)).click();
    }
}
