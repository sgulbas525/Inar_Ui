package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static Config config = new Config("dev");
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public Driver() {

    }

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sgulb\\Downloads\\chromedriver-win64\\chromedriver.exe");

            String browser = config.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(options));
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}