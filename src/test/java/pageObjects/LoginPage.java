package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By signInLink = By.cssSelector(".login");
    By uname = By.cssSelector("#email");
    By pwd = By.cssSelector("#passwd");
    By signInButton = By.cssSelector("button#SubmitLogin > span");

    public void login(String username, String password) {
        driver.findElement(signInLink).click();
        driver.findElement(uname).sendKeys(username);
        driver.findElement(pwd).sendKeys(password);
        driver.findElement(signInButton).click();
    }

}