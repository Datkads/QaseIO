package tests;

import org.testng.annotations.Test;

public class RunTest extends BaseTest {

    @Test(description = "Add new test run")
    public void createRun() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        newCasePage.openPage("DP");
        newCasePage.createNewCase("Test 1");
        planPage.openPage("DP");
        planPage.createNewPlan("Smoke");
        runPage.openPage("DP");
        runPage.createNewRun("Smoke");
        runDashboardPage.isTestRunCreated();
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }

    @Test(description = "Complete test run")
    public void completeRun() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        newCasePage.openPage("DP");
        newCasePage.createNewCase("Test 1");
        runPage.openPage("DP");
        runPage.createNewRunWithCases("Test cases without suite");
        runDashboardPage.testRunSimulation("Test 1", "Passed");
    }
}