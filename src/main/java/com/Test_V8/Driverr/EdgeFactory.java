package com.Test_V8.Driverr;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;

import static com.Test_V8.Utils.DataUtils.readPropertyFile.getPropertyName;

public class EdgeFactory extends AbstractDriver implements WebDriverOptionsAbstract<EdgeOptions> {

    @Override
    public EdgeOptions getOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
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

        Map<String, Object> edgePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manger_enabled", false,
                "autofill.enabled", false
        );
        //edgeOptions.setExperimentalOption("userPrefs", edgePrefs);
        return edgeOptions;


    }

    @Override
    public WebDriver startDriver() {
        return new EdgeDriver(getOptions());
    }
}
