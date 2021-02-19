package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    public WebDriver ldriver;

    public SummaryPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By proceedToCheckout = By.cssSelector("a.standard-checkout > span");
    By addressProceedToCheckout = By.cssSelector("button[name='processAddress'] > span");
    By terms = By.cssSelector("#cgv");
    By shoppingProceedToCheckout = By.cssSelector("button[name='processCarrier'] > span");
    By payByBank = By.cssSelector("a.bankwire > span");
    By confirmMyOrder = By.cssSelector("button.button-medium > span");

    public void proceedToPayment() {
        ldriver.findElement(proceedToCheckout).click();
        ldriver.findElement(addressProceedToCheckout).click();

    }

    public void clickonTerms() {
        ldriver.findElement(terms).click();
        ldriver.findElement(shoppingProceedToCheckout).click();
    }

    public void paymentOptions() {
        ldriver.findElement(payByBank).click();
        ldriver.findElement(confirmMyOrder).click();
    }


}
