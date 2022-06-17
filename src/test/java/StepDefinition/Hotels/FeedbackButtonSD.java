package StepDefinition.Hotels;

import Pages.Hotels.LandingPage;
import Pages.Hotels.SearchBarPage;
import Web.MyDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FeedbackButtonSD {
    LandingPage lpage = new LandingPage();
    SearchBarPage spage = new SearchBarPage();


    @Given("I am on Hotels Website")
    public void openHotels() {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }

    @When("I click on the search bar")
    public void clickOnSearchBar() {
        spage.clickSearchBar();
    }

    @And("I type in 'bora' as the destination")
    public void enterDestination(String selectDestination) {
        spage.enterDestinationInSearchBar(selectDestination);
    }

    @And("I click on 'Bora Bora' from the suggestions")
    public void clickSuggestion(String suggestion){
        spage.clickOnDestinationSuggestion(suggestion);
    }

    @And("I click on the Check In option")
    public void checkIn() {
        spage.clickCheckIn();
    }

    @And("I select the date as August 1, 2022")
    public void checkInDate(String MonthYear, String Date) {
        spage.selectCheckInDate(MonthYear, Date);
    }

    @And("I select the checkout date as August 10, 2022")
    public void checkOutDate(String MonthYear, String Date) {
        spage.selectCheckOutDate(MonthYear, Date);
    }


    @And("I click on the calendar done button")
    public void clickDoneButton(){
        spage.clickDoneOnCalendarButton();
    }

    @And("I click on search button")
    public void clickSearch() {
        spage.clickSearchButton();
    }
    @Then("I verify 'Tell us how we can improve our site' is displayed")
    public void verifyImproveOurSiteMessageIsDisplayed() {
        Assert.assertTrue("Error occured, message is not being displayed", spage.isImproveOurSiteTextDisplayed());
    }

    @Then("I verify the share feedback button is displayed")
    public void shareFeedbackButton() {
        Assert.assertTrue("Error, share feeedback button is not displayed", spage.isShareFeedbackButtonDisplayed());
    }

    @And("I quit the browser")
    public void quitChrome() {
        MyDriver.quitWindows();


    }
}
