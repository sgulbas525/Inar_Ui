package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Getter

public class HomePage extends BasePage {
    @FindBy(xpath = "//h3[contains(text(),'Automation')]")
    private WebElement pageIdentifier;

    @FindBy(xpath = "//section[@id='sidebar']//input[@name='search']")
    private WebElement filterSearchBox;

    @FindBy(xpath = "//section[@id='sidebar']//input[@name='search']")
    private WebElement minPriceRangeBox;

    @FindBy(xpath = "//section[@id='sidebar']//input[@name='minPrice']")
    private WebElement maxPriceRangeBox;

    @FindBy(xpath = "//section[@id='sidebar']//input[@type='checkbox']")
    private List<WebElement> filterCheckboxes;

    @FindBy(xpath = "//div[@class= 'card']")
    private List<WebElement> productsCards;

    @FindBy(xpath = "//div[@class= 'card'][1]//b")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//div[@class= 'card'][1]//button[text() = ' Add To Cart']")
    private List<WebElement> productsAddToCartButton;

    public void selectProductByName(String productName) {
        for (int i = 0; i <productsNames.size() ; i++) {
            if (productsNames.get(i).getText().equalsIgnoreCase(productName)){
                clickButton(productsAddToCartButton.get(i));
                break;
            }
        }
    }


}
