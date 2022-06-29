package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePageButton {

    private static By homePageButton = By.cssSelector("li[class='general-0']>a");

    public static void clickHomePageButton(WebDriver driver) {

        driver.findElement(homePageButton).click();

    }

    public static String getActualTitleOfHomePage(WebDriver driver) {

        return driver.getTitle();
    }


}
