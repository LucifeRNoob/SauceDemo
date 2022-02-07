package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import staticdata.UserCredentials;
import staticdata.WebUrls;

public class Locators extends BaseTest {

    @Test
    public void locators() {
        driver.get(WebUrls.BASE_SAUCE_DEMO_URL);
        //Login
        driver.findElement(By.id("user-name")).sendKeys(UserCredentials.USER_NAME);
        driver.findElement(By.id("password")).sendKeys(UserCredentials.PASSWORD);
        driver.findElement(By.id("login-button")).click();
        //Search by classname
        WebElement primaryHeader = driver.findElement(By.className("primary_header"));
        //Search by tagName
        WebElement footer = driver.findElement(By.tagName("footer"));
        //Search by linkText
        WebElement sauceLabsBackpack = driver.findElement(By.linkText("Sauce Labs Backpack"));
        //Search by partialLinkText
        WebElement sauceLabsBikeLight = driver.findElement(By.partialLinkText("Bike Light"));
        //************************************************************************************************************************
        //Xpath
        //Search by attribute
        WebElement spanTitle = driver.findElement(By.xpath("//span[@class='title']"));
        //Search by text
        WebElement spanText = driver.findElement(By.xpath("//span[text()='Products']"));
        //Search by partial match attribute
        WebElement footerPartialAttribute = driver.findElement(By.xpath("//footer[contains(@class,'foot')]"));
        //Search by partial text match
        WebElement spanPartialText = driver.findElement(By.xpath("//span[contains(text(),'Prod')]"));
        //Ancestor
        WebElement inventoryContainer = driver.findElement(By.xpath("//div[@class='inventory_list']//ancestor::div"));
        //Parent
        WebElement footerParent = driver.findElement(By.xpath("//footer[@class='footer']//parent::div"));
        //Search for an element with an AND condition
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium' and @name='continue-shopping']"));
        //*************************************************************************************************************************
        //CSS
        //.class
        WebElement footerCss = driver.findElement(By.cssSelector(".footer"));
        //#id
        WebElement shoppingCart = driver.findElement(By.cssSelector("#shopping_cart_container"));
        //tagName
        WebElement appLogo = driver.findElement(By.cssSelector("a"));
        //[attribute^=value]
        WebElement facebookLink = driver.findElement(By.cssSelector("a[href^='https://www.facebook.']"));
        //[attribute$=value]
        WebElement socialFacebookLink = driver.findElement(By.cssSelector("[class$='facebook']"));
        //[attribute*=value]
        WebElement socialLinkedInLink = driver.findElement(By.cssSelector("[class*='linkedin']"));
        //element:first-child
        WebElement root = driver.findElement(By.cssSelector("div:first-child"));
        //element:nth-child(0)
        WebElement container = driver.findElement(By.cssSelector("div:nth-child(3)"));
    }
}
