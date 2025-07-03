package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;

public class TC_01_stepDef extends BaseStep {

    @Given("user lands on login page")
    public void userLandsOnLoginPage() {
        Driver.getDriver().get(config.getProperty("url"));
    }

    @Then("user verify login page")
    public void userVerifyLoginPage(){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(pages.getLandingPage().getPageIdentifier()));
       String academyName = pages.getLandingPage().getPageIdentifier().getText();
        Assert.assertTrue(academyName.equalsIgnoreCase("Rahul shetty Academy"), "Page verification message should be Rahul Shetty Academy but found " + academyName);
        System.out.println("PAGE NAME: " + Driver.getDriver().getTitle());
    }

    @When("user enters valid email")
            public void userEntersValidEmail(){
        pages.getLandingPage().getLoginEmailBox().sendKeys(config.getProperty("username"));
    }


    @And("user enters valid password")
    public void userEntersValidPassword(){
        pages.getLandingPage().getLoginPasswordBox().sendKeys(config.getProperty("password"));

    }

    @And ("user clicks login button")
    public void userClicksLoginButton(){
        pages.getLandingPage().getLoginButton().click();

    }

}
