package com.demo.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver<MobileElement>> DRIVERS = new ThreadLocal<>();

    public static AppiumDriver<MobileElement> getDriver() {
        return DRIVERS.get();
    }

    public static void setDriver(AppiumDriver<MobileElement> driver) {
        if (getDriver() == null) {
            DRIVERS.set(driver);
        }
    }
}
