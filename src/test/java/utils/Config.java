package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Config {
    private static Properties prop;

    public Config(String env) {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/" + env + ".properties";
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}