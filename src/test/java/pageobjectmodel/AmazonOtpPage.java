package pageobjectmodel;
/*
 * created by booleansmart
 * 20/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonOtpPage{
    WebDriver driver;
    WebDriverWait wait;

    By otpLocator = By.name("code");
    By verifyButtonLocator = By.id("a-autoid-0");

    public AmazonOtpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
    }

    public void verifyOtp(String otp){
        //Enter the otp
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator));
        driver.findElement(otpLocator).sendKeys(otp);

        wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator));
        driver.findElement(verifyButtonLocator).click();
    }

    public void closeDriver(){
        driver.close();
    }
}
