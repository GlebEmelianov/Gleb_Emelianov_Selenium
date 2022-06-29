package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class discountButton {

    private static By discountButton = By.cssSelector("li[class='page-5']>a");

    public static void clickDiscountButton(WebDriver driver) {

        driver.findElement(discountButton).click();

    }

    public static String getActualTitleOfDiscountPage(WebDriver driver) {

        return driver.getTitle();
    }
}
