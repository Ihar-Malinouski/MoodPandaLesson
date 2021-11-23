package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FeedPage {

    public static final String UPDATE_MOOD_BUTTON_CSS = "#LinkUpdate";
    public static final String NUMBER_MOOD_CSS = "span.badge.pull-right";
    public static final String DATE_MOOD_CSS = ".col-xs-8.text-4";
    public static final String REPLY_WINDOW_CSS = ".InputReply";
    public static final String REPLY_BUTTON_CSS = ".ButtonReply.mcr1";
    public static final String REPLY_TEXT_CSS = ".media-body-comment-tag";


    public FeedPage waitForMoodButtonVisible() {
        $(UPDATE_MOOD_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModalPage clickUpdateMoodButton() {
        $(UPDATE_MOOD_BUTTON_CSS).click();
        return new RateYourHappinessModalPage();
    }

    public static String getNumberMood() {
        return $$(NUMBER_MOOD_CSS).get(0).getText();
    }

    public static String getDateMood() {
        return $$(DATE_MOOD_CSS).get(0).getText();
    }

    public FeedPage getReplyMessgeMood(String text) {
        $$(REPLY_WINDOW_CSS).get(0).sendKeys(text);
        return this;
    }

    public FeedPage clickReplyButton() {
        $(REPLY_BUTTON_CSS).click();
        return this;
    }

    public static String getReplyText() {
        return $$(REPLY_TEXT_CSS).get(0).getText();
    }
}
