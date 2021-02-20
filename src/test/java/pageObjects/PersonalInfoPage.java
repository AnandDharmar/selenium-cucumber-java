package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
    public WebDriver driver;
    Faker faker = new Faker();

    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By lastName = By.cssSelector("#lastname");
    By currentPassword = By.cssSelector("#old_passwd");
    By newPassword = By.cssSelector("#passwd");
    By confirmPassword = By.cssSelector("#confirmation");
    By save = By.cssSelector("button[name='submitIdentity'] > span");
    By successMsg = By.cssSelector(".alert");

    public void updateLastname(String currentPass, String newPass, String ConfPass) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(faker.name().firstName());
        driver.findElement(currentPassword).sendKeys(currentPass);
        driver.findElement(newPassword).sendKeys(newPass);
        driver.findElement(confirmPassword).sendKeys(ConfPass);
        driver.findElement(save).click();
    }

    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }

}
