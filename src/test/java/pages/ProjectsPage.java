package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectsPage {
    private final String CREATE_BTN_ID = "createButton";
    private final String PROJECT_NAME_INPUT_ID = "project-name";
    private final String DESCRIPTION_AREA_INPUT_ID = "description-area";
    private final String CREATE_NEW_PROJECT_BTN_TEXT = "Create project";

    @Step("Opening projects page")
    public void openPage() {
        log.info("Opening projects page");
        open("/projects");
    }

    @Step("Waiting till the page is opened")
    public void waitTillOpened() {
        log.info("Waiting till the page is opened");
        $(By.id(CREATE_BTN_ID)).shouldBe(Condition.visible);
    }

    @Step("Creating project '{projectName}', with description")
    public void createNewProject(String projectName, String projectDescription) {
        log.info("Creating project {}, with description", projectName);
        $(By.id(CREATE_BTN_ID)).click();
        $(By.id(PROJECT_NAME_INPUT_ID)).sendKeys(projectName);
        $(By.id(DESCRIPTION_AREA_INPUT_ID)).sendKeys(projectDescription);
        $(byText(CREATE_NEW_PROJECT_BTN_TEXT)).click();
    }

    @Step("Creating project '{projectName}', without description")
    public void createNewProject(String projectName) {
        log.info("Creating project '{}', without description", projectName);
        $(By.id(CREATE_BTN_ID)).click();
        $(By.id(PROJECT_NAME_INPUT_ID)).sendKeys(projectName);
        $(byText(CREATE_NEW_PROJECT_BTN_TEXT)).click();
    }

    @Step("Opening project '{projectName}'")
    public void openProject(String projectName) {
        log.info("Opening project '{}'", projectName);
        $(By.xpath(String.format("//*[contains(text(), '%s')]", projectName))).click();
    }
}
