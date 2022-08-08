package pageobject.objectmethod;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class HomePage  {

    private By messageAfterUnsuccessfulLogin = By.cssSelector(".notice.errors");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean unsuccessfulMassageIsVisible() {

        return driver.findElement(messageAfterUnsuccessfulLogin).isDisplayed();
    }

}
