package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class SettingsPage {
    private final String DELETE_PROJECT_BTN_XPATH = "//h1//following::div/button";
    private final String CONFIRM_BTN_XPATH = "//*[contains(text(), 'Cancel')]/parent::button/following::button";

    @Step("Opening settings page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening settings page");
        open(String.format("/project/%s/settings/general", projectAbbreviation));
    }

    @Step("Deleting project '{projectName}'")
    public void removeProject(String projectName) {
        log.info("Deleting project '{}'", projectName);
        $$(By.xpath(DELETE_PROJECT_BTN_XPATH)).get(1).click();
        $(By.xpath(CONFIRM_BTN_XPATH)).click();
        $(byText(projectName)).shouldNotBe(Condition.visible);
    }
}