package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("UI Test Report");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("TESTER", "SG");
        return extentReports;
    }
}
