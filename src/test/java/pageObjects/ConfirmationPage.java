package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmationPage {
    public WebDriver ldriver;

    public ConfirmationPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By userName = By.cssSelector("a.account > span");
    By refererno = By.cssSelector(".box");

    public String getReference() {
        System.out.println("Test is" + ldriver.findElement(refererno).getText());
        String OrderNumberText = ldriver.findElement(refererno).getText();
        String OrderNumber = OrderMatch(OrderNumberText);
        ldriver.findElement(userName).click();
        return OrderNumber;
    }

    public static String OrderMatch(String haystack) {
        Pattern needle = Pattern.compile("[A-Z]{9}+");
        Matcher matcher = needle.matcher(haystack);
        String matched = "";
        int matches = 0;
        while (matcher.find()) {
            matches++;
            matched = matcher.group();
        }
        return matched;
    }


}
