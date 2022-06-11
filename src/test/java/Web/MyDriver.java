package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyDriver {
    private static WebDriver driver;

    public static void launchUrlOnNewWindow(String url) {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
//    @Before
//    public static void launchUrlOnNewWindow2() {
//        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.hotels.com");
//    }

    public static void quitWindows() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
