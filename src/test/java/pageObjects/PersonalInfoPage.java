package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
    public WebDriver ldriver;
    Faker faker = new Faker();

    public PersonalInfoPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By lastName = By.cssSelector("#lastname");
    By currentPassword = By.cssSelector("#old_passwd");
    By newPassword = By.cssSelector("#passwd");
    By confirmPassword = By.cssSelector("#confirmation");
    By save = By.cssSelector("button[name='submitIdentity'] > span");
    By successMsg = By.cssSelector(".alert");

    public void updateLastname(String currentPass, String newPass, String ConfPass) {
        ldriver.findElement(lastName).clear();
        ldriver.findElement(lastName).sendKeys(faker.name().firstName());
        ldriver.findElement(currentPassword).sendKeys(currentPass);
        ldriver.findElement(newPassword).sendKeys(newPass);
        ldriver.findElement(confirmPassword).sendKeys(ConfPass);
        ldriver.findElement(save).click();
    }

    public String getSuccessMsg() {
        return ldriver.findElement(successMsg).getText();
    }

}
