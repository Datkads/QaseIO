package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ConfigurationsPage {
    private final String CREATE_CONFIG_GROUP_BTN_TEXT = "Create configuration group";
    private final String CONFIG_TITLE_INPUT_ID = "confirm";
    private final String CREATE_BTN_CSS = "[type=submit]";
    private final String QUICK_CONFIG_BTN_CSS = "[class=quick-button]";
    private final String QUICK_CONFIG_INPUT_CSS = "[class=quick-input]";

    @Step("Opening configuration page")
    public void openPage(String projectAbbreviation) {
        log.info("Opening configuration page");
        open(String.format("/configuration/%s", projectAbbreviation));
    }

    @Step("Creating configuration '{configGroup}', with config '{config}'")
    public void createNewConfigurationGroup(String configGroup, String config) {
        log.info("Creating configuration '{}', with config '{}'", configGroup, config);
        $(byText(CREATE_CONFIG_GROUP_BTN_TEXT)).click();
        $(By.id(CONFIG_TITLE_INPUT_ID)).sendKeys(configGroup);
        $(CREATE_BTN_CSS).click();
        $$(QUICK_CONFIG_BTN_CSS).get(0).click();
        $(QUICK_CONFIG_INPUT_CSS).sendKeys(config);
        $(QUICK_CONFIG_INPUT_CSS).pressEnter();
    }

    @Step("Checking if configuration {config} is created")
    public void checkIfConfigurationIsCreated(String config) {
        log.info("Checking if configuration {} is created", config);
        $(byText(config)).shouldBe(Condition.visible);
    }
}