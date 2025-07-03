package Runner;

import org.testng.annotations.Test;
import utils.Browser;
import utils.Config;
import utils.Driver;
import utils.Pages;

import javax.swing.*;

public class TestScript extends Pages{
    protected Config config = new Config("dev");

    @Test
    public void test() {
        Driver.getDriver().get(config.getProperty("url"));
    landingPage.enterUsername(config.getProperty("username"));
    landingPage.enterPassword(config.getProperty("password"));
    landingPage.clickButton(landingPage.getLoginButton());

    }
}
