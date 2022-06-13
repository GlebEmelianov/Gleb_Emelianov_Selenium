import helpers.ScreenshotListeners;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class shopSiteTest {

    @Test

    public void mainPageButtonTestTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePageLink = driver.findElement(By.cssSelector("li[class='general-0']>a"));
        homePageLink.click();
        String actualTitleOfHomePage = driver.getTitle();
        Assert.assertEquals(actualTitleOfHomePage, "Online Store | My Store1");
        driver.quit();
    }

    @Test

    public void categoryButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement categoryLink = driver.findElement(By.xpath("//nav[@id='site-menu']/ul/li[@class='category-3']"));
        Actions builder = new Actions(driver);
        builder.click(categoryLink).perform();
        String actualTitleOfCategoryPage = driver.getTitle();
        Assert.assertEquals(actualTitleOfCategoryPage, "My Store1");
        driver.quit();
    }

    @Test

    public void rubberDucksButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("li[class='category-1']"));
        rubberDucksLink.click();
        String actualTitleOfRubberDucksPage = driver.getTitle();
        Assert.assertEquals(actualTitleOfRubberDucksPage, "Rubber Ducks | My Store1");
        driver.quit();
    }

    @Test

    public void deliveryInfomationButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement deliveryInformationLink = driver.findElement(By.xpath("//nav[@id='site-menu']/ul/li[@class='page-2']"));
        Actions builder = new Actions(driver);
        builder.click(deliveryInformationLink).perform();
        String actualTitleOfDeliveryInformationPage = driver.getTitle();
        Assert.assertEquals(actualTitleOfDeliveryInformationPage, "Delivery Information | My Store1");
        driver.quit();
    }

    @Test

    public void termsConditionsButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement termsConditionsLink = driver.findElement(By.cssSelector("li.page-4"));
        Actions builder = new Actions(driver);
        builder.moveToElement(termsConditionsLink).perform();
        builder.click(termsConditionsLink).perform();
        String actualTitleOfTermsConditionsPage = driver.getTitle();
        Assert.assertEquals(actualTitleOfTermsConditionsPage, "Terms & Conditions | My Store1");
        driver.quit();
    }

}
