package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By signInLink = By.cssSelector(".login");
    By uname = By.cssSelector("#email");
    By pwd = By.cssSelector("#passwd");
    By signInButton = By.cssSelector("button#SubmitLogin > span");

    public void login(String username, String password) {
        ldriver.findElement(signInLink).click();
        ldriver.findElement(uname).sendKeys(username);
        ldriver.findElement(pwd).sendKeys(password);
        ldriver.findElement(signInButton).click();
    }

}