package Pages.Hotels;

import Pages.Commands;
import org.openqa.selenium.By;



public class SearchBarPage extends Commands {

    LandingPage lpage = new LandingPage();

    By searchButtonLocator = By.xpath("//button[text()='Search']");
    By searchBarLocator = By.xpath("//div[@class='uitk-error-summary']");
    By destinationSuggestionsLocator = By.xpath("//div[@class='uitk-typeahead-results']//div[contains(@class,'truncat') and not(contains(@class,'uitk'))]");
    By searchBarEnterLocator = By.id("location-field-destination");
    By checkInBoxLocator = By.id("d1-btn");
    By checkOutBoxLocator = By.id("d2-btn");
    By calendarDoneButtonLocator = By.xpath("//button[@data-stid='apply-date-picker']");
    By improveOurSiteTextLocator = By.xpath("//*[@data-stid='voice-of-the-customer']/span");
    By shareFeedbackButtonLocator = By.xpath("//*[@data-stid='voice-of-the-customer']/a");

    public void clickSearchButton() {
        clickIt(searchButtonLocator);
    }

    public void clickSearchBar () {
        clickIt(searchBarLocator);
    }

    public void enterDestinationInSearchBar(String Destination) {
        type(searchBarEnterLocator, Destination);

    }

    public void clickOnDestinationSuggestion(String destinationSuggestion) {
        selectFromSuggestions(destinationSuggestionsLocator, destinationSuggestion);

    }

    public void selectCheckInDate(String checkInMonthYear, String checkInDay) {
        lpage.selectDateFromAnyMonth(checkInMonthYear, checkInDay);
    }

    public void selectCheckOutDate(String checkOutMonthYear, String checkOutDay) {
        lpage.selectDateFromAnyMonth(checkOutMonthYear, checkOutDay);
    }

    public void clickCheckIn() {
        clickIt(checkInBoxLocator);
    }

    public void clickCheckOut() {
        clickIt(checkOutBoxLocator);

    }

    public void clickDoneOnCalendarButton() {
        clickIt(calendarDoneButtonLocator);
    }

    public boolean isImproveOurSiteTextDisplayed() {
        return isElementDisplayed(improveOurSiteTextLocator);
    }

    public boolean isShareFeedbackButtonDisplayed() {
        return isElementDisplayed(shareFeedbackButtonLocator);
    }









}
