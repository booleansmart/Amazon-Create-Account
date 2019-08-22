package pageobjectmodel;
/*
 * created by booleansmart
 * 20/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GetInBoxesPage{

    WebDriver driver;
    WebDriverWait wait;

    public enum StatusInit{NEW, EXISTING}

    By tempEmailLocator = By.xpath("/html/body/div[@class='hg']//b");
    By inboxTempEmailLocator = By.xpath("/html/body/div[@class='hg']//div[@class='nav']/dl[1]/dd/ul//a[@href='/']/span[.='Message List']");
    By amazonEmailInboxLocator = By.xpath("/html/body/div[@class='hg']//inbox-list/message-item[@class='unread']//span[@class='subject']");
//    By otpLocator = By.xpath("//td[@id='verificationMsg']/p[@class='otp']");

    By otpLocator = By.xpath("/html/body/div[@class='hg']/main[@class='hg-main']//h2");


    public GetInBoxesPage(WebDriver driver, StatusInit statusInit) {
        if (statusInit.equals(StatusInit.NEW)){
            driver = new ChromeDriver();
            this.driver = driver;
            wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
            driver.get("https://getinboxes.com/");
        }
        else {
            this.driver = driver;
            wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
        }
    }

    // fetch temp email address
    public String getEmailAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tempEmailLocator));
        return driver.findElement(tempEmailLocator).getText();
    }

    // fetch otp code
    public String getAmazonOTP(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inboxTempEmailLocator));
        driver.findElement(inboxTempEmailLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonEmailInboxLocator));
        driver.findElement(amazonEmailInboxLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator));
        return driver.findElement(otpLocator).getText();
    }

    public WebDriver updateDriver(){
        return driver;
    }
}
