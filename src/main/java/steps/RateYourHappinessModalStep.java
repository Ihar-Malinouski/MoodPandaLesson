package steps;

import pages.MoodUpdateModalPage;
import pages.RateYourHappinessModalPage;

public class RateYourHappinessModalStep {

    private static RateYourHappinessModalPage rateYourHappinessModalPage;
    private static MoodUpdateModalPage moodUpdateModalPage;

    public RateYourHappinessModalStep(MoodUpdateModalPage moodUpdateModalPage) {
        this.moodUpdateModalPage = moodUpdateModalPage;
    }

    public RateYourHappinessModalStep() {
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
    }

    public static MoodUpdateModalPage updateMoodAndGoToMyDiary() {
        RateYourHappinessModalPage.updateMoodButtonClick()
                .clickGoToMyDiaryButton();
        return new MoodUpdateModalPage();
    }
}
