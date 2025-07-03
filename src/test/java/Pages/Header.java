package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter

public class Header extends BasePage{

    @FindBy(xpath = "//button[@routerlink= '/dashboard/']")
    private WebElement homeButton;

    @FindBy(xpath = "//button[@routerlink= '/dashboard/cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//button[@routerlink= '/dashboard/myorders']")
    private WebElement ordersButton;

    @FindBy(xpath = "//button[text()= ' Sign Out ']")
    private WebElement signOutButton;
}
