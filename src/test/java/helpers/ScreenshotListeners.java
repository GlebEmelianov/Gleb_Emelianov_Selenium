package helpers;

import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

public class ScreenshotListeners implements ITestListener {

    WebDriver driver = new ChromeDriver();

    @Override
    public void onTestFailure(ITestResult testResult) {

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(testResult.getTestName() + "screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ReportPortal.emitLog(testResult.getTestName() + "screenshot", "ERROR", Calendar.getInstance().getTime(), screenshot);
    }
}
