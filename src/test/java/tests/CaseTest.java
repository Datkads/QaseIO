package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create test case")
    public void newCaseCreation() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        repositoryPage.pressNewCaseButton();
        newCasePage.createNewCase("Test 1");
    }

    @Test(description = "Create a quick test case")
    public void newQuickCase() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        repositoryPage.createNewSuite("Suite 1");
        repositoryPage.createNewQuickCase("Test 1");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
