package pageobject;

import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.testBase;
import pageobject.objectmethod.homePage;
import pageobject.objectmethod.loginPage;
import pageobject.pagefactorymethod.checkoutButton;
import pageobject.staticmethod.*;

public class PageObjectTest extends testBase {

    @Test
    @Description("Impossible to log in with invalid credentials")
    public void loginTest() {

        loginPage LoginPage = new loginPage(driver);
        LoginPage.loginWithIncorrectCredentialsTest("gleb@gmail.com", "Test1234!");

        homePage HomePage = new homePage(driver);
        Assert.assertTrue(HomePage.unsuccessfulMassageIsVisible(), "Login with incorrect credentials is successful");

    }

    @Test
    @Description("Home page button in header menu test")
    public void headerMenuHomePageButtonTest() {

        homePageButton.clickHomePageButton(driver);
        Assert.assertEquals(homePageButton.getActualTitleOfHomePage(driver), "Online Store | My Store1",
                "The title of the page is not Online Store | My Store1");

    }

    @Test
    @Description("Test of button without name in header menu")
    public void headerMenuNamelessButtonTest() {

        namelessButton.clickNamelessButton(driver);
        Assert.assertEquals(namelessButton.getActualTitleOfCategoryPage(driver), "My Store1",
                "The title of the page is not My Store1");

    }

    @Test
    @Description("Rubber ducks button in header menu test")
    public void headerMenuRubberDucksButtonTest() {

        rubberDucksButton.clickRubberDucksButton(driver);
        Assert.assertEquals(rubberDucksButton.getActualTitleOfRubberDucksPage(driver), "Rubber Ducks | My Store1",
                "The title of the page is not Rubber Ducks | My Store1");

    }

    @Test
    @Description("Delivery button in header menu test")
    public void headerMenuDeliveryInformationButtonTest() {

        deliveryInformationButton.clickDeliveryInformationButton(driver);
        Assert.assertEquals(deliveryInformationButton.getActualTitleOfDeliveryInformationPage(driver),
                "Delivery Information | My Store1", "The title of the page is not Delivery Information | My Store1");

    }

    @Test
    @Description("Terms and conditions button in header menu test")
    public void headerMenuTermsConditionsButtonTest() {

        termsConditionsButton.clickTermsConditionsButton(driver);
        Assert.assertEquals(termsConditionsButton.getActualTitleOfTermsConditionsPage(driver),
                "Terms & Conditions | My Store1", "The title of the page is not Terms & Conditions | My Store1");

    }

    @Test
    @Description("Discount button in header menu test")
    public void headerMenuDiscountButtonTest() {

        discountButton.clickDiscountButton(driver);
        Assert.assertEquals(discountButton.getActualTitleOfDiscountPage(driver), "4 | My Store1",
                "The title of the page is not 4 | My Store1");

    }

    @Test
    @Description("Checkout button test")
    public void checkoutButtonTest() {

        checkoutButton checkoutButtonLink = PageFactory.initElements(driver, checkoutButton.class);
        checkoutButtonLink.clickCheckoutButton();

        String actualTitleOfCheckoutPage = driver.getTitle();

        Assert.assertEquals(actualTitleOfCheckoutPage, "Checkout | My Store1",
                "The title of the page is not Checkout | My Store1");

    }

}
