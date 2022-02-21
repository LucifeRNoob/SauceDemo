package pageobjectmodelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private By ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private By SHOPPING_CART = By.className("shopping_cart_link");
    private By INVENTORY_PAGE_TITLE = By.cssSelector(".title");
    private By LINKEDIN_LINK = By.xpath("//li[@class='social_linkedin']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
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

    public void clickLinkedinLink (){
        driver.findElement(LINKEDIN_LINK).click();
    }
}
