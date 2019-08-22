package pageobjectmodel;
/*
 * created by booleansmart
 * 21/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage{
    WebDriver driver;
    WebDriverWait wait;

    By emailFieldLocator = By.name("identifier");
    By passwordFieldLocator = By.name("password");

    public GmailLoginPage(WebDriver driver) {
        driver = new ChromeDriver();
        this.driver = driver;
        wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
        driver.get("https://gmail.com/");
    }

    public void gmailLogin(String email, String password) {
        //enter the email address
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        driver.findElement(emailFieldLocator).sendKeys(email+"\n");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        driver.findElement(passwordFieldLocator).sendKeys(password+"\n");
    }

    public String getOtp(){
        GmailMailPage mailPage = new GmailMailPage(driver);
        return mailPage.retrieveOtp();
    }

    public void closeDriver(){
        driver.close();
    }
}