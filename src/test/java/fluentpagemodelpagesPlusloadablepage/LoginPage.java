package fluentpagemodelpagesPlusloadablepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.UserCredentials;
import staticdata.WebUrls;

public class LoginPage extends BasePage {

    private By USERNAME = By.id("user-name");
    private By PASSWORD = By.id("password");
    private By LOGIN_BUTTON = By.id("login-button");

    @Override
    public boolean isElementExist() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openSauceDemoPage() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        return this;
    }

    public LoginPage enterUserName() {
        driver.findElement(USERNAME).sendKeys(UserCredentials.USER_NAME);
        return this;
    }

    public LoginPage enterPassword() {
        driver.findElement(PASSWORD).sendKeys(UserCredentials.PASSWORD);
        return this;
    }

    public LoginPage login() {
        openSauceDemoPage();
        enterUserName();
        enterPassword();
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}
