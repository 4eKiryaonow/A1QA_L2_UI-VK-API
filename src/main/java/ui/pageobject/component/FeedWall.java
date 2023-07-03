package ui.pageobject.component;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FeedWall extends Form {
    private static By feedWallLocator = By.id("feed_wall");
    public FeedWall() {
        super(feedWallLocator, "Feed Wall");
    }
}
