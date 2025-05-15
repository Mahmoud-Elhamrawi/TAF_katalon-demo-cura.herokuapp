package com.Test_V8.Driverr;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class FirefoxFactory extends AbstractDriver implements WebDriverOptionsAbstract<FirefoxOptions> {

    @Override
    public FirefoxOptions getOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--remote-allow-origins=*");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-popup-blocking");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!getPropertyName("ExecutionMode").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }

        Map<String, Object> firePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manger_enabled", false,
                "autofill.enabled", false
        );

       //firefoxOptions.setexperimentalOption("prefs", firePrefs);
        return firefoxOptions;
    }


    @Override
    public WebDriver startDriver() {
        return new FirefoxDriver(getOptions());
    }
}
