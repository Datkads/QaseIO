package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {
    private final String CREATE_BTN_ID = "createButton";
    private final String PROJECT_NAME_INPUT_ID = "project-name";
    private final String DESCRIPTION_AREA_INPUT_ID = "description-area";
    private final String CREATE_NEW_PROJECT_BTN_TEXT = "Create project";
    private final String REPOSITORY_NAME_XPATH = "//div[@id='application-content']//h1[text()=' repository']";

    public void openPage() {
        open("/projects");
    }

    public void waitTillOpened() {
        $(By.id(CREATE_BTN_ID)).shouldBe(Condition.visible);
    }

    public void createNewProject(String projectName, String projectDescription) {
        $(By.id(CREATE_BTN_ID)).click();
        $(By.id(PROJECT_NAME_INPUT_ID)).sendKeys(projectName);
        $(By.id(DESCRIPTION_AREA_INPUT_ID)).sendKeys(projectDescription);
        $(byText(CREATE_NEW_PROJECT_BTN_TEXT)).click();
    }

    public void isNewProjectCreated() {
        $(By.xpath(REPOSITORY_NAME_XPATH)).shouldBe(Condition.visible);
    }
}
