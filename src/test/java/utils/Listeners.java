package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;


import java.io.File;

public class Listeners implements ITestListener {
    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;

    public int getPassed() { return passed; }
    public int getFailed() { return failed; }
    public int getSkipped() { return skipped; }

    ExtentReports extentReports = ExtentReport.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        passed++;
        test.log(Status.PASS, "TEST_PASSED");
    }

    @Override
    public void onTestFailure (ITestResult result){
        failed++;
        extentTest.get().fail(result.getThrowable());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File dstFile = new File(System.getProperty("user.dir") + "/reports/screenshot/" + result.getName() + ".png");

        try{
            FileUtils.copyFile(srcFile, dstFile);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        test.addScreenCaptureFromPath(dstFile.getPath());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        skipped++;
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context){
        extentReports.flush();
    }
}
