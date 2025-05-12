package com.Test_V8.Pages;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.ElementsActions.ElementAction;
import com.Test_V8.Utils.LogUtil.LogUtils;
import com.Test_V8.Utils.Validations.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class P02_LoginPage {

    WebDriver driver;

    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By userName_inp = By.id("txt-username");
    private final By password_Inp = By.id("txt-password");
    private final By login_btn = By.id("btn-login");


    //Methods
    @Step("enter user name and password")
    public P02_LoginPage fillLoginForm(String uName, String uPassword) {
        ElementAction.sendKeysToElement(driver, this.userName_inp, uName);
        ElementAction.sendKeysToElement(driver, this.password_Inp, uPassword);
        return this;
    }

    @Step("click on login button and move to homa page")
    public P03_homePage navigateToHomePage() {
        ElementAction.clickOnElement(driver, login_btn);
        return new P03_homePage(driver);
    }


    //Validation
    public P02_LoginPage assertLoginUrl() {
        Validations.validateUrl(BrowserAction.getCurrentUrl(driver), getPropertyName("loginUrl"), "login url in correct");
        return this;
    }



}
