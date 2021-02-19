package stepDefinitions;

import Utilities.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public TShirtPage tShirtPage;
    public SummaryPage summaryPage;
    public MyAccountPage myAccountPage;
    public static Logger logger;
    public ConfirmationPage confirmationPage;
    public OrderHistoryPage orderHistoryPage;
    public PersonalInfoPage personalInfoPage;
    Properties configProp;
    public static PropertyReader testData = PropertyReader.getTestDataInstance();

}
