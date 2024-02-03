package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PlanTest extends BaseTest {

    @Test(description = "Create plan")
    public void createPlan() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        newCasePage.openPage("DP");
        newCasePage.createNewCase("Test 1");
        planPage.openPage("DP");
        planPage.createNewPlan("Smoke");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
