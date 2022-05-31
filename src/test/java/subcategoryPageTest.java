import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class subcategoryPageTest {

    @Test

    public void manufacturersCheckboxTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("li[class='category-1']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoryLink = driver.findElement(By.xpath("//li[@class='category-2']/a"));
        subcategoryLink.click();
        WebElement sortingCheckboxManufacturers = driver.findElement(By.xpath("//input[@type='checkbox'][@name='manufacturers[]']"));
        sortingCheckboxManufacturers.click();
        WebElement yellowDuckPicture = driver.findElement(By.xpath("//img[@alt='Yellow Duck']"));
        Assert.assertTrue(yellowDuckPicture.isDisplayed());
        driver.quit();
    }

    @Test

    public void genderCheckboxTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("li[class='category-1']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoryLink = driver.findElement(By.xpath("//li[@class='category-2']/a"));
        subcategoryLink.click();
        WebElement sortingCheckboxGender = driver.findElement(By.cssSelector("input[value='1-1']"));
        sortingCheckboxGender.click();
        WebElement greenDuckPicture = driver.findElement(By.cssSelector("img[alt='Green DucK']"));
        Assert.assertTrue(greenDuckPicture.isDisplayed());
        driver.quit();
    }

}
