package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SauceDemoTest extends BaseTest {

    @Test
    public void LogInTest() throws IOException {
        loginPage.login();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot1.png"), sourceFile);
        Assert.assertTrue(inventoryPage.checkInventoryPageOpened(), "User credentials are not valid");
    }

    @Test
    public void addItemToCartTest() throws IOException {
        loginPage.login();
        inventoryPage.addItemToCart();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot2.png"), sourceFile);
        Assert.assertTrue(inventoryPage.checkRemoveButton());
    }

    @Test
    public void goToCartTest() throws IOException {
        loginPage.login();
        inventoryPage.goToShoppingCart();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot3.png"), sourceFile);
        Assert.assertTrue(cartPage.checkCartIsAvailable());
    }

    @Test
    public void productPriceAndNameTest() throws IOException {
        loginPage.login();
        inventoryPage.addItemToCart();
        inventoryPage.goToShoppingCart();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot4.png"), sourceFile);
        Assert.assertEquals(cartPage.getProductPrice(), "$29.99");
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void linkedinLogoElementTest() throws IOException {
        loginPage.login();
        driverManager.removeTimeout();
        inventoryPage.clickLinkedinLink();
        linkedinPage.switchOnNewTab();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot5.png"), sourceFile);
        Assert.assertTrue(linkedinPage.checkLogoElement(),"Element is not exist");
    }
}
