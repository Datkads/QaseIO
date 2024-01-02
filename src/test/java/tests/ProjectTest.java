package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Check a new repository creation")
    public void repositoryCreation() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.waitTillOpened();
        String projectName = faker.name().fullName();
        String projectDescription = faker.lorem().paragraph();
        projectsPage.createNewProject(projectName, projectDescription);
        repositoryPage.isNewProjectCreated();
    }
}
