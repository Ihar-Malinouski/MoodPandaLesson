package steps;

import pages.FeedPage;
import pages.RateYourHappinessModalPage;

public class FeedStep {

    private static FeedPage feedPage;
    private static RateYourHappinessModalPage rateYourHappinessModalPage;

    public FeedStep(RateYourHappinessModalPage rateYourHappinessModalPage) {
        this.rateYourHappinessModalPage = rateYourHappinessModalPage;
    }

    public FeedStep() {
        feedPage = new FeedPage();
    }

    public static RateYourHappinessModalPage waitAndClickMoodButton() {
        feedPage.waitForMoodButtonVisible()
                .clickUpdateMoodButton();
        return new RateYourHappinessModalPage();
    }
}
