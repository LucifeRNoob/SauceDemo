package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.UserCredentials;
import staticdata.WebUrls;

public class SauceDemoTest extends BaseTest {

    @Test
    public void LogInTest() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        //Input username
        driver.findElement(By.id("user-name")).sendKeys(UserCredentials.USER_NAME);
        //Input password
        driver.findElement(By.id("password")).sendKeys(UserCredentials.PASSWORD);
        //Click on 'LOGIN' button
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), WebUrls.BASE_INVENTORY_URL);
    }

    @Test
    public void addItemToCartTest() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        //LogIn
        driver.findElement(By.id("user-name")).sendKeys(UserCredentials.USER_NAME);
        driver.findElement(By.id("password")).sendKeys(UserCredentials.PASSWORD);
        driver.findElement(By.id("login-button")).click();
        //Add product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Check element 'REMOVE' button
        Assert.assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(), "REMOVE");
    }

    @Test
    public void goToCartTest() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        //LogIn
        driver.findElement(By.id("user-name")).sendKeys(UserCredentials.USER_NAME);
        driver.findElement(By.id("password")).sendKeys(UserCredentials.PASSWORD);
        driver.findElement(By.id("login-button")).click();
        //Add product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Go to the shopping cart
        driver.findElement(By.className("shopping_cart_link")).click();
        //Check if the added product is in the cart
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='inventory_item_name']")).getText(), "Sauce Labs Backpack");
    }

    @Test
    public void productPriceAndName() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        //LogIn
        driver.findElement(By.id("user-name")).sendKeys(UserCredentials.USER_NAME);
        driver.findElement(By.id("password")).sendKeys(UserCredentials.PASSWORD);
        driver.findElement(By.id("login-button")).click();
        //Add product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Go to the shopping cart
        driver.findElement(By.className("shopping_cart_link")).click();
        //Check product price
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='inventory_item_price']")).getText(), "$29.99");
        //Check product by name
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='inventory_item_name']")).getText(), "Sauce Labs Backpack");
    }
}
