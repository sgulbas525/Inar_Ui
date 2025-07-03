package StepDef;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;
import utils.Pages;

public class BaseStep {
    protected Pages pages;
    protected Config config = new Config("dev");
    protected WebDriverWait wait ;

    public BaseStep(){
        System.out.println("BaseStep constructor called");
        try{
            pages = new Pages();
            System.out.println("Pages object initialized");
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }

}
