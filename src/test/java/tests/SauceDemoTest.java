package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class SauceDemoTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void LogInTest() {
        loginPage.login();
        Assert.assertTrue(inventoryPage.checkInventoryPageOpened(), "User credentials are not valid");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addItemToCartTest() {
        loginPage.login();
        inventoryPage.addItemToCart();
        Assert.assertTrue(inventoryPage.checkRemoveButton());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void goToCartTest() {
        loginPage.login();
        inventoryPage.goToShoppingCart();
        Assert.assertTrue(cartPage.checkCartIsAvailable());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void productPriceAndNameTest() {
        loginPage.login();
        inventoryPage.addItemToCart();
        inventoryPage.goToShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(), "$29.99");
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void linkedinLogoElementTest() {
        loginPage.login();
        driverManager.removeTimeout();
        inventoryPage.clickLinkedinLink();
        linkedinPage.switchOnNewTab();
        Assert.assertTrue(linkedinPage.checkLogoElement(), "Element is not exist");
    }
}
