package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        logger = logger.getLogger("Sample Project");
        PropertyConfigurator.configure("log4j.properties");
        configProp = new Properties();
        FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);
        logger.info("*********Browser Initialization************");
        String browser = configProp.getProperty("browser");
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
        }
    }

    String OrderNumber = "";

    @After
    public void testTearDown() {
        driver.quit();
    }


    @Given("User enters a valid credentials")
    public void userEntersAValidCredentials() {
        driver.manage().window().maximize();
        driver.get(testData.readProperty("baseURL"));
        lp = new LoginPage(driver);
        logger.info("********* Launching browser************");
        lp.login(testData.readProperty("UserName"), testData.readProperty("Password"));
    }

    @And("Customer clicks on the T-Shirt category")
    public void customerClicksOnTheTShirtCategory() {
        tp = new TShirtPage(driver);
    }

    @And("Selects a T-Shirt and proceeds to checkout")
    public void selectsATShirtAndProceedsToCheckout() {
        logger.info("********* Selecting T-Shirt  ***************");
        tp.selectTShirt();
        sp = new SummaryPage(driver);
        sp.proceedToPayment();
    }

    @And("agree to the terms and conditions")
    public void agreeToTheTermsAndConditions() {
        logger.info("********* Selecting Terms and Conditions  ***************");
        sp.clickonTerms();

    }

    @And("proceeds to pay by the available payment options")
    public void proceedsToPayByTheAvilablePaymentOptions() {
        logger.info("********* Pay by bank wire  ***************");
        sp.paymentOptions();
    }

    @And("Customer Confirms his order")
    public void customerConfirmsHisOrder() {
        logger.info("********* Payment confirmation and reference no generated  ***************");
        cp = new ConfirmationPage(driver);
        OrderNumber = cp.getReference();
    }

    @When("Customer navigates his order history page")
    public void customerNavigatesHisOrderHistoryPage() {
        logger.info("********* Order history page ***************");
        oh = new OrderHistoryPage(driver);
        oh.clickOrderHistory();
    }

    @Then("Order history should reflect this order for a T-Shirt")
    public void orderHistoryShouldReflectThisOrderForATShirt() {
        logger.info("********* Comparing the order should reflect the generated one ***************");
        oh = new OrderHistoryPage(driver);
        Assert.assertEquals(true, oh.getReferenceNo(OrderNumber));
    }

    @And("User clicks on My Personal Information")
    public void userClicksOnMyPersonalInformation() {
        logger.info("********* personal Information ***************");
        ma = new MyAccountPage(driver);
        ma.clickMyPersonaInfo();
    }

    @When("User updates the lastname and saves")
    public void userUpdatesTheLastnameAndSaves() {
        logger.info("********* Update the last name ***************");
        pi = new PersonalInfoPage(driver);
        pi.updateLastname(testData.readProperty("Password"), testData.readProperty("Password"), testData.readProperty("Password"));
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        logger.info("********* Verify the success message ***************");
        Assert.assertEquals("Your personal information has been successfully updated.", pi.getSuccessMsg());

    }
}