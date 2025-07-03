import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Config;
import utils.Driver;

public class Test {
     public static Config config = new Config("dev");

    public static void main(String[] args) {

Driver.getDriver().get(config.getProperty("url"));    }
}
