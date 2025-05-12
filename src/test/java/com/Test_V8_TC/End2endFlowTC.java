package com.Test_V8_TC;

import com.Test_V8.Driverr.DriverManger;
import com.Test_V8.Listeners.testNGListener;
import com.Test_V8.Pages.P01_LandingPage;
import com.Test_V8.Utils.BrowserActions.BrowserAction;
import com.Test_V8.Utils.DataUtils.readDateFromJsonFile;
import com.Test_V8.Utils.LogUtil.LogUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.*;


import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

@Listeners(testNGListener.class)
public class End2endFlowTC {

    readDateFromJsonFile fromJsonFile;

    @Step("validate end 2 end scenario")
    @Description("validate end 2 end scenario start from login then reserve an appointment then logout")
    @Test()
    public void end2EndTC() {

        new P01_LandingPage(DriverManger.getDrive())
                .assertBaseUrl()
                .clickOnToggleBtn()
                .clickOnLoginLink()
                .assertLoginUrl()
                .fillLoginForm(readDateFromJsonFile.getJsonKey("valid-credentialsData.userName"), readDateFromJsonFile.getJsonKey("valid-credentialsData.password"))
                .navigateToHomePage()
                .assertHomePageUrl(getPropertyName("HomePageUrl"))
                .selectFacility(getPropertyName("FacilityOption"))
                .selectHealthcareProgram(getPropertyName("HealthcareProgram"))
                .selectVisitDate(getPropertyName("VisitDate"))
                .enterComment(getPropertyName("comment"))
                .clickBookAppointment()
                .navigateToConfirmationPage(getPropertyName("AppointmentUrl"))
                .assertConfirmationTextTitle(getPropertyName("expextedTextConfirmPage"))
                .assertFacilityText(getPropertyName("FacilityOption"))
                .assertHealthcareProgramText(getPropertyName("HealthcareProgram"))
                .assertCommentText(getPropertyName("comment"))
                .clickBookAppointmentHomePage()
                .assertHomePageUrl(getPropertyName("baseUrl"));

        LogUtils.info("logout from application");

        new P01_LandingPage(DriverManger.getDrive())
                .clickOnToggleBtn().clickLogout().assertBaseUrl();

    }


    //Configuration
    @BeforeMethod
    public void setUpMethod() {

        DriverManger.createDriver(getPropertyName("browserName"));
        LogUtils.info("the browser Name is : " + getPropertyName("browserName"));

        BrowserAction.navigateToUrl(DriverManger.getDrive(), getPropertyName("baseUrl"));
        LogUtils.info("the base Url is : " + getPropertyName("baseUrl"));
    }


    @BeforeClass
    public void stUpClass() {
        fromJsonFile = new readDateFromJsonFile("testData");

    }

    @AfterMethod
    public void closeDriver() {
        DriverManger.closeDriver(DriverManger.getDrive());

    }


}
