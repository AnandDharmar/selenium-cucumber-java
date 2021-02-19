package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public WebDriver ldriver;

    public MyAccountPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By personalInformation = By.cssSelector("a[title='Information'] > span");

    public void clickMyPersonaInfo() {
        ldriver.findElement(personalInformation).click();
    }
}