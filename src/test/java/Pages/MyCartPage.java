package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter

public class MyCartPage extends BasePage{

    @FindBy(xpath = "//button[text()= 'Checkout']")
    private WebElement checkoutButton;
}
