package Pages.Hotels;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;

public class SignIn_Page extends Commands {

    By emailSignInLocator = By.xpath("//*[@id='loginFormEmailInput']");
    By passwordLogInLocator = By.xpath("//*[@id='loginFormPasswordInput']");
    By loginCheckboxLocator = By.xpath("//input[@type='checkbox']");
    By loginBtnLocator = By.xpath("//*[@id='loginFormSubmitButton']");
    By signInErrorMessageLocator = By.xpath("//*[@id='loginFormErrorBanner']");


    public void enterSignInEmail() {
        type(emailSignInLocator, "daniilg1996@gmail.com");
    }

    public void enterSignInPassword() {
        type(passwordLogInLocator, "thisisnotapassword");
    }

    public void clickSignInCheckbox() {
        clickIt(loginCheckboxLocator);
    }

    public void clickSignInButton() {
        clickIt(loginBtnLocator);
    }

    public boolean verifySignInError() {
        return isElementDisplayed(signInErrorMessageLocator);
    }

    public void closeWindows() {
        MyDriver.quitWindows();
    }

}
