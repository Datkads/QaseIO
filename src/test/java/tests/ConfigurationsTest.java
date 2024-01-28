package tests;

import org.testng.annotations.Test;

public class ConfigurationsTest extends BaseTest {

    @Test(description = "Create configuration")
    public void createConfiguration() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        configurationsPage.openPage("DP");
        configurationsPage.createNewConfigurationGroup("Mobile OS", "iOS");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}