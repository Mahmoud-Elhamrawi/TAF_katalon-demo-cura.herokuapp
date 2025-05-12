package com.Test_V8.Driverr;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import org.openqa.selenium.WebDriver;

public class DriverManger {


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

    public static WebDriver createDriver(String browserName) {
        WebDriver driver = DriverFactory.getBrowser(browserName);
        setDriver(driver);
        return getDrive();
    }

    // close driver
    public static void closeDriver(WebDriver driver) {
        BrowserAction.closeBrowser(driver);
        threadLocal.remove();
    }


}
