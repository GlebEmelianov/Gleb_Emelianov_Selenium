package pageobject.pagefactorymethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Locators.getLocator;

public class checkoutButton {

    @FindBy(xpath = "//*[@id='cart']/a[@class='link']")
    private static WebElement ckeckoutButtonLink;


    public static void clickCheckoutButton() {

    ckeckoutButtonLink.click();

    }

}
