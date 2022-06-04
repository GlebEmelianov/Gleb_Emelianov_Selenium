package pageobject;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.base.testBase;
import pageobject.objectmethod.homePage;
import pageobject.objectmethod.loginPage;
import pageobject.pagefactorymethod.checkoutButton;
import pageobject.staticmethod.*;

public class PageObjectTest extends testBase {

    @Test
    public void loginTest() {

        loginPage LoginPage = new loginPage(driver);
        LoginPage.loginWithIncorrectCredentialsTest("gleb@gmail.com", "Test1234!");

        homePage HomePage = new homePage(driver);
        Assert.assertTrue(HomePage.unsuccessfulMassageIsVisible(), "Login with incorrect credentials is successful");

    }

    @Test
    public void headerMenuHomePageButtonTest() {

        homePageButton.clickHomePageButton(driver);
        Assert.assertEquals(homePageButton.getActualTitleOfHomePage(driver), "Online Store | My Store1",
                "The title of the page is not Online Store | My Store1");

    }

    @Test
    public void headerMenuNamelessButtonTest() {

        namelessButton.clickNamelessButton(driver);
        Assert.assertEquals(namelessButton.getActualTitleOfCategoryPage(driver), "My Store1",
                "The title of the page is not My Store1");

    }

    @Test
    public void headerMenuRubberDucksButtonTest() {

        rubberDucksButton.clickRubberDucksButton(driver);
        Assert.assertEquals(rubberDucksButton.getActualTitleOfRubberDucksPage(driver), "Rubber Ducks | My Store1",
                "The title of the page is not Rubber Ducks | My Store1");

    }

    @Test
    public void headerMenuDeliveryInformationButtonTest() {

        deliveryInformationButton.clickDeliveryInformationButton(driver);
        Assert.assertEquals(deliveryInformationButton.getActualTitleOfDeliveryInformationPage(driver),
                "Delivery Information | My Store1", "The title of the page is not Delivery Information | My Store1");

    }

    @Test
    public void headerMenuTermsConditionsButtonTest() {

        termsConditionsButton.clickTermsConditionsButton(driver);
        Assert.assertEquals(termsConditionsButton.getActualTitleOfTermsConditionsPage(driver),
                "Terms & Conditions | My Store1", "The title of the page is not Terms & Conditions | My Store1");

    }

    @Test
    public void headerMenuDiscountButtonTest() {

        discountButton.clickDiscountButton(driver);
        Assert.assertEquals(discountButton.getActualTitleOfDiscountPage(driver), "4 | My Store1",
                "The title of the page is not 4 | My Store1");

    }

    @Test
    public void checkoutButtonTest() {

        checkoutButton checkoutButtonLink = PageFactory.initElements(driver, checkoutButton.class);
        checkoutButtonLink.clickCheckoutButton();

        String actualTitleOfCheckoutPage = driver.getTitle();

        Assert.assertEquals(actualTitleOfCheckoutPage, "Checkout | My Store1",
                "The title of the page is not Checkout | My Store1");

    }

}
