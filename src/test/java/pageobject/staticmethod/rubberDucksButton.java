package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class rubberDucksButton {

    private static By rubberDucksButton = By.cssSelector("li[class='category-1']");

    public static void clickRubberDucksButton(WebDriver driver) {

        driver.findElement(rubberDucksButton).click();

    }

    public static String getActualTitleOfRubberDucksPage(WebDriver driver) {

        return driver.getTitle();
    }
}
