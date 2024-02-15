package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ConfigurationsTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create configuration")
    public void createConfiguration() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        configurationsPage.openPage(projectAbbreviation);
        configurationsPage.createNewConfigurationGroup("Mobile OS", "iOS");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}