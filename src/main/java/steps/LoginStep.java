package steps;

import pages.FeedPage;
import pages.LoginPage;

public class LoginStep {

    private static LoginPage loginPage;
    private static FeedPage feedPage;

    public LoginStep(FeedPage feedPage) {
        this.feedPage = feedPage;
    }

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public static FeedPage authotization() {
        loginPage.openPage()
                .login("Ihar2@mailinator.com", "Ghjcnbghjqnb126")
                .clickLoginButton();
        return new FeedPage();
    }
}
