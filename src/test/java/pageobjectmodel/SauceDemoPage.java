package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.UserCredentials;
import staticdata.WebUrls;

public class SauceDemoPage extends BasePage {

    private By USERNAME = By.id("user-name");
    private By PASSWORD = By.id("password");
    private By LOGIN_BUTTON = By.id("login-button");
    private By ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private By SHOPPING_CART = By.className("shopping_cart_link");
    private By INVENTORY_ITEM_NAME = By.cssSelector("[class='inventory_item_name']");
    private By INVENTORY_ITEM_PRICE = By.cssSelector("[class='inventory_item_price']");
    private By INVENTORY_PAGE_TITLE = By.cssSelector(".title");
    private By CART_PAGE_SPAN_TITLE = By.className("title");

    public SauceDemoPage(WebDriver driver) {
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

    public void addItemToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getProductName() {
        return driver.findElement(INVENTORY_ITEM_NAME).getText();
    }

    public String getProductPrice() {
        return driver.findElement(INVENTORY_ITEM_PRICE).getText();
    }

    public void goToShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }

    public boolean checkInventoryPageOpened() {
        return driver.findElement(INVENTORY_PAGE_TITLE).isDisplayed();
    }

    public boolean checkRemoveButton() {
        return driver.findElement(REMOVE_BUTTON).isDisplayed();
    }

    public boolean checkCartIsAvailable() {
        return driver.findElement(CART_PAGE_SPAN_TITLE).isDisplayed();
    }
}






