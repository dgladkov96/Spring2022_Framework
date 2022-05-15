package StepDefinition.Facebook;

import Pages.Facebook.LandingPage;
import Pages.Facebook.LoginErrorPage;
import Web.MyDriver;
import cucumber.api.java.en.Given;

import Web.MyDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSD {
    LandingPage lpage = new LandingPage();
    LoginErrorPage lePage = new LoginErrorPage();


    // glue code
    @Given("I am on facebook landing page")

    public void openFacebook() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com");
    }


    //Glue Code
    @When("I click on login button")
    public void clickLoginBtn() {

        lpage.clickLoginButton();

    }

    //Glue Code
    @When("I enter (.*) in login username")
    public void enterLoginUsername(String username){

        lpage.enterLoginEmail(username);

    }
    @Given("I enter (.*) in login password")

    public void enterLoginPwd(String password){
        lpage.enterLoginPassword(password);
    }

    @Then("^I verify error is displayed$")
    public void isLoginErrorDisplayed() {
        Assert.assertTrue("Login error message is not displayed for invalid credentials flow", lePage.isLoginErrorDisplayed());
    }

}


