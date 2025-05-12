package com.Test_V8.Utils.ElementsActions;

import com.Test_V8.Utils.Waits.WaitUtil;
import com.Test_V8.Utils.scrolling.Scrolling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementAction {


    // click
    public static void clickOnElement(WebDriver driver, By locator) {
        WaitUtil.waitForElementToBeClickable(driver, locator);
        Scrolling.scrollIToEle(driver, locator);
        driver.findElement(locator).click();
    }


    //sendKeys
    public static void sendKeysToElement(WebDriver driver, By locator, String text) {
        WaitUtil.waitForElementToBePresent(driver, locator);
        Scrolling.scrollIToEle(driver, locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }


    //getText
    public static String getTextFromElement(WebDriver driver, By locator) {
        WaitUtil.waitForElementToBePresent(driver, locator);
        Scrolling.scrollIToEle(driver, locator);
        return driver.findElement(locator).getText();
    }

}
