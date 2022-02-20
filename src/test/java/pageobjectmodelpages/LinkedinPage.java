package pageobjectmodelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LinkedinPage extends BasePage {

    private By LINKEDIN_LOGO = By.className("nav__logo-link");


    public LinkedinPage(WebDriver driver) {
        super(driver);
    }

    public void switchOnNewTab() {
        List<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LINKEDIN_LOGO));
    }

    public boolean checkLogoElement (){
        return driver.findElement(LINKEDIN_LOGO).isDisplayed();
    }
}


