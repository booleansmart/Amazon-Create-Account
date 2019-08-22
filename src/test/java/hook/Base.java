package hook;
/*
 * created by booleansmart
 * 20/08/2019
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Base {
    public static WebDriver webDriver;

    // For reporting purpose
    public static void webBrowserInit(){

        /*
        * Some website put some security measurement for repeated attempt on login
        * one of workaround is by using incognito mode (but apparently not too successful :( )
        * but you will get more chance to do test in incognito mode than normal mode :) */

        System.setProperty("webdriver.chrome.driver", "D:\\testing\\driver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        webDriver = new ChromeDriver(capabilities);
    }

    public static void webBrowserClose(){
        webDriver.close();
    }
}
