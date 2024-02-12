package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class StepTest extends BaseTest {

    @Test(description = "Create shared step")
    public void createStep() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        stepPage.openPage("DP");
        stepPage.createNewStep("Step 1", "Grab");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}