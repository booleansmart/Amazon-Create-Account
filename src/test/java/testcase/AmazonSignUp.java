package testcase;
/*
 * created by booleansmart
 * 20/08/2019
 */

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hook.Base;
import hook.HookTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectmodel.*;

public class AmazonSignUp extends Base {

    WebDriver tempEmailDriver;
    String tempEmailAddress = "enteryouremail@email.com";
    String name = "Jack Automatoni";
    String password = "amazonAmazing!21";
    String otp;

    @Given("Amazon web site is opened")
    public void amazonWebSiteIsOpened() {
        // go to amazon website
        webDriver.manage().window().maximize();
        webDriver.get("https://www.amazon.com");
    }

    @When("I click register on amazon")
    public void iClickRegisterOnAmazon() {
        // locate and click create account
        AmazonHomePage homePage = new AmazonHomePage(webDriver);
        homePage.clickCreateAccount();
    }

    @And("I input the required information")
    public void iInputTheRequiredInformationTemporaryEmail() {
        // Enter the required information on the signup page
        AmazonSignUpPage signUp = new AmazonSignUpPage(webDriver);
        signUp.createAccount(name, tempEmailAddress, password);
    }

    @Then("Amazon ask me to enter OTP password")
    public void amazonAskMeToEnterOTPPassword() {
        // Basically you can add some other test here :)
        System.out.println("I am here");
    }

    @When("I access my gmail account")
    public void iAccessMyTemporaryEmail() {
        // Initiate another browser window to access email inbox
        GmailLoginPage loginPage = new GmailLoginPage(tempEmailDriver);
        loginPage.gmailLogin(tempEmailAddress, "Nniefghand1221");   // login to email
        otp = loginPage.getOtp();       // retrieve the One-Time Password
        loginPage.closeDriver();        // close the driver (browser) that access the

    }

    @And("I enter the OTP from my gmail inbox")
    public void iEnterTheOTPFromMyTemporaryEmail() {
        // Enter the otp
        AmazonOtpPage otpPage = new AmazonOtpPage(webDriver);
        otpPage.verifyOtp(otp);
    }

    @Then("I am successfully create new account using temporary email")
    public void iAmSuccessfullyCreateNewAccountUsingTemporaryEmail() {
        System.out.println("yeeeay");
    }
}
