package com.Test_V8.Driverr;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class DriverFactory {


    public static WebDriver getBrowser(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-info-bars");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (!getPropertyName("ExecutionMode").equalsIgnoreCase("local")) {
                    chromeOptions.addArguments("--headless");
                }

                Map<String, Object> chromePrefs = Map.of(
                        "profile.default_content_setting_values.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manger_enabled", false,
                        "autofill.enabled", false
                );
              //  chromeOptions.setExperimentalOption("userPrefs", chromePrefs);
                return new ChromeDriver(chromeOptions);

            case "firefox":
                return new FirefoxDriver();

            default:
                EdgeOptions  edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-info-bars");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                if (!getPropertyName("ExecutionMode").equalsIgnoreCase("local")) {
                    edgeOptions.addArguments("--headless");
                }

                return new EdgeDriver(edgeOptions);
        }


    }


}
