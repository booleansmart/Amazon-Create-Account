package hook;
/*
 * created by booleansmart
 * 20/08/2019
 */


import cucumber.api.java.After;
import cucumber.api.java.Before;


public class HookTest extends Base{


    @Before("@Web")
    public void setUpWebBrowser(){
        Base.webBrowserInit();
    }

    @Before("@NativeMobile")
    public void setUpNativeMobileBrowser(){

    }

    @After("Web")
    public void tearDownWebBrowser(){
        Base.webBrowserClose();
    }

    public HookTest() {
    }
}
