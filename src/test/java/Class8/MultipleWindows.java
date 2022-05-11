package Class8;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class MultipleWindows {
    /**
     * To get the handle driver is connected with
     * method: getWindowHandle()
     * return type : String
     */
    /*
        Steps:
        1. Launch facebook.com
        2. Click on Facebook Pay
         (connect driver with FacebookPay - webpage)
        3. Verify the page title starts with "Facebook Pay"
     */
    @Test
    public void multipleWindows() {
        // #1
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");


        String fbWindowHandle = MyDriver.getDriver().getWindowHandle();
        System.out.println("fbWindowHandle -> " + fbWindowHandle);

        // #2
        MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();

        /**
         * To get the ALL window handles for browser windows opened due to automation code
         * method: getWindowHandles()
         * return type : Set<String>
         */

        Set<String> allHandles = MyDriver.getDriver().getWindowHandles();

        System.out.println("allHandles -> " + allHandles);

        /**
         * To connect driver with a browser using windowHandle
         * method: switchTo()
         */
        /*

            loop
                get a handle from allHandles-Set (fbHandle, fbPayHandle) ; handle = fbPayHandle
                if (handle != fbHandle)
                    switch to handle
                    break/stop the loop
         */
        for (String handle : allHandles) {
            if (!handle.equals(fbWindowHandle)) {
                MyDriver.getDriver().switchTo().window(handle);
                break;
            }
        }

        // #3
        String title = MyDriver.getDriver().getTitle();

        System.out.println("title -> " + title);
    }

    /*
        Steps:
        1. Launch facebook.com
        2. Click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
        3. Verify the Bulletin page title is Meta Bulletin
     */
    @Test
    public void verifyMetaBulletinTitle() {
        MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

        MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();
        MyDriver.getDriver().findElement(By.linkText("Oculus")).click();
        MyDriver.getDriver().findElement(By.linkText("Instagram")).click();
        MyDriver.getDriver().findElement(By.linkText("Portal")).click();
        MyDriver.getDriver().findElement(By.linkText("Bulletin")).click();

        Misc.pause(2);

        Assert.assertEquals(MyDriver.getDriver().getTitle(), "Meta Bulletin", "Meta Bulletin title is not same as expected");

    }
}
