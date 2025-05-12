package com.Test_V8.Utils.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {


    //exist
    public static WebElement waitForElementToBeExist(WebDriver driver , By locator){
        return  new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> driver1.findElement(locator)
        );
    }

    // present
    public static WebElement waitForElementToBePresent(WebDriver driver , By locator){
        return  new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 ->{
                    WebElement element = waitForElementToBeExist(driver, locator);
                    return element.isDisplayed() ? element : null;
                }
        );
    }
    //clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver , By locator){
        return  new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 ->{
                    WebElement element = waitForElementToBePresent(driver, locator);
                    return element.isEnabled() ? element : null;
                }
        );
    }





}
