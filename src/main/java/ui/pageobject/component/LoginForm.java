package ui.pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginForm extends Form {
    private static By loginFormLocator = By.className("VkIdForm");
    private ITextBox loginField = getElementFactory().getTextBox(By.xpath("//input[@name='login']"), "Input Login Field");
    private IButton submitButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"),"Submit Button");

    public LoginForm() {
        super(loginFormLocator, "Login Form");
    }
    public void inputLogin(String login){
        loginField.clearAndType(login);
    }
    public void clickSubmitBtn() {
        submitButton.clickAndWait();
    }
}