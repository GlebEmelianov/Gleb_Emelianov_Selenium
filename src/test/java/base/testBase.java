package base;

import helpers.Browsers;
import helpers.ScreenshotListener;
import helpers.WebDriverContainer;
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

        driver= WebDriverContainer.getDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
    }
}
