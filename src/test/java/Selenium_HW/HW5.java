package Selenium_HW;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Iterator;


public class HW5 {
    @Test
    public void CurrentDate(){
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net");

        Misc.pause(2);

        JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("scrollBy(0,700");

        Misc.pause(2);
        MyDriver.getDriver().findElement(By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']")).click();

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM:dd:yyyy");
        String TodaysDate = sdf.format(today);

        By CurrentDateLocator = By.xpath("//div[@class='date']");
        String CurrentDate = String.valueOf(MyDriver.getDriver().findElement(CurrentDateLocator));
        Assert.assertEquals(CurrentDate, TodaysDate, "Incorrect Date is displayed");
        MyDriver.quitWindows();

    }

    @Test
    public void WindowHandleTest(){
        MyDriver.launchUrlOnNewWindow("https://facebook.com");
        MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();
        MyDriver.getDriver().findElement(By.linkText("Oculus")).click();
        MyDriver.getDriver().findElement(By.linkText("Instagram")).click();
        MyDriver.getDriver().findElement(By.linkText("Portal")).click();
        MyDriver.getDriver().findElement(By.linkText("Bulletin")).click();

        Misc.pause(2);

        String homeWindow = MyDriver.getDriver().getWindowHandle();
        Set<String> allWindows = MyDriver.getDriver().getWindowHandles();

        for (String window: allWindows) {
            MyDriver.getDriver().switchTo().window(window);
            String title = MyDriver.getDriver().getTitle();
            if (!title.equalsIgnoreCase("Instagram")) {

                System.out.println("Closing window" + MyDriver.getDriver().getTitle());
                MyDriver.getDriver().close();
            }
        }

        MyDriver.getDriver().switchTo().window(homeWindow);
        Set<String> CurrentHandles = MyDriver.getDriver().getWindowHandles();
        Assert.assertEquals(CurrentHandles, 1, "Error occured, multiple window handles still open");
        MyDriver.getDriver().quit();

        By InstaLoginLocate = By.xpath("//body/div[@id='react-root']/section[1]/main[1]/article[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]");
        WebElement InstaLogin = MyDriver.getDriver().findElement(InstaLoginLocate);

        Assert.assertFalse(InstaLogin.isEnabled(), "Error Instalogin is enabled");
        MyDriver.quitWindows();








    }

}
