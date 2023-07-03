package ui.pageobject;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class IdPageLogin extends Form {
    private static By idPageLocator = By.cssSelector("div.VKIDPanel");
    private ITextBox passwordFiled = getElementFactory().getTextBox(By.xpath("//input[@name='password']"), "Input Password field");
    private IButton continueBtn = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Continue Button");

    public IdPageLogin() {
        super(idPageLocator, "VK id Page");
    }

    public void inputPassword(String password) {
        passwordFiled.clearAndType(password);
    }

    public void clickContinueBtn() {
        continueBtn.clickAndWait();
    }
}