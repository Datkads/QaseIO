package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class StepTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create shared step")
    public void createStep() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        stepPage.openPage(projectAbbreviation);
        stepPage.createNewStep("Step 1", "Grab");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}