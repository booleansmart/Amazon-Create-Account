package pageobjectmodel;
/*
 * created by booleansmart
 * 20/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage{
    WebDriver driver;
    WebDriverWait wait;

    By account = By.xpath("/html//a[@id='nav-link-accountList']");
//    By createAccount = By.xpath("//div[@id='nav-flyout-ya-newCust']/a[@href='https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust']");
    By createAccount = By.linkText("Start here.");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
    }

    public void clickCreateAccount(){
        // hover to account
        Actions hoverToAccount = new Actions(driver);
        hoverToAccount.moveToElement(driver.findElement(account)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccount));
        driver.findElement(createAccount).click();
    }
}
