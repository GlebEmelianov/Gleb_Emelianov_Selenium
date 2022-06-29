package pageobject.staticmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class deliveryInformationButton {

    private static By deliveryInformationButton = By.xpath("//li[@class='page-2']");

    public static void clickDeliveryInformationButton(WebDriver driver) {

        driver.findElement(deliveryInformationButton).click();

    }

    public static String getActualTitleOfDeliveryInformationPage(WebDriver driver) {

        return driver.getTitle();
    }

}
