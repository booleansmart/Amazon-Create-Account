package pageobjectmodel;
/*
 * created by booleansmart
 * 21/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GmailMailPage{
    WebDriver driver;
    WebDriverWait wait;

    By gmailLogoLocator = By.cssSelector("[srcset]");
    By amazonMessageLocator = By.partialLinkText("Verify your new Amazon account");
    By otpLocator = By.cssSelector(".msg td p:nth-of-type(2)");

    public GmailMailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());

        //force to html mode
        wait.until(ExpectedConditions.visibilityOfElementLocated(gmailLogoLocator));
        driver.get("https://mail.google.com/mail/u/0/h/1gqe0vtx1xt9q/?f=1");
    }

    public String retrieveOtp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonMessageLocator));
        driver.findElement(amazonMessageLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator));
        return driver.findElement(otpLocator).getText();
    }
}
