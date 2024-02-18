package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EnvironmentsTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Set the environment")
    public void setEnvironment() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        environmentsPage.openPage(projectAbbreviation);
        environmentsPage.createEnvironment("STG1", "Stage");
        environmentsPage.checkIfEnvironmentIsCreated("STG1");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
