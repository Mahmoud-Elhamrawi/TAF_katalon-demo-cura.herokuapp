package com.Test_V8.Pages;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.ClassesUtil.ClassUtils;
import com.Test_V8.Utils.ElementsActions.ElementAction;
import com.Test_V8.Utils.LogUtil.LogUtils;
import com.Test_V8.Utils.Validations.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_AppointmentConfirmation {

    //Variables
    WebDriver driver;

    //Constructor
    public P04_AppointmentConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By appointmentConfirmation_text = By.xpath("//h2[.='Appointment Confirmation']");
    private final By facility_text = By.id("facility");
    private final By healthcareProgram_text = By.id("program");
    private final By comment_text = By.id("comment");
    private final By goToHomePage_btn = By.linkText("Go to Homepage");

    //Methods
    @Step("click on go to home page button")
    public P03_homePage clickBookAppointmentHomePage() {
        ClassUtils.takeScreenshot("confirmation page");
        ElementAction.clickOnElement(driver, goToHomePage_btn);
        return new P03_homePage(driver);
    }



    //Validations
    public P04_AppointmentConfirmation navigateToConfirmationPage(String expextedUrl) {
        Validations.validateUrl(BrowserAction.getCurrentUrl(driver), expextedUrl, "confirmation url is in-correct");
        LogUtils.info("Validation : Navigated to confirmation page Url");
        return new P04_AppointmentConfirmation(driver);
    }

    public P04_AppointmentConfirmation assertConfirmationTextTitle(String expextedText) {
        Validations.validateText(ElementAction.getTextFromElement(driver, appointmentConfirmation_text), expextedText, "confirmation text is in-correct");
        LogUtils.info("Validation : Confirmation text is : " + expextedText);
        return new P04_AppointmentConfirmation(driver);
    }

    public P04_AppointmentConfirmation assertHealthcareProgramText(String expextedText) {
        Validations.customAssertion(ElementAction.getTextFromElement(driver, healthcareProgram_text), expextedText, "facility text is in-correct");
        LogUtils.info("Validation : Healthcare Program text is : " + expextedText);
        return this;
    }

    public P04_AppointmentConfirmation assertCommentText(String expextedText) {
        Validations.customAssertion(ElementAction.getTextFromElement(driver, comment_text), expextedText, "facility text is in-correct");
        LogUtils.info("Validation : Comment text is : " + expextedText);
        return this;
    }

    public P04_AppointmentConfirmation assertFacilityText(String expextedText) {
        Validations.customAssertion(ElementAction.getTextFromElement(driver, facility_text), expextedText, "facility text is in-correct");
        LogUtils.info("Validation : Facility text is : " + expextedText);
        return this;
    }

}
