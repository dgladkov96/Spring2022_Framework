package StepDefinition.Hotels;

import Pages.Hotels.LandingPage;
import Pages.Hotels.TravelersPage;
import Web.MyDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class TravelersSD {
    LandingPage lpage = new LandingPage();
    TravelersPage tpage = new TravelersPage();

    @Given("I am on Hotels landing page")
    public void openHotels() {
        MyDriver.openHotelsWebsite();
    }

    @When("I click on travelers count menu")
    public void clickTravelersMenu() {
        tpage.clickTravelersButton();
    }

    @And("I select 6 adults")
    public void selectAdults() {
        tpage.addAdults(6);
    }

    @And("I select 2 children")
    public void selectChildren() {
        tpage.addChildren(2);
    }

    @And("I set the first child's age to 4")
    public void firstChild() {
        tpage.selectFirstChildAge("4");
    }

    @And("I set the second child's age to under 1")
    public void secondChild() {
        tpage.selectSecondChildAge("under 1");
    }

    @And("I click done")
    public void clickDone() {
        tpage.clickDoneButton();
    }

    @Then("I verify total number of guests is the sum of adults and children")
    public void verifyCount() {
        Assert.assertTrue(tpage.verifyCorrectTravelerCount(), "Error, inputted amount of traveler's does not match");
    }

    @And("I quit my browser")
    public void quitBrowser() {
        MyDriver.quitWindows();
    }




}
