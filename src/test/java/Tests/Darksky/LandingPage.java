package Tests.Darksky;

import Web.MyDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPage {
    @Test
    public void verifyTimeMachineClickable() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        Pages.Darksky.LandingPage lpage = new Pages.Darksky.LandingPage();
        Assert.assertTrue(lpage.isTimeMachineButtonEnabled(), "Error");


    }
}
