package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    String projectName = "Diploma Project";
    String projectAbbreviation = "DP";

    @Test(description = "Create new project")
    public void createRepository() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
        String projectDescription = faker.lorem().paragraph();
        projectsPage.createNewProject(projectName, projectDescription);
        repositoryPage.isNewProjectCreated();
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }

    @Test(description = "Delete project")
    public void deleteRepository() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject(projectName);
        settingsPage.openPage(projectAbbreviation);
        settingsPage.removeProject(projectName);
    }
}
