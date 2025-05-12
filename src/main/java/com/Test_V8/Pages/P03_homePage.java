package com.Test_V8.Pages;

import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.ElementsActions.ElementAction;
import com.Test_V8.Utils.LogUtil.LogUtils;
import com.Test_V8.Utils.Validations.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class P03_homePage {
    //Variables
    WebDriver driver;


    //Constructor
    public P03_homePage(WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    private final By select_Option = By.id("combo_facility");
    private final By visitDate_datePicker = By.cssSelector("div[class=\"input-group-addon\"]");
    private final By comment_textarea = By.id("txt_comment");
    private final By bookAppointment_btn = By.id("btn-book-appointment");

    //Methods
    @Step("select facility")
    public P03_homePage selectFacility(String facility) {
        new Select(driver.findElement(select_Option)).selectByVisibleText(facility);
        return new P03_homePage(driver);
    }

 @Step("select healthcare program")
    public P03_homePage selectHealthcareProgram(String healthcareProgram) {
        ElementAction.clickOnElement(driver, By.xpath("//input[@id=\"radio_program_" + healthcareProgram + "\"]"));
        LogUtils.info("Healthcare Program is : " + healthcareProgram);
        return new P03_homePage(driver);
    }
@Step("select visit date")
    public P03_homePage selectVisitDate(String visitDate) {
        ElementAction.clickOnElement(driver, visitDate_datePicker);
        ElementAction.clickOnElement(driver, By.xpath("//div[@class=\"datepicker-days\"]/table//tr/td[.='" + visitDate + "' and @class=\"day\"]"));
        LogUtils.info("Visit Date is : " + visitDate);
        return new P03_homePage(driver);
    }

    @Step("enter comment")
    public P03_homePage enterComment(String comment) {
        ElementAction.sendKeysToElement(driver, comment_textarea, comment);
        LogUtils.info("Comment is : " + comment);
        return new P03_homePage(driver);
    }

    @Step("click on book appointment button")
    public P04_AppointmentConfirmation clickBookAppointment() {
        ElementAction.clickOnElement(driver, bookAppointment_btn);
        LogUtils.info("Book Appointment button is clicked");
        return new P04_AppointmentConfirmation(driver);
    }


    //Validation
    public P03_homePage assertHomePageUrl(String expectedUrl) {
        Validations.validateUrl(BrowserAction.getCurrentUrl(driver), expectedUrl, "home page in correct");
        LogUtils.info("Validation : Navigated to home page Url");
        return new P03_homePage(driver);
    }


}
