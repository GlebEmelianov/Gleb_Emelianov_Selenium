package helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static Properties locators;

    static {

        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println("Error reading from property file");
        }

    }

    public static By getLocator(String element) throws Exception {

        String locator = locators.getProperty(element);

        String[] substrings = locator.split("=", 2);

        LocatorTypes locatorType = LocatorTypes.valueOf(substrings[0]);

        switch (locatorType) {

            case id:
                return By.id(substrings[1]);
            case css:
                return By.cssSelector(substrings[1]);
            case name:
                return By.name(substrings[1]);
            case xpath:
                return By.xpath(substrings[1]);
            case tagName:
                return By.tagName(substrings[1]);
            case linkText:
                return By.linkText(substrings[1]);
            case partialLinkText:
                return By.partialLinkText(substrings[1]);
            case className:
                return By.className(substrings[1]);

            default: throw new Exception("No such locator type");
        }
    }
}
