package pageobject.objectmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.getLocator;


public class loginPage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void loginWithIncorrectCredentialsTest(String email, String password) {

        driver.findElement(emailInput).sendKeys("gleb@gmail.com");
        driver.findElement(passwordInput).sendKeys("Test1234!");
        driver.findElement(loginButton).click();

    }

}
