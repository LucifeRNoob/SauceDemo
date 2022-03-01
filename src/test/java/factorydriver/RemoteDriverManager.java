package factorydriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {

    @Override
    public void createDriver() throws MalformedURLException {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 12");
        browserOptions.setCapability("browserVersion", "15");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL("https://oauth-andrewkremenevskiy-fe69f:b5594ef3-2752-4bcc-9d65-c60bc6af4a7d@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),browserOptions);
    }
}
