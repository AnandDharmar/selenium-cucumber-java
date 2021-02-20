package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    public WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By proceedToCheckout = By.cssSelector("a.standard-checkout > span");
    By addressProceedToCheckout = By.cssSelector("button[name='processAddress'] > span");
    By terms = By.cssSelector("#cgv");
    By shoppingProceedToCheckout = By.cssSelector("button[name='processCarrier'] > span");
    By payByBank = By.cssSelector("a.bankwire > span");
    By confirmMyOrder = By.cssSelector("button.button-medium > span");

    public void proceedToPayment() {
        driver.findElement(proceedToCheckout).click();
        driver.findElement(addressProceedToCheckout).click();

    }

    public void clickonTerms() {
        driver.findElement(terms).click();
        driver.findElement(shoppingProceedToCheckout).click();
    }

    public void paymentOptions() {
        driver.findElement(payByBank).click();
        driver.findElement(confirmMyOrder).click();
    }


}
