package ui.pageobject.component;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProfileHeader extends Form {
    private static By profileHeaderLocator = By.className("ProfileHeader");
    public ProfileHeader() {
        super(profileHeaderLocator, "Profile Header");
    }
}
