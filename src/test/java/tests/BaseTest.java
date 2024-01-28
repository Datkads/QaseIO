package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    LoginPage loginPage;
    ProjectsPage projectsPage;
    RepositoryPage repositoryPage;
    NewCasePage newCasePage;
    PlanPage planPage;
    RunPage runPage;
    RunDashboardPage runDashboardPage;
    StepPage stepPage;
    SettingsPage settingsPage;
    ConfigurationsPage configurationsPage;
    EnvironmentsPage environmentsPage;
    DefectsPage defectsPage;
    MilestonesPage milestonesPage;
    Faker faker;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 20000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        repositoryPage = new RepositoryPage();
        newCasePage = new NewCasePage();
        planPage = new PlanPage();
        runPage = new RunPage();
        runDashboardPage = new RunDashboardPage();
        stepPage = new StepPage();
        settingsPage = new SettingsPage();
        configurationsPage = new ConfigurationsPage();
        environmentsPage = new EnvironmentsPage();
        defectsPage = new DefectsPage();
        milestonesPage = new MilestonesPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }
}
