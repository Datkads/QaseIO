package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Create new project")
    public void createRepository() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
        String projectDescription = faker.lorem().paragraph();
        projectsPage.createNewProject("Diploma Project", projectDescription);
        repositoryPage.isNewProjectCreated();
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }

    @Test(description = "Delete project")
    public void deleteRepository() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.createNewProject("Diploma Project");
        settingsPage.openPage("DP");
        settingsPage.removeProject();
    }
}
