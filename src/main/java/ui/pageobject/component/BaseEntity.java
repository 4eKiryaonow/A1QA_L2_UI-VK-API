package ui.pageobject.component;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.utils.ConditionalWait;

public abstract class BaseEntity extends Form {
    protected static String entityLocator = "//div[@id='post%s_%s']";
    protected String authorEntityLocator = String.format("%s//a[@class='author']", entityLocator);
    protected String entityTextLocator = "//div[@class='wall_text']/div[@id='wpt%s_%s']/div";
    protected By authorLocator;
    protected String hrefAttribute = "href";

    public BaseEntity(String userId, String postId) {
        super(By.xpath(String.format(entityLocator, userId, postId)), String.format("Base entity id:%s_%s", userId, postId));
        this.authorLocator = By.xpath(String.format(authorEntityLocator, userId, postId));
    }

    private ITextBox author() {
        ConditionalWait.waitUntilPresented(this.authorLocator);
        return getElementFactory().getTextBox(this.authorLocator, "Author");
    }

    public String getAuthorLink() {
        return this.author().getAttribute(hrefAttribute);
    }
}