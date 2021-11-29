package pages;

import constants.IConstants;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage implements IConstants {

    private static final String EMAIL_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxEmail";
    private static final String PASSWORD_INPUT_CSS = "#ContentPlaceHolderContent_TextBoxPassword";
    private static final String LOGIN_BUTTON_CSS = "#ContentPlaceHolderContent_ButtonLogin";

    public LoginPage openPage() {
        open(LOGIN_URL);
        return this;
    }

    public LoginPage login(String email, String password) {
        $(EMAIL_INPUT_CSS).sendKeys(email);
        $(PASSWORD_INPUT_CSS).sendKeys(password);
        return this;
    }

    public FeedPage clickLoginButton() {
        $(LOGIN_BUTTON_CSS).click();
        return new FeedPage();
    }
}
