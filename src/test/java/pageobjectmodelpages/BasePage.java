package pageobjectmodelpages;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
