package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DefectsTest extends BaseTest {

    @Test(description = "Create defect")
    public void createDefect() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        defectsPage.openPage("DP");
        defectsPage.createNewDefect("Broken button", "Button should work", "Blocker");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
