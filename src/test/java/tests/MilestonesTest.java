package tests;

import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test(description = "Set the milestone")
    public void setMilestone() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.createNewProject("Diploma Project");
        milestonesPage.openPage("DP");
        milestonesPage.createNewMilestone("Fix all issues", "ASAP");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
