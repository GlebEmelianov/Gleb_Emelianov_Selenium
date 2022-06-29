package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class termsConditionsButton {

    private static By termsConditionsButton = By.cssSelector("li.page-4");

    public static void clickTermsConditionsButton(WebDriver driver) {

        driver.findElement(termsConditionsButton).click();

    }

    public static String getActualTitleOfTermsConditionsPage(WebDriver driver) {

        return driver.getTitle();
    }
}
