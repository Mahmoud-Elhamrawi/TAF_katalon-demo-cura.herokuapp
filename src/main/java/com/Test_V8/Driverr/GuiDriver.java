package com.Test_V8.Driverr;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.LogUtil.LogUtils;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class GuiDriver {


    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();


    // set Driver
    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    //get Driver
    public static WebDriver getDrive() {
        return threadLocal.get();
    }

    //create instance

//    public static WebDriver createDriver(String browserName) {
//        WebDriver driver = DriverFactory.getBrowser(browserName);
//        setDriver(driver);
//        return getDrive();
//    }

    // close driver
    public static void closeDriver(WebDriver driver) {
        BrowserAction.closeBrowser(driver);
        threadLocal.remove();
    }




    ///////////////////////////////////////////////////////////////////////////////////
    private AbstractDriver getdriver(String browserName) {
        return switch (browserName) {
            case "chrome" -> new ChromeFactory();
            case "firefox" -> new FirefoxFactory();
            case "edge" -> new EdgeFactory();
            default ->  null;
        };
    }

    public GuiDriver(String browserName)
        {
         WebDriver driver = getdriver(browserName).startDriver();
         setDriver(driver);
        }





    public WebDriver get() {
        if (threadLocal.get() == null) {
            LogUtils.error("driver is null");
            fail("driver is null");
        }
        return threadLocal.get();
    }


}
