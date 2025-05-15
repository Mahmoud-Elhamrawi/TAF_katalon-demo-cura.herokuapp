package com.Test_V8.Pages;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.ElementsActions.ElementAction;
import com.Test_V8.Utils.LogUtil.LogUtils;
import com.Test_V8.Utils.Validations.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class P01_LandingPage {


    //Variables
    WebDriver driver;
    

    //Constructor
    public P01_LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By toggle_btn = By.id("menu-toggle");
    private final By login_link = By.xpath("//a[.='Login']");
    private final By logout_btn = By.linkText("Logout");


    //Methods
    @Step("click on toggle button")
    public P01_LandingPage clickOnToggleBtn() {
        ElementAction.clickOnElement(driver, toggle_btn);
        return this;
    }

    @Step("click on login link")
    public P02_LoginPage clickOnLoginLink() {
        ElementAction.clickOnElement(driver, login_link);
        return new P02_LoginPage(driver);
    }
    @Step("click on logout button")
    public P01_LandingPage clickLogout() {
        ElementAction.clickOnElement(driver, logout_btn);
        LogUtils.info("Logout button is clicked");
        return new P01_LandingPage(driver);
    }

    //Validations
    //validate on base url
    public P01_LandingPage assertBaseUrl() {
        Validations.validateUrl(BrowserAction.getCurrentUrl(driver), getPropertyName("baseUrl"), "in correct url");
        return this;
    }

}
