package otherTests;

import helpers.WebDriverContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class LinkTest extends WebDriverContainer {

    public WebDriver driver;

    @Test
    public void linkTest() {
        driver = WebDriverContainer.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.get(10).click();
        WebDriverContainer.closeDriver();
    }
}
