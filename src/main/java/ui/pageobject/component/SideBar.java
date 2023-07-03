package ui.pageobject.component;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import hoard.TestDataManager;
import org.openqa.selenium.By;
import ui.utils.ConditionalWait;

public class SideBar extends Form {
    private static By sideBarLocator = By.xpath("//div[@id='side_bar']");
    private By myPageLocator = By.xpath(String.format("//a[@href='/id%s' and contains(@class, 'LeftMenuItem-module')]", TestDataManager.getUser().getId()));
    private ITextBox MyPageLink = getElementFactory().getTextBox(myPageLocator, "My Page Link");

    public SideBar() {
        super(sideBarLocator, "Side Bar");
    }

    public void clickMyPage() {
        ConditionalWait.waitUntilClickable(MyPageLink.getLocator());
        MyPageLink.clickAndWait();
    }
}