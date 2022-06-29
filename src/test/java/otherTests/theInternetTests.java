package otherTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class theInternetTests {
    @Test
    public void frameTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        Assert.assertEquals(rightFrame.getText(), "RIGHT");
        driver.quit();
    }

    @Test
    public void tabTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        String initialHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("[href='/windows/new']")).click();
        String newTabHandle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newTabHandle);
        String text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text,"New Window");
        driver.quit();
    }

    @Test
    public void shadowDomTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/shadowdom");
        WebElement rootElement = driver.findElement(By.tagName("my-paragraph"));
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", rootElement);
        WebElement slot = shadowRoot.findElement(By.cssSelector("slot[name='my-text']"));
        String slotText = slot.getText();
    }

    @Test
    public void webStorageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mdn.github.io/dom-examples/web-storage/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.font = 'Monospace'");
        //reboot page in browser manually
    }

    @Test
    public void alertTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement jsAlertsLink = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
        jsAlertsLink.click();
        WebElement jsAlertButtonLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertButtonLink.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.quit();
    }
}
