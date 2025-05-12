package com.Test_V8.Listeners;

import com.Test_V8.Driverr.DriverManger;
import com.Test_V8.Utils.AllureUtil.AllureUtils;
import com.Test_V8.Utils.ClassesUtil.ClassUtils;
import com.Test_V8.Utils.Fileutil.FileUtils;
import com.Test_V8.Utils.LogUtil.LogUtils;
import org.testng.*;

import java.io.File;
import java.sql.DriverManager;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.loadProperties;
import static com.Test_V8.Utils.Fileutil.FileUtils.cleanDirectory;
import static java.sql.DriverManager.getDriver;

public class testNGListener implements IInvokedMethodListener, IExecutionListener, ITestListener {

    File allureFiles = new File("test-outputs/target/allure-results/");
    File screenshots = new File("test-outputs/screenshots/");
    File logfiles = new File("test-outputs/Logs/");


    @Override
    public void onExecutionStart() {
        LogUtils.info("Execution started");

        loadProperties();
        LogUtils.info("start load properties Files");

        cleanDirectory(screenshots);
        LogUtils.info("The Previous screenshots are deleted ");

        cleanDirectory(logfiles);
        LogUtils.info("The Previous logs are deleted ");

        FileUtils.deleteFile(allureFiles);
        LogUtils.info("The Previous allure results are deleted");
    }

    @Override
    public void onExecutionFinish() {
        LogUtils.info("Execution finished");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS ->
                        ClassUtils.takeScreenshot("Passed -" + testResult.getName());
                case ITestResult.FAILURE ->
                        ClassUtils.takeScreenshot("Failed -" + testResult.getName());
                case ITestResult.SKIP ->
                        ClassUtils.takeScreenshot("Skipped -" + testResult.getName());
            }

            AllureUtils.addLogsToAllure();

        }


    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Test Case, ", result.getName(), " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test Case, ", result.getName(), " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.info("Test Case, ", result.getName(), " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("Test Case, ", result.getName(), " skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LogUtils.info("Test Suite, ", context.getName(), " started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtils.info("Test Suite, ", context.getName(), " finished");
    }


}
