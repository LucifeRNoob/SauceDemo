package fluentpagemodelpagesPlusloadablepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By INVENTORY_ITEM_NAME = By.cssSelector("[class='inventory_item_name']");
    private By INVENTORY_ITEM_PRICE = By.cssSelector("[class='inventory_item_price']");
    private By CART_PAGE_SPAN_TITLE = By.className("title");

    @Override
    public boolean isElementExist() {
        return driver.findElement(CART_PAGE_SPAN_TITLE).isDisplayed();
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(INVENTORY_ITEM_NAME).getText();
    }

    public String getProductPrice() {
        return driver.findElement(INVENTORY_ITEM_PRICE).getText();
    }

//    public boolean checkCartIsAvailable() {
//        return driver.findElement(CART_PAGE_SPAN_TITLE).isDisplayed();
//    }
}

