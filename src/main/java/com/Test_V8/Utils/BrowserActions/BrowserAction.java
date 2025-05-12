package com.Test_V8.Utils.BrowserActions;

import org.openqa.selenium.WebDriver;

public class BrowserAction {


    //navigate to url
    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }


    // get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // get current url
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }


    //close browser
    public static void closeBrowser(WebDriver driver) {
        driver.close();
    }


}
