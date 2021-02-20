package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By personalInformation = By.cssSelector("a[title='Information'] > span");

    public void clickMyPersonaInfo() {
        driver.findElement(personalInformation).click();
    }
}