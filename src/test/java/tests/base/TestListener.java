package tests.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.printf("Test started: %s \n",result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test success: %s \n",result.getName());
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        System.out.printf("Test failure: %s \n",result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.printf("Test skipped: %s \n",result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.printf("Test start: %s \n",context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.printf("Test finish: %s \n",context.getName());
    }
}
