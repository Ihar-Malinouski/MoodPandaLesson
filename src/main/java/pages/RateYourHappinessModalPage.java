package pages;

import constants.IConstants;
import io.qameta.allure.Step;
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

    @Step("Click the UPDATE button on a page RateYourHappinessModalPage")
    public static MoodUpdateModalPage updateMoodButtonClick() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new MoodUpdateModalPage();
    }

    @Step("Change of date on a page RateYourHappinessModalPage")
    public RateYourHappinessModalPage chooseDate() {
        $(DATE_MOOD_CSS).click();
        return this;
    }

    @Step("Change hours on a page RateYourHappinessModalPage on the value '{time}'")
    public RateYourHappinessModalPage chooseHoursTime(String time) {
        $(HOURS_TIME_MOOD_CSS).selectOptionContainingText(time);
        return this;
    }

    @Step("Change minutes on a page RateYourHappinessModalPage on the value '{minutes}'")
    public RateYourHappinessModalPage chooseMinutesTime(String minutes) {
        $(MINUTES_TIME_MOOD_CSS).selectOptionContainingText(minutes);
        return this;
    }

    @Step("Opening the calendar")
    public RateYourHappinessModalPage openCalendarButton() {
        $(OPEN_CALENDAR_BUTTON_CSS).click();
        return this;
    }

    @Step("Change mount on a page RateYourHappinessModalPage on the value '{month}'")
    public RateYourHappinessModalPage chooseMonth(String month) {
        $(OPEN_MONTH_BUTTON_CSS).selectOptionContainingText(month);
        return this;
    }


    public RateYourHappinessModalPage openYearCalendar() {
        $(OPEN_YEAR_BUTTON_CSS).click();
        return this;
    }

    public RateYourHappinessModalPage chooseYear(String year) {
        $(OPEN_YEAR_BUTTON_CSS).selectOptionContainingText(year);
        return this;
    }
}
