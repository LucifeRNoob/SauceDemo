package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjectmodelpages.CartPage;
import pageobjectmodelpages.InventoryPage;
import pageobjectmodelpages.LinkedinPage;
import pageobjectmodelpages.LoginPage;
import utilities.TestListeners;

import java.net.MalformedURLException;

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    LinkedinPage linkedinPage;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        DriverType driverType = null;
        if(browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        linkedinPage = new LinkedinPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
