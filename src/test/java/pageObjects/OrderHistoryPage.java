package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    public WebDriver ldriver;

    public OrderHistoryPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By orderHistory = By.cssSelector("a[title='Orders'] > span");

    public Boolean findValues(String OrderNumber) {
        String OrderReference = ldriver.findElement(By.xpath("//td[contains(.," + OrderNumber + ")]")).getText();
        return OrderNumber == null | !(OrderReference.isEmpty());
    }

    public void clickOrderHistory() {
        ldriver.findElement(orderHistory).click();
    }

    public Boolean getReferenceNo(String OrderNumber) {

        return findValues(OrderNumber);
    }
}
