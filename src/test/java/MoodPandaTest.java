import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FeedPage;
import steps.FeedStep;
import steps.LoginStep;
import steps.RateYourHappinessModalStep;

public class MoodPandaTest extends BaseTest {

    @Test(description = "Checking the validity of the selected mood value")
    @Description("Some detailed test description")
    @Parameters({"login", "password", "secondNameProduct"})
    @Link("TMS-1")
    @Issue("TMS-2")
    @TmsLink("TMS-3")
    public void moodTest() {
        LoginStep.authotization();
        FeedStep.waitAndClickMoodButton()
                .updateMood(6);
        RateYourHappinessModalStep.updateMoodAndGoToMyDiary();
        Assert.assertEquals(FeedPage.getFirstMoodNumber(), "6");
    }

    @Test(description = "Checking save with correct modified date when filling in mood")
    @Description("Some detailed test description")
    @Parameters({"login", "password", "secondNameProduct"})
    @Link("TMS-1")
    @Issue("TMS-2")
    @TmsLink("TMS-3")
    public void checkDateMoodTest() {
        LoginStep.authotization();
        FeedStep.waitAndClickMoodButton()
                .updateMood(4)
                .chooseDate()
                .chooseHoursTime("7 pm")
                .chooseMinutesTime(":30");
        RateYourHappinessModalStep.updateMoodAndGoToMyDiary();
        Assert.assertEquals(FeedPage.getDateMood(), "1 day ago");
    }

    @Test(description = "Reply Input Validation Under Mood Assessment")
    @Description("Some detailed test description")
    @Parameters({"login", "password", "secondNameProduct"})
    @Link("TMS-1")
    @Issue("TMS-2")
    @TmsLink("TMS-3")
    public void inputReplyTest() {
        LoginStep.authotization();
        FeedStep.waitAndClickMoodButton()
                .updateMood(4)
                .openCalendarButton()
                .chooseMonth("Apr")
                .openYearCalendar()
                .chooseYear("2015");
        RateYourHappinessModalStep.updateMoodAndGoToMyDiary();
        feedPage.getFirstMoodReplyMessage("Чот настроенице такое себе :)")
                .clickReplyButton();
         Assert.assertEquals(FeedPage.getFirstReplyText(), "Чот настроенице такое себе :)");
    }
}
