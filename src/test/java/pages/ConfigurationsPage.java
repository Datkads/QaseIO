package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ConfigurationsPage {
    private final String CREATE_CONFIG_GROUP_BTN_TEXT = "Create configuration group";
    private final String CONFIG_TITLE_INPUT_ID = "confirm";
    private final String CREATE_BTN_CSS = "[type=submit]";
    private final String QUICK_CONFIG_BTN_CSS = "[class=quick-button]";
    private final String QUICK_CONFIG_INPUT_CSS = "[class=quick-input]";

    public void openPage(String projectAbbreviation) {
        open(String.format("/configuration/%s", projectAbbreviation));
    }

    public void createNewConfigurationGroup(String configGroup, String config) {
        $(byText(CREATE_CONFIG_GROUP_BTN_TEXT)).click();
        $(By.id(CONFIG_TITLE_INPUT_ID)).sendKeys(configGroup);
        $(CREATE_BTN_CSS).click();
        $$(QUICK_CONFIG_BTN_CSS).get(0).click();
        $(QUICK_CONFIG_INPUT_CSS).sendKeys(config);
        $(QUICK_CONFIG_INPUT_CSS).pressEnter();
        $(byText(config)).shouldBe(Condition.visible);
    }
}