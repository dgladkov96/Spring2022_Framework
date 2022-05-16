package StepDefinition.Darksky;

import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class HW6 {

    @Test
    @Given("I am on Darksky landing page")
    public void OpenDarkSky() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net");
    }


    @When("I click on TimeMachine")
    public void clickOnTimeMachine(){
        MyDriver.getDriver().findElement(By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']")).click();
    }


    @Then("I verify the dates match")
    public void CheckDates(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM:dd:yyyy");
        String TodaysDate = sdf.format(today);

        By CurrentDateLocator = By.xpath("//div[@class='date']");
        String CurrentDate = String.valueOf(MyDriver.getDriver().findElement(CurrentDateLocator));
        Assert.assertEquals(CurrentDate, TodaysDate, "Incorrect Date is displayed");
        MyDriver.quitWindows();
    }


    @Given("I am on Facebook")
    public void launchFB() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com");
    }


    @When("I open Facebook pay, oculus, instagram, portal, and bulletin")
    public void openWindows(){
        MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();
        MyDriver.getDriver().findElement(By.linkText("Oculus")).click();
        MyDriver.getDriver().findElement(By.linkText("Instagram")).click();
        MyDriver.getDriver().findElement(By.linkText("Portal")).click();
        MyDriver.getDriver().findElement(By.linkText("Bulletin")).click();
    }

    @When("I close all windows except Instagram")
    public void closeWindowsExceptInsta(){
        String currentWindowHandle = MyDriver.getDriver().getWindowHandle();
        Set<String> allHandles = MyDriver.getDriver().getWindowHandles();
        for (String handle : allHandles){
            MyDriver.getDriver().switchTo().window(handle);
            String currentUrl = MyDriver.getDriver().getCurrentUrl();
            if (!currentUrl.contains("https://www.instagram.com")){
                MyDriver.getDriver().close();
            }
        }
    }

    @Then("I verify number of window handles")
    public void verifyHandles(){
        Set<String> CurrentHandles = MyDriver.getDriver().getWindowHandles();
        Assert.assertEquals(CurrentHandles.size(), 1, "Error occured, multiple window handles still open");

    }

    @Then("I verify Page title is Instagram")
    public void getPageTitle(){
        Assert.assertEquals(MyDriver.getDriver().getTitle(), "Instagram", "Instagram title is not the same as expected");

    }
    @Then("Then I verify log in button is disabled")
    public void InstaloginDisabled(){
        By InstaLoginLocate = By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]");
        WebElement InstaLogin = MyDriver.getDriver().findElement(InstaLoginLocate);

        Assert.assertFalse(InstaLogin.isEnabled(), "Error Instalogin is enabled");

    }


    @Given("I am on Hotels website")
    public void openHotels(){
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }


    @When("I click on search button without destination")
    public void clickOnSearch(){
        By SearchBtnLocator = By.xpath("//button[contains(text(),'Search')]");
        MyDriver.getDriver().findElement(SearchBtnLocator).click();
    }

    @Then("I verify if error is displayed")
    public void verifyError(){
        By SearchBtnLocator = By.xpath("//button[contains(text(),'Search')]");
        MyDriver.getDriver().findElement(SearchBtnLocator).click();
        Assert.assertFalse(MyDriver.getDriver().findElement(SearchBtnLocator).isEnabled(), "Error message is not displayed");


    }

    @Test

    public void openHotels2(){
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com");
    }


    public void clickTravelers(){
        //error displayed on hotels website when inspecting travelers dropdown, said error 404 response code failure
    }
}
