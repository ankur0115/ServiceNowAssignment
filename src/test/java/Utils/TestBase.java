package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public TestBase()
    {
    }

    public static void initialization()
    {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver86\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
