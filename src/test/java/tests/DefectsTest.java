package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DefectsTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create defect")
    public void createDefect() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        defectsPage.openPage(projectAbbreviation);
        defectsPage.createNewDefect("Broken button", "Button should work", "Blocker");
        defectsPage.checkIfDefectIsCreated("Broken button");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
