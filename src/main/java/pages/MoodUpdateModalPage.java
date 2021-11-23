package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdateModalPage {

    public static final String MY_DIARY_BUTTON_CSS = ".btn-default.ButtonMyDiary";

    public FeedPage clickGoToMyDiaryButton() {
        $(MY_DIARY_BUTTON_CSS).click();
        return new FeedPage();
    }
}
