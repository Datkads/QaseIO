package tests;

import org.testng.annotations.Test;

public class EnvironmentsTest extends BaseTest {

    @Test(description = "Set the environment")
    public void setEnvironment() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        environmentsPage.openPage("DP");
        environmentsPage.createEnvironment("STG1", "Stage");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
