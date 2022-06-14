package StepDefinition.Hotels;


import Pages.Hotels.SignIn_Page;
import Web.MyDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sign_In_SD {

    SignIn_Page SignIn = new SignIn_Page();

    @Given("I am on Hotels website")
    public void openHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }

    @When("I click on sign in menu")
    public void clickSignIn() {
        SignIn.clickSignInButton();
    }

    @And("I click on sign in button")
    public void clickSignInAgain() {
        SignIn.clickSignInButton();
    }

    @And("I enter an email in sign in page")
    public void enterEmail() {
        SignIn.enterSignInEmail();
    }

    @And("I enter a password in sign in page")
    public void enterPassword() {
        SignIn.enterSignInPassword();
    }

    @And("I click on the keep me signed in checkbox")
    public void clickKMSI_Checkbox() {
        SignIn.clickSignInCheckbox();

    }

    @And("I click on the following sign in button")
    public void clickSignInButton() {
        SignIn.clickSignInButton();

    }

    @Then("I verify if sign in error message is displayed")
    public void verifySignInErrorMessage() {
        SignIn.verifySignInError();
    }

    @And("I quit the browser")
    public void quitBrowser() {
        SignIn.closeWindows();
    }

}

