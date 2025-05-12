package com.Test_V8.Utils.AllureUtil;

import com.Test_V8.Utils.Fileutil.FileUtils;
import com.Test_V8.Utils.LogUtil.LogUtils;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    // add screenshots
    public static void addScreenshotToAllure(String screenName, String Path) {

        try {
            Allure.addAttachment(screenName, Files.newInputStream(java.nio.file.Path.of(Path)));
        } catch (IOException e) {
            LogUtils.error("fail to add screen shots to allure report" + e.getMessage());

        }
    }


    //add logs
    public static void addLogsToAllure() {
        try {
            File logFile = FileUtils.getLastLogFile(LogUtils.logPath);
            Allure.addAttachment("Logs", Files.readString(logFile.toPath()));
        } catch (IOException e) {
            LogUtils.error("Error in addLogsToAllure method", e.getMessage());
        }


    }


}
