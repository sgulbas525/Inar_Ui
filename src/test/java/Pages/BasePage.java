package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver = Driver.getDriver();
    protected Actions actions = new Actions(driver);
    protected Select select ;



    public BasePage() {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    public void checkAllCheckboxes(List<WebElement> checkBoxes) {
        for (WebElement checkbox : checkBoxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }else {
                System.out.println(checkbox.findElement(By.xpath("./following-sibling::label")).getText() + " is selected. Can not checked");
            }
        }
    }

    public void uncheckAllCheckboxes(List<WebElement> checkBoxes) {
        for (WebElement checkbox : checkBoxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            } else {
                System.out.println(checkbox.findElement(By.xpath("./following-sibling::label")).getText() + " is not selected. Can not unchecked");
            }
        }
    }

    public void checkSpecificCheckbox(List<WebElement> checkBoxes, int i) {
        if (!checkBoxes.get(i).isSelected()) {
            checkBoxes.get(i).click();
        }else {
            System.out.println(checkBoxes.get(i).findElement(By.xpath("./following-sibling::label")).getText() + " is selected. Can not checked");
        }
    }
    public void uncheckSpecificCheckbox(List<WebElement> checkBoxes, int i) {
        if (checkBoxes.get(i).isSelected()) {
            checkBoxes.get(i).click();
        }else {
            System.out.println(checkBoxes.get(i).findElement(By.xpath("./following-sibling::label")).getText() + " is not selected. Can not unchecked");
        }
    }

    public  void clickButton(WebElement element){
        Browser.waitForCLickability(element,10);
        element.click();
    }

    public void typeIntoBox(WebElement box, String string){
        Browser.waitForVisibility(box, 10);
        box.sendKeys(string);
    }

    public void hoverOverElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    public void scrollToElement(WebElement element){
        actions.scrollToElement(element).perform();
    }

    public void dragAndDrop(WebElement srcelement, WebElement trgtElement){
        actions.clickAndHold(srcelement).moveToElement(trgtElement).release().perform();
    }

    public void rightClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public void dropDownSelectByText(WebElement dropdown, String text){
        select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public void dropDownSelectByIndex(WebElement dropdown, int index) {
        select = new Select(dropdown);
        int optionCount = select.getOptions().size();
        if (optionCount <= index || index <= 0) {
            Assert.fail("Invalid index for dropdown: " + dropdown);
        } else {
            select.selectByIndex(index);
        }
    }
    public void dropDownSelectByValue(WebElement dropdown, String text){
        select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

}
