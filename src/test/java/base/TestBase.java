package base;

import helpers.ScreenshotListener;
import helpers.WebDriverContainer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ScreenshotListener.class)
public class TestBase {

    protected static WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = WebDriverContainer.getDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
    }
}


