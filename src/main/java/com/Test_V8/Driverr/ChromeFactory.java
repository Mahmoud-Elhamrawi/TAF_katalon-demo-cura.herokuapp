package com.Test_V8.Driverr;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class ChromeFactory extends AbstractDriver  implements WebDriverOptionsAbstract<ChromeOptions>  {
    @Override
    public ChromeOptions getOptions() {
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
        chromeOptions.setExperimentalOption("userPrefs", chromePrefs);

        return chromeOptions;


    }


    @Override
    public WebDriver startDriver() {
        return new ChromeDriver(getOptions());
    }
}
