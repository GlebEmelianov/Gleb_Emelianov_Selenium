package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class namelessButton {

    private static By namelessButton = By.xpath("//nav[@id='site-menu']/ul/li[@class='category-3']");

    public static void clickNamelessButton(WebDriver driver) {

        driver.findElement(namelessButton).click();

    }

    public static String getActualTitleOfCategoryPage(WebDriver driver) {

        return driver.getTitle();
    }
}
