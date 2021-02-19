package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TShirtPage {


    public WebDriver ldriver;

    public TShirtPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By tShirtsLink = By.cssSelector("ul.sf-menu > li > [title='T-shirts']");
    By addToCart = By.cssSelector("a.ajax_add_to_cart_button > span");
    By proceedToCheckout = By.cssSelector("a.button-medium > span");
    By tShirtImage = By.cssSelector("[alt='Faded Short Sleeve T-shirts']");

    public void selectTShirt() {
        Actions action = new Actions(ldriver);
        ldriver.findElement(tShirtsLink).click();
        action.moveToElement(ldriver.findElement(tShirtImage)).build().perform();
        ldriver.findElement(addToCart).click();
        WebDriverWait wait = new WebDriverWait(ldriver, 5);
        wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(proceedToCheckout)));
        ldriver.findElement(proceedToCheckout).click();
    }

}
