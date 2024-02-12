package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EnvironmentsTest extends BaseTest {

    @Test(description = "Set the environment")
    public void setEnvironment() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        environmentsPage.openPage("DP");
        environmentsPage.createEnvironment("STG1", "Stage");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
