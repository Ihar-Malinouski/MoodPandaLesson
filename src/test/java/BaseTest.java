import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.FeedStep;
import steps.LoginStep;
import steps.RateYourHappinessModalStep;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    FeedPage feedPage;
    LoginPage loginPage;
    MoodUpdateModalPage moodUpdateModalPage;
    MyDiaryPage myDiaryPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    BasePage basePage;
    LoginStep loginStep;
    FeedStep feedStep;
    RateYourHappinessModalStep rateYourHappinessModalStep;

    @BeforeMethod
    public void init() {
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;

        feedPage = new FeedPage();
        loginPage = new LoginPage();
        moodUpdateModalPage = new MoodUpdateModalPage();
        myDiaryPage = new MyDiaryPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        basePage = new BasePage();
        loginStep = new LoginStep();
        feedStep = new FeedStep();
        rateYourHappinessModalStep = new RateYourHappinessModalStep();
    }

    @AfterMethod
    public void quit() {
        getWebDriver().quit();
    }
}
