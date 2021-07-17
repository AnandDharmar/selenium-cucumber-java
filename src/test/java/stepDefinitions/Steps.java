package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        } else
            if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
        }
    }

    String OrderNumber = "";

    @After
    public void testTearDown() {
        driver.quit();
    }


    @Given("User navigates to a page with a list of disputes")
    public void userNavigatesToAPageWithAListOfDisputes() throws IOException {
        logger.info("********* Launching browser************");
        driver.manage().window().maximize();
        driver.get(testData.readProperty("baseURL"));
        disputePage = new DisputePage(driver);
        disputePage.addToArray();
        disputePage.extractData();

    }



//    @Given("User enters a valid credentials")
//    public void userEntersAValidCredentials() {
//        driver.manage().window().maximize();
//        driver.get(testData.readProperty("baseURL"));
//        loginPage = new LoginPage(driver);
//        logger.info("********* Launching browser************");
//        loginPage.login(testData.readProperty("UserName"), testData.readProperty("Password"));
//    }
//
//    @And("Customer clicks on the T-Shirt category")
//    public void customerClicksOnTheTShirtCategory() {
//        tShirtPage = new TShirtPage(driver);
//    }
//
//    @And("Selects a T-Shirt and proceeds to checkout")
//    public void selectsATShirtAndProceedsToCheckout() {
//        logger.info("********* Selecting T-Shirt  ***************");
//        tShirtPage.selectTShirt();
//        summaryPage = new SummaryPage(driver);
//        summaryPage.proceedToPayment();
//    }
//
//    @And("agree to the terms and conditions")
//    public void agreeToTheTermsAndConditions() {
//        logger.info("********* Selecting Terms and Conditions  ***************");
//        summaryPage.clickonTerms();
//
//    }
//
//    @And("proceeds to pay by the available payment options")
//    public void proceedsToPayByTheAvilablePaymentOptions() {
//        logger.info("********* Pay by bank wire  ***************");
//        summaryPage.paymentOptions();
//    }
//
//    @And("Customer Confirms his order")
//    public void customerConfirmsHisOrder() {
//        logger.info("********* Payment confirmation and reference no generated  ***************");
//        confirmationPage = new ConfirmationPage(driver);
//        OrderNumber = confirmationPage.getReference();
//    }
//
//    @When("Customer navigates his order history page")
//    public void customerNavigatesHisOrderHistoryPage() {
//        logger.info("********* Order history page ***************");
//        orderHistoryPage = new OrderHistoryPage(driver);
//        orderHistoryPage.clickOrderHistory();
//    }
//
//    @Then("Order history should reflect this order for a T-Shirt")
//    public void orderHistoryShouldReflectThisOrderForATShirt() {
//        logger.info("********* Comparing the order should reflect the generated one ***************");
//        Assert.assertEquals(true, orderHistoryPage.getReferenceNo(OrderNumber));
//    }
//
//    @And("User clicks on My Personal Information")
//    public void userClicksOnMyPersonalInformation() {
//        logger.info("********* personal Information ***************");
//        myAccountPage = new MyAccountPage(driver);
//        myAccountPage.clickMyPersonaInfo();
//    }
//
//    @When("User updates the lastname and saves")
//    public void userUpdatesTheLastnameAndSaves() {
//        logger.info("********* Update the last name ***************");
//        personalInfoPage = new PersonalInfoPage(driver);
//        personalInfoPage.updateLastname(testData.readProperty("Password"), testData.readProperty("Password"), testData.readProperty("Password"));
//    }
//
//    @Then("Success message should be displayed")
//    public void successMessageShouldBeDisplayed() {
//        logger.info("********* Verify the success message ***************");
//        Assert.assertEquals("Your personal information has been successfully updated.", personalInfoPage.getSuccessMsg());
//
//    }
}