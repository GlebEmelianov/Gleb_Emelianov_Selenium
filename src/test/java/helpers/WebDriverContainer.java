package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

            switch (browser) {
                case chrome: driver = new ChromeDriver(); break;
                case firefox: driver = new FirefoxDriver(); break;
                case opera: driver = new OperaDriver(); break;
                case safari: driver = new SafariDriver(); break;
                case ie: driver = new InternetExplorerDriver(); break;
            }
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
