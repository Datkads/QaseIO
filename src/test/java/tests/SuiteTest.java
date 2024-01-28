package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test(description = "Create test suite")
    public void newSuiteCreation() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        repositoryPage.createNewSuite("Suite 1");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}