package com.Test_V8.Utils.Validations;

import com.Test_V8.Utils.CustomAssert.CustomAssert;
import org.testng.Assert;

public class Validations {


    // validate url
    public static void validateUrl(String actualUrl, String expectedUrl, String message) {
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    //validate page title
    public static void validatePageTitle(String actualTitle, String expectedTitle, String message) {
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }


    // validate text
    public static void validateText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    //  custom assertion
    public static void customAssertion(String actualText, String expectedText, String message) {
        CustomAssert.customAssert.assertEquals(actualText, expectedText, message);
    }

}
