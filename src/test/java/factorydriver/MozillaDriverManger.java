package factorydriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.PropertiesManager;

public class MozillaDriverManger extends DriverManager {

    @Override
    public void createDriver() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.gecko.driver", propertiesManager.get("PATH_TO_MOZILLA_DRIVER"));
        driver = new FirefoxDriver();
    }
}
