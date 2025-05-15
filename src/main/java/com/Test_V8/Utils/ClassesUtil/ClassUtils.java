package com.Test_V8.Utils.ClassesUtil;

import com.Test_V8.Driverr.GuiDriver;
import com.Test_V8.Utils.AllureUtil.AllureUtils;
import com.Test_V8.Utils.LogUtil.LogUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassUtils {

    public static String screenshotPath = "test-outputs/screenshots/";


    //Take screenshot
    public static void takeScreenshot(String screenName) {
        try {
            File src = ((TakesScreenshot) GuiDriver.getDrive()).getScreenshotAs(OutputType.FILE);
            File dist = new File(screenshotPath + screenName + getTimeStamp() + ".png");
            FileUtils.copyFile(src, dist);
            AllureUtils.addScreenshotToAllure(screenName, String.valueOf(dist));
        } catch (Exception e) {
            LogUtils.error("Failed to take screenshot", e.getMessage());

        }
    }


    // timestamp
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd- HH-mm-ss").format(new Date());
    }


}
