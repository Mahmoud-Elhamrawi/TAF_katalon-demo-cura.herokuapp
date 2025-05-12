package com.Test_V8.Utils.LogUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogUtils {

    public static String logPath = "test-outputs/Logs/";


    //getLogger
    public static Logger getLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    //set Logger
    public static void error(String... msg) {
        getLogger().error(String.join(" ", msg));
    }

    public static void info(String... msg) {
        getLogger().info(String.join(" ", msg));
    }

    public static void debug(String... msg) {
        getLogger().debug(String.join(" ", msg));
    }

}
