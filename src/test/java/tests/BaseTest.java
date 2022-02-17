package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjectmodelpages.CartPage;
import pageobjectmodelpages.InventoryPage;
import pageobjectmodelpages.LinkedinPage;
import pageobjectmodelpages.LoginPage;
import staticdata.WebTimeouts;
import utilities.PropertiesManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    LinkedinPage linkedinPage;

    @BeforeMethod
    public void setUp() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        removeTimeout();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        linkedinPage = new LinkedinPage(driver);
    }

    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(WebTimeouts.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
