package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PlanTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create plan")
    public void createPlan() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        newCasePage.openPage(projectAbbreviation);
        newCasePage.createNewCase("Test 1");
        planPage.openPage(projectAbbreviation);
        planPage.createNewPlan("Smoke");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
