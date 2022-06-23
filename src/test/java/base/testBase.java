package base;

import helpers.Browsers;
import helpers.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

@Listeners(ScreenshotListener.class)
public class testBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome: driver = new ChromeDriver(); break;
            case firefox: driver = new FirefoxDriver(); break;
            case opera: driver = new OperaDriver(); break;
            case safari: driver = new SafariDriver(); break;
            case ie: driver = new InternetExplorerDriver(); break;
        }

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
