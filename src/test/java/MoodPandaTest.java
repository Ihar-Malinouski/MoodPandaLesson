import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedPage;
import steps.FeedStep;
import steps.LoginStep;
import steps.RateYourHappinessModalStep;

public class MoodPandaTest extends BaseTest {

    @Test(description = "Проверка валидности выбранного значения настроения")
    public void moodTest() {
        LoginStep.authotization();
        FeedStep.waitAndClickMoodButton()
                .updateMood(6);
        RateYourHappinessModalStep.updateMoodAndGoToMyDiary();
        Assert.assertEquals(FeedPage.getFirstMoodNumber(), "6");
    }

    @Test(description = "Проверка сохранения с верной измененной датой при заполнении настроения")
    public void checkDateMoodTest() {
        LoginStep.authotization();
        FeedStep.waitAndClickMoodButton()
                .updateMood(4)
                .chooseDate()
                .chooseHoursTime("7 pm")
                .chooseMinutesTime(":30");
        RateYourHappinessModalStep.updateMoodAndGoToMyDiary();
        Assert.assertEquals(FeedPage.getDateMood(), "2 days ago");
    }

    @Test(description = "Проверка ввода Reply под оценкой настроения")
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
