package pageobject.objectmethod;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static helpers.Locators.getLocator;


public class homePage  {

    private By messageAfterUnsuccessfulLogin = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean unsuccessfulMassageIsVisible() {

        return driver.findElement(messageAfterUnsuccessfulLogin).isDisplayed();
    }

}
