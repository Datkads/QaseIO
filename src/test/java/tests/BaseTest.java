package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    Faker faker;
    String user;
    String password;
    RunPage runPage;
    StepPage stepPage;
    PlanPage planPage;
    LoginPage loginPage;
    DefectsPage defectsPage;
    NewCasePage newCasePage;
    ProjectsPage projectsPage;
    SettingsPage settingsPage;
    RepositoryPage repositoryPage;
    MilestonesPage milestonesPage;
    RunDashboardPage runDashboardPage;
    EnvironmentsPage environmentsPage;
    ConfigurationsPage configurationsPage;

    @BeforeMethod(description = "Browser settings setup")
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 20000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        runPage = new RunPage();
        stepPage = new StepPage();
        planPage = new PlanPage();
        loginPage = new LoginPage();
        defectsPage = new DefectsPage();
        newCasePage = new NewCasePage();
        projectsPage = new ProjectsPage();
        settingsPage = new SettingsPage();
        repositoryPage = new RepositoryPage();
        milestonesPage = new MilestonesPage();
        runDashboardPage = new RunDashboardPage();
        environmentsPage = new EnvironmentsPage();
        configurationsPage = new ConfigurationsPage();

        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));
    }

    @AfterMethod(alwaysRun = true, description = "Browser shutdown")
    public void tearDown() {
        closeWebDriver();
    }
}
