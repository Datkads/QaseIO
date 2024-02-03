package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test(description = "Create test suite")
    public void newSuiteCreation() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        repositoryPage.createNewSuite("Suite 1");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}