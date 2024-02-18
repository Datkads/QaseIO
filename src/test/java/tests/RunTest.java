package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RunTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Add new test run")
    public void createRun() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        newCasePage.openPage(projectAbbreviation);
        newCasePage.createNewCase("Test 1");
        planPage.openPage(projectAbbreviation);
        planPage.createNewPlan("Smoke");
        runPage.openPage(projectAbbreviation);
        runPage.createNewRun("Smoke");
        runDashboardPage.isTestRunCreated();
    }

    @Test(description = "Complete test run")
    public void completeRun() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        newCasePage.openPage(projectAbbreviation);
        newCasePage.createNewCase("Test 1");
        runPage.openPage(projectAbbreviation);
        runPage.createNewRunWithCases("Test cases without suite");
        runDashboardPage.testRunSimulation("Test 1", "Passed");
        runDashboardPage.checkIfTestRunIsCompleted("Passed");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}