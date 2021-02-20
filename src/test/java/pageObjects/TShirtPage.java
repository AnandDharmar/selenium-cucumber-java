package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TShirtPage {


    public WebDriver driver;

    public TShirtPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By tShirtsLink = By.cssSelector("ul.sf-menu > li > [title='T-shirts']");
    By addToCart = By.cssSelector("a.ajax_add_to_cart_button > span");
    By proceedToCheckout = By.cssSelector("a.button-medium > span");
    By tShirtImage = By.cssSelector("[alt='Faded Short Sleeve T-shirts']");

    public void selectTShirt() {
        Actions action = new Actions(driver);
        driver.findElement(tShirtsLink).click();
        action.moveToElement(driver.findElement(tShirtImage)).build().perform();
        driver.findElement(addToCart).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedToCheckout)));
        driver.findElement(proceedToCheckout).click();
    }

}
