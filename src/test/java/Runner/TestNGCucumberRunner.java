package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(

            features = "src/test/java/Features",
            glue = "StepDef",  // utils contains Hooks class
            plugin = {"pretty", "html:target/cucumber-report.html"},
            dryRun = false
    )
    public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    }

