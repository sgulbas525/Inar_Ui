package Pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LandingPage extends BasePage{
    @FindBy(xpath = "//em[contains(text(),'Rahul Shetty')]")
    private WebElement pageIdentifier;

    @FindBy(id = "userEmail")
    private WebElement loginEmailBox;

    @FindBy(id = "userPassword")
    private WebElement loginPasswordBox;

    @FindBy(id = "login")
    private WebElement loginButton;

    public void enterUsername(String userName){
        typeIntoBox(loginEmailBox, userName);
    }
    public void enterPassword(String password){
        typeIntoBox(loginPasswordBox, password);
    }
}
