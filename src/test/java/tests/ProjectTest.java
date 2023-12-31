package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login("[YOUR LOGIN]", "[YOUR PASSWORD]");
        projectsPage.waitTillOpened();
        String projectName = faker.name().fullName();
        String projectDescription = faker.lorem().paragraph();
        projectsPage.createNewProject(projectName, projectDescription);
        projectsPage.isNewProjectCreated();
    }
}
