package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    public WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By orderHistory = By.cssSelector("a[title='Orders'] > span");

    public Boolean findValues(String OrderNumber) {
        String OrderReference = driver.findElement(By.xpath("//td[contains(.," + OrderNumber + ")]")).getText();
        return OrderNumber == null | !(OrderReference.isEmpty());
    }

    public void clickOrderHistory() {
        driver.findElement(orderHistory).click();
    }

    public Boolean getReferenceNo(String OrderNumber) {

        return findValues(OrderNumber);
    }
}
