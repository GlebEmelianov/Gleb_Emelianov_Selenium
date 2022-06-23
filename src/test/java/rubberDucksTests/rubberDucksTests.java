package rubberDucksTests;

import base.testBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.objectmethod.homePage;
import pageobject.objectmethod.loginPage;
import pageobject.pagefactorymethod.checkoutButton;
import pageobject.staticmethod.*;

public class rubberDucksTests extends testBase {
    @Test
    @Description("Impossible to log in with invalid credentials")
    public void loginTest() {

        loginPage LoginPage = new loginPage(driver);
        LoginPage.loginWithIncorrectCredentialsTest("gleb@gmail.com", "Test1234!");

        homePage HomePage = new homePage(driver);
        Assert.assertTrue(HomePage.unsuccessfulMassageIsVisible(), "Login with incorrect credentials is successful");
    }

    @Test
    @Description("Test of Home page button in header menu")
    public void headerMenuHomePageButtonTest() {

        homePageButton.clickHomePageButton(driver);
        Assert.assertEquals(homePageButton.getActualTitleOfHomePage(driver), "Online Store | My Store1",
                "The title of the page is not Online Store | My Store1. You are not at Home page");
    }

    @Test
    @Description("Test of button without name in header menu")
    public void headerMenuNamelessButtonTest() {

        namelessButton.clickNamelessButton(driver);
        Assert.assertEquals(namelessButton.getActualTitleOfCategoryPage(driver), "My Store1",
                "The title of the page is not My Store1. You are not at Rubber Ducks empty subcategory page");
    }

    @Test
    @Description("Test of Rubber ducks button in header menu")
    public void headerMenuRubberDucksButtonTest() {

        rubberDucksButton.clickRubberDucksButton(driver);
        Assert.assertEquals(rubberDucksButton.getActualTitleOfRubberDucksPage(driver), "Rubber Ducks | My Store1",
                "The title of the page is not Rubber Ducks | My Store1. You are not at Rubber Ducks page");
    }

    @Test
    @Description("Test of Delivery button in header menu")
    public void headerMenuDeliveryInformationButtonTest() {

        deliveryInformationButton.clickDeliveryInformationButton(driver);
        Assert.assertEquals(deliveryInformationButton.getActualTitleOfDeliveryInformationPage(driver),
                "Delivery Information | My Store1",
                "The title of the page is not Delivery Information | My Store1. You are not at Delivery Information page");
    }

    @Test
    @Description("Test of Terms and conditions button in header menu")
    public void headerMenuTermsConditionsButtonTest() {

        termsConditionsButton.clickTermsConditionsButton(driver);
        Assert.assertEquals(termsConditionsButton.getActualTitleOfTermsConditionsPage(driver),
                "Terms & Conditions | My Store1",
                "The title of the page is not Terms & Conditions | My Store1. You are not at Terms & Conditions page");
    }

    @Test
    @Description("Test of Discount button in header menu")
    public void headerMenuDiscountButtonTest() {

        discountButton.clickDiscountButton(driver);
        Assert.assertEquals(discountButton.getActualTitleOfDiscountPage(driver), "4 | My Store1",
                "The title of the page is not 4 | My Store1. You are not at Discount page");
    }

    @Test
    @Description("Checkout button test")
    public void checkoutButtonTest() {

        checkoutButton checkoutButtonLink = PageFactory.initElements(driver, checkoutButton.class);
        checkoutButtonLink.clickCheckoutButton();

        String actualTitleOfCheckoutPage = driver.getTitle();

        Assert.assertEquals(actualTitleOfCheckoutPage, "Checkout | My Store1",
                "The title of the page is not Checkout | My Store1. You are not at Checkout page");
    }

    @Test
    @Description("Test that green duck has label New")
    public void greenDuckLabelTest() {
        WebElement greenDuckPicture = driver.findElement(By.xpath("//img[@alt='Green DucK']"));
        WebElement labelNew = driver.findElement(By.xpath("//img[@alt='Green DucK']/following-sibling::div"));
        Assert.assertTrue(greenDuckPicture.getAttribute("alt").equals("Green DucK") &&
                labelNew.getAttribute("title").equals("New"), "Green duck doesn`t have label New");
    }

    @Test
    @Description("Test that red duck has label")
    public void redDuckLabelTest() {
        WebElement redDuckPicture = driver.findElement(By.xpath("//img[@alt='Red Duck']"));
        WebElement labelNew = driver.findElement(By.xpath("//img[@alt='Red Duck']/following-sibling::div"));
        Assert.assertTrue(redDuckPicture.getAttribute("alt").equals("Red Duck") &&
                labelNew.getAttribute("title").equals("New"), "Red duck doesn`t have label New");
    }

    @Test
    @Description("Test that Yellow duck has label On sale")
    public void labelSaleTest() {
        WebElement yellowDuckPicture = driver.findElement(By.xpath("//img[@alt='Yellow Duck']"));
        WebElement labelSale = driver.findElement(By.xpath("//img[@alt='Yellow Duck']/following-sibling::div"));
        Assert.assertTrue(yellowDuckPicture.getAttribute("alt").equals("Yellow Duck") &&
                labelSale.getAttribute("title").equals("On Sale"), "Yellow duck doesn`t have label On sale");
    }

    @Test
    @Description("Test of Manufacturers checkbox at https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/ page")
    public void manufacturersCheckboxTest() {
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("li[class='category-1']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoryLink = driver.findElement(By.xpath("//li[@class='category-2']/a"));
        subcategoryLink.click();
        WebElement sortingCheckboxManufacturers = driver.findElement(By.xpath("//input[@type='checkbox'][@name='manufacturers[]']"));
        sortingCheckboxManufacturers.click();
        WebElement yellowDuckPicture = driver.findElement(By.xpath("//img[@alt='Yellow Duck']"));
        Assert.assertTrue(yellowDuckPicture.isDisplayed(), "Ducks aren`t sorted according to manufacturer");
    }

    @Test
    @Description("Test of Gender checkbox at https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/ page")
    public void genderCheckboxTest() {
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("li[class='category-1']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksLink).perform();
        WebElement subcategoryLink = driver.findElement(By.xpath("//li[@class='category-2']/a"));
        subcategoryLink.click();
        WebElement sortingCheckboxGender = driver.findElement(By.cssSelector("input[value='1-1']"));
        sortingCheckboxGender.click();
        WebElement greenDuckPicture = driver.findElement(By.cssSelector("img[alt='Green DucK']"));
        Assert.assertTrue(greenDuckPicture.isDisplayed(), "Ducks aren`t sorted according to gender");
    }

}
