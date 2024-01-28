package tests;

import org.testng.annotations.Test;

public class DefectsTest extends BaseTest {

    @Test(description = "Create defect")
    public void createDefect() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        defectsPage.openPage("DP");
        defectsPage.createNewDefect("Broken button", "Button should work", "Blocker");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
