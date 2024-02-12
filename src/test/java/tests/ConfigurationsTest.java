package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ConfigurationsTest extends BaseTest {

    @Test(description = "Create configuration")
    public void createConfiguration() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        configurationsPage.openPage("DP");
        configurationsPage.createNewConfigurationGroup("Mobile OS", "iOS");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}