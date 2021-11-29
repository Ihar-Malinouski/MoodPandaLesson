package pages;

import constants.IConstants;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage implements IConstants {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_BUTTON_CSS = ".btn-primary.ButtonUpdate";
    public static final String DATE_MOOD_CSS = ".Reset2day.btn-default";
    public static final String HOURS_TIME_MOOD_CSS = "#ddlHistoricHour";
    public static final String MINUTES_TIME_MOOD_CSS = "#ddlHistoricMinute";
    public static final String OPEN_CALENDAR_BUTTON_CSS = ".ui-datepicker-trigger";
    public static final String OPEN_MONTH_BUTTON_CSS = ".ui-datepicker-month";
    public static final String OPEN_YEAR_BUTTON_CSS = ".ui-datepicker-year";


    public RateYourHappinessModalPage updateMood(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue != defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return this;
    }

    public static MoodUpdateModalPage updateMoodBuutonClick() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new MoodUpdateModalPage();
    }

    public RateYourHappinessModalPage choiceDateInMoodModalPage() {
        $(DATE_MOOD_CSS).click();
        return this;
    }

    public RateYourHappinessModalPage choiceHoursTime(String time) {
        $(HOURS_TIME_MOOD_CSS).selectOptionContainingText(time);
        return this;
    }

    public RateYourHappinessModalPage choiceMinutesTime(String minutes) {
        $(MINUTES_TIME_MOOD_CSS).selectOptionContainingText(minutes);
        return this;
    }

    public RateYourHappinessModalPage openCalendarButton() {
        $(OPEN_CALENDAR_BUTTON_CSS).click();
        return this;
    }

    public RateYourHappinessModalPage choiceMount(String mount) {
        $(OPEN_MONTH_BUTTON_CSS).selectOptionContainingText(mount);
        return this;
    }

    public RateYourHappinessModalPage openYearCalendarButton() {
        $(OPEN_YEAR_BUTTON_CSS).click();
        return this;
    }

    public RateYourHappinessModalPage choiceYear(String year) {
        $(OPEN_YEAR_BUTTON_CSS).selectOptionContainingText(year);
        return this;
    }
}
