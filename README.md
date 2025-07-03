Bu Framework'u windows bilgisayarda yazdim. Driver otomasyonu icin chrome versiyonun ile ayni versiyonda olacak sekilde chromedriver indirmeniz gerekiyor. Ardindan chromedriver neredeyse pathi pathe gore guncelleyin

public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\adSoyad\\Downloads\\chromedriver-win64\\chromedriver.exe");

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