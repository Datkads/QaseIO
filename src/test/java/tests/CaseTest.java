package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {

    @Test(description = "Create test case")
    public void newCaseCreation() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        repositoryPage.pressNewCaseButton();
        newCasePage.createNewCase("Test 1");
    }

    @Test(description = "Create a quick test case")
    public void newQuickCase() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        repositoryPage.createNewSuite("Suite 1");
        repositoryPage.createNewQuickCase("Test 1");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
