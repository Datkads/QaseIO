package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Set the milestone")
    public void setMilestone() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        milestonesPage.openPage(projectAbbreviation);
        milestonesPage.createNewMilestone("Fix all issues", "ASAP");
        milestonesPage.checkIfMilestoneIsCreated("Fix all issues");
    }

    @AfterMethod(alwaysRun = true, description = "Delete Project")
    public void deleteRepository() {
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
