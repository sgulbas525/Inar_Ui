package StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.ExtentReport;

public class Hooks {

    private static ExtentReports extent = ExtentReport.getReportObject();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();

        if (scenarioName == null || scenarioName.trim().isEmpty()) {
            scenarioName = "Unnamed Scenario";
        }

        ExtentTest test = extent.createTest(scenarioName);
        extentTest.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.get().log(Status.FAIL, "Scenario Failed");
            // You can add screenshot here if you want
        } else {
            extentTest.get().log(Status.PASS, "Scenario Passed");
        }
        extent.flush();
    }
}
