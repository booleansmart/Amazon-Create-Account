package pageobjectmodel;
/*
 * created by booleansmart
 * 20/08/2019
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonSignUpPage{

    WebDriver driver;
    WebDriverWait wait;

    By nameField = By.id("ap_customer_name");
    By emailField =  By.id("ap_email");
    By passwordField = By.id("ap_password");
    By passwordCheckField = By.id("ap_password_check");
    By continueButton = By.id("continue");

    List<WebElement> elements;

    public AmazonSignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, CollectionValue.getWaitElementTime());
//        elements = new ArrayList<WebElement>(Arrays.asList(driver.findElement(nameField),
//                driver.findElement(emailField), driver.findElement(passwordField),
//                driver.findElement(passwordCheckField), driver.findElement(continueButton)));
    }

    public void createAccount(String name, String email, String password){
//        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordCheckField).sendKeys(password);
//        driver.findElement(continueButton).click();
    }
}
