package pageobjectmodelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.UserCredentials;
import staticdata.WebUrls;

public class LoginPage extends BasePage{

    private By USERNAME = By.id("user-name");
    private By PASSWORD = By.id("password");
    private By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openSauceDemoPage() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
    }

    public void enterUserName() {
        driver.findElement(USERNAME).sendKeys(UserCredentials.USER_NAME);
    }

    public void enterPassword() {
        driver.findElement(PASSWORD).sendKeys(UserCredentials.PASSWORD);
    }

    public void login() {
        openSauceDemoPage();
        enterUserName();
        enterPassword();
        driver.findElement(LOGIN_BUTTON).click();
    }
}
