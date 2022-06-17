package Pages.Hotels;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;

public class TravelersPage extends Commands {
    By travelersLocator = By.xpath("//div[@id='adaptive-menu']");
    By addAdultLocator = By.xpath("//input[@id='adult-input-0']/following-sibling::button");
    By addChildLocator = By.xpath("//input[@aria-label='Children Ages 0 to 17']/following-sibling::button");
    By childAgeErrorLocator = By.xpath("//div[@class='uitk-error-summary']/h3");
    By firstChildAgeButtonLocator = By.xpath("//select[@id='child-age-input-0-0']");
    By secondChildAgeButtonLocator = By.xpath("//select[@id='child-age-input-0-1']");
    By DoneButtonLocator = By.xpath("//button[@data-testid='guests-done-button']");
    By travelerCountPreSearchLocator = By.xpath("//button[@data-testid='travelers-field-trigger']");
    By travelerCountPostSearchLocator = By.xpath("//button[@data-stid='open-room-picker']/preceding-sibling::input");

    public void openHotelsWebsite () {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }

    String travelerCountPreSearch = "";
    String travelerCountPostSearch = "";
    int totalAdults;
    int totalChildren;

    public void clickTravelersButton() {
        clickIt(travelersLocator);
    }

    public void addChildren(int children) {
        for (int i = 0; i < children; i++) {
            clickIt(addChildLocator);
            totalChildren = children;
        }
    }

    public void addAdults(int adults) {
        for (int i = 0; i < adults-1; i++) {
            clickIt(addAdultLocator);
            totalAdults = adults;
        }
    }

    public boolean isTravelerAgeErrorDisplayed() {
        return isElementDisplayed(childAgeErrorLocator);
    }

    public void selectFirstChildAge(String age) {
        selectInDropdown(firstChildAgeButtonLocator, age);
    }

    public void selectSecondChildAge(String Age) {
        if (Age.equalsIgnoreCase("under 1")) {
            Age = "0";
        }
        selectInDropdown(secondChildAgeButtonLocator, Age);
    }

    public void clickDoneButton() {
        clickIt(DoneButtonLocator);
    }

    public void countPreSearch() {
        travelerCountPreSearch = getAttributeValueFromWebElement(travelerCountPreSearchLocator, "aria-label");
    }

    public void countPostSearch() {
        travelerCountPostSearch = getAttributeValueFromWebElement(travelerCountPostSearchLocator, "value");
    }

    public boolean doesTravelersCountMatch() {
        return travelerCountPreSearch == travelerCountPostSearch;
    }

    public boolean verifyCorrectTravelerCount() {
        String totalTravelerCount = getTextOfWebElement(travelerCountPreSearchLocator).split(" ")[2];
        return Integer.parseInt(totalTravelerCount) == totalAdults + totalChildren;
    }
}







