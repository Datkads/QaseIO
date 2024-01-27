package tests;

import org.testng.annotations.Test;

public class CaseTest extends BaseTest {

    @Test(description = "Check a new case creation")
    public void newCaseCreation() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.openProject("Demo Project");
        repositoryPage.pressNewCaseButton();
        newCasePage.createNewCase("Test Case 1");
    }
}
