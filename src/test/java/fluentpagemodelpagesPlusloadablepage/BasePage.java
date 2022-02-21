package fluentpagemodelpagesPlusloadablepage;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {

    WebDriver driver;

    public abstract boolean isElementExist();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
