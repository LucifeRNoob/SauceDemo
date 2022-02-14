package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.SauceDemoPage;

public class SauceDemoTest extends BaseTest {

    SauceDemoPage sauceDemoPage;

    @Test
    public void LogInTest() {
        sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.login();
        Assert.assertTrue(sauceDemoPage.checkInventoryPageOpened(), "User credentials are not valid");
    }

    @Test
    public void addItemToCartTest() {
        sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.login();
        sauceDemoPage.addItemToCart();
        Assert.assertTrue(sauceDemoPage.checkRemoveButton());
    }

    @Test
    public void goToCartTest() {
        sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.login();
        sauceDemoPage.goToShoppingCart();
        Assert.assertTrue(sauceDemoPage.checkCartIsAvailable());
    }

    @Test
    public void productPriceAndNameTest() {
        sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.login();
        sauceDemoPage.addItemToCart();
        sauceDemoPage.goToShoppingCart();
        Assert.assertEquals(sauceDemoPage.getProductPrice(), "$29.99");
        Assert.assertEquals(sauceDemoPage.getProductName(), "Sauce Labs Backpack");
    }
}
