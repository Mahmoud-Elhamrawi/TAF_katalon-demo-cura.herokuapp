package com.Test_V8.Utils.CustomAssert;

import aj.org.objectweb.asm.Label;
import com.Test_V8.Utils.LogUtil.LogUtils;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class CustomAssert extends SoftAssert {


    public static CustomAssert customAssert = new CustomAssert();

    public static void getCustomAssert() {
        try {
            customAssert.assertAll("soft Assert done");
        } catch (Exception e) {
            LogUtils.error("soft Assert failed " + e.getMessage());
        }


    }


}
