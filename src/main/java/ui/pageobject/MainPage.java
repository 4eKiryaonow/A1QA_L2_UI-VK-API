package ui.pageobject;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.pageobject.component.*;

public class MainPage extends Form {
    private static By mainPageLocator = By.cssSelector("a.TopHomeLink");
    private LoginForm loginForm = new LoginForm();
    private SideBar sideBar = new SideBar();
    private ProfileHeader profileHeader = new ProfileHeader();

    public MainPage() {
        super(mainPageLocator, "VK main page");
    }

    public LoginForm loginForm() {
        return this.loginForm;
    }

    public SideBar sideBar() {
        return this.sideBar;
    }

    public ProfileHeader profileHeader() {
        return this.profileHeader;
    }

    public PostWall postWall() {
        return new PostWall();
    }

    public FeedWall feedWall() {
        return new FeedWall();
    }
}