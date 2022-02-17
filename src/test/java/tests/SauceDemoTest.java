package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

    @Test
    public void LogInTest() {
        loginPage.login();
        Assert.assertTrue(inventoryPage.checkInventoryPageOpened(), "User credentials are not valid");
    }

    @Test
    public void addItemToCartTest() {
        loginPage.login();
        inventoryPage.addItemToCart();
        Assert.assertTrue(inventoryPage.checkRemoveButton());
    }

    @Test
    public void goToCartTest() {
        loginPage.login();
        inventoryPage.goToShoppingCart();
        Assert.assertTrue(cartPage.checkCartIsAvailable());
    }

    @Test
    public void productPriceAndNameTest() {
        loginPage.login();
        inventoryPage.addItemToCart();
        inventoryPage.goToShoppingCart();
        Assert.assertEquals(cartPage.getProductPrice(), "$29.99");
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void linkedinLogoElement(){
        loginPage.login();
        inventoryPage.clickLinkedinLink();
        linkedinPage.switchOnNewTab();
        Assert.assertTrue(linkedinPage.checkLogoElement(),"Element is not exist");
    }
}
