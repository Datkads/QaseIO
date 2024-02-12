package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test(description = "Set the milestone")
    public void setMilestone() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        milestonesPage.openPage("DP");
        milestonesPage.createNewMilestone("Fix all issues", "ASAP");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteRepository() {
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
