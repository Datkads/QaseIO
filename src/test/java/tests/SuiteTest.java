package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    @Test(description = "Check a new suite creation ")
    public void newSuiteCreation() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.openProject("Demo Project");
        repositoryPage.createNewSuite("Suite 1");
    }
}
