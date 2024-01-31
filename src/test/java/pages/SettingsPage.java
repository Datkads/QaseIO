package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SettingsPage {
    private final String DELETE_PROJECT_BTN_XPATH = "//h1//following::div/button";
    private final String CONFIRM_BTN_XPATH = "//*[contains(text(), 'Cancel')]/parent::button/following::button";

    public void openPage(String projectAbbreviation) {
        open(String.format("/project/%s/settings/general", projectAbbreviation));
    }

    public void removeProject() {
        $$(By.xpath(DELETE_PROJECT_BTN_XPATH)).get(1).click();
        $(By.xpath(CONFIRM_BTN_XPATH)).click();
        $(byText("Diploma Project")).shouldNotBe(Condition.visible);
    }
}