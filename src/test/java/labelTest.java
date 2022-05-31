import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class labelTest {
    @Test

    public void greenDuckLabelTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement greenDuckPicture = driver.findElement(By.xpath("//img[@alt='Green DucK']"));
        WebElement labelNew = driver.findElement(By.xpath("//img[@alt='Green DucK']/following-sibling::div"));
        Assert.assertTrue(greenDuckPicture.getAttribute("alt").equals("Green DucK") && labelNew.getAttribute("title").equals("New"));
        driver.quit();
    }

    @Test

    public void redDuckLabelTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement redDuckPicture = driver.findElement(By.xpath("//img[@alt='Red Duck']"));
        WebElement labelNew = driver.findElement(By.xpath("//img[@alt='Red Duck']/following-sibling::div"));
        Assert.assertTrue(redDuckPicture.getAttribute("alt").equals("Red Duck") && labelNew.getAttribute("title").equals("New"));
        driver.quit();
    }

    @Test

    public void labelSaleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement yellowDuckPicture = driver.findElement(By.xpath("//img[@alt='Yellow Duck']"));
        WebElement labelSale = driver.findElement(By.xpath("//img[@alt='Yellow Duck']/following-sibling::div"));
        Assert.assertTrue(yellowDuckPicture.getAttribute("alt").equals("Yellow Duck") && labelSale.getAttribute("title").equals("On Sale"));
        driver.quit();
    }

}
