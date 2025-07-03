package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaymentPage extends BasePage{
    @FindBy(xpath = "//div[text() =\"Expiry Date \"]// following-sibling::select[1]")
    private WebElement expiryDateMonthDropdown;
    @FindBy(xpath = "//div[text() =\"Expiry Date \"]// following-sibling::select[2]")
    private WebElement expiryDateYearDropdown;


public void selectMonthFromExpiryDateDropdown(int i){
    dropDownSelectByIndex(expiryDateMonthDropdown, 5);
}}