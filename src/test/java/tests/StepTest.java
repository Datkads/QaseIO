package tests;

import org.testng.annotations.Test;

public class StepTest extends BaseTest {

    @Test(description = "Create shared step")
    public void createStep() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        stepPage.openPage("DP");
        stepPage.createNewStep("Step 1", "Grab");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}