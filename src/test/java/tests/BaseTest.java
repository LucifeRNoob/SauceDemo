package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjectmodelpages.CartPage;
import pageobjectmodelpages.InventoryPage;
import pageobjectmodelpages.LinkedinPage;
import pageobjectmodelpages.LoginPage;


public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    LinkedinPage linkedinPage;

    @BeforeMethod
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        linkedinPage = new LinkedinPage(driver);
    }

    @AfterMethod
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
