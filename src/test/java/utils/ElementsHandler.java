package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsHandler {
    public static void checkAllCheckboxes(List<WebElement> checkBoxes) {
        for (WebElement checkbox : checkBoxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }else {
                System.out.println(checkbox.findElement(By.xpath("./following-sibling::label")).getText() + " is selected. Can not checked");
            }
        }
    }

    public static void uncheckAllCheckboxes(List<WebElement> checkBoxes) {
        for (WebElement checkbox : checkBoxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            } else {
                System.out.println(checkbox.findElement(By.xpath("./following-sibling::label")).getText() + " is not selected. Can not unchecked");
            }
        }
    }

    public static void checkSpecificCheckbox(List<WebElement> checkBoxes, int i) {
        if (!checkBoxes.get(i).isSelected()) {
            checkBoxes.get(i).click();
        }else {
            System.out.println(checkBoxes.get(i).findElement(By.xpath("./following-sibling::label")).getText() + " is selected. Can not checked");
        }
    }
    public static void uncheckSpecificCheckbox(List<WebElement> checkBoxes, int i) {
        if (checkBoxes.get(i).isSelected()) {
            checkBoxes.get(i).click();
        }else {
            System.out.println(checkBoxes.get(i).findElement(By.xpath("./following-sibling::label")).getText() + " is not selected. Can not unchecked");
        }
    }

}
