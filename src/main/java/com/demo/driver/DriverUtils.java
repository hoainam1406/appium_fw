package com.demo.driver;

import com.demo.driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverUtils {

    public static AppiumDriver<MobileElement> getDriver() {
       return DriverManager.getDriver();
    }

    public static void executeScript(String script, Object... args) {
        getDriver().executeScript(script, args);
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}
