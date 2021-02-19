package stepDefinitions;

import Utilities.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public TShirtPage tp;
    public SummaryPage sp;
    public MyAccountPage ma;
    public static Logger logger;
    public ConfirmationPage cp;
    public OrderHistoryPage oh;
    public PersonalInfoPage pi;
    Properties configProp;
    public static PropertyReader testData = PropertyReader.getTestDataInstance();

}
