package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Browser {
    private static WebDriverWait wait;
    public static void wait(int second){
        try{
            Thread.sleep(second * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void verifyElementDisplayed(WebElement element){
        try{
            Assert.assertTrue(element.isDisplayed(), "Element not visible: " + element);
        }catch (Exception e){
            Assert.fail("Element not found: " + e);
        }
    }

    public static void  waitForCLickability(WebElement element, int second){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebElement element, int second){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void reTry(){
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
    }
}
