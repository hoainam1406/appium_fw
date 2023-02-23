package com.demo.utils;

import com.demo.helpers.PropertiesHelper;

public class Constants {

    //Conf
    public static final int LONG_WAIT = PropertiesHelper.getInt("conf.long.time.wait");
    public static final int MEDIUM_WAIT = PropertiesHelper.getInt("conf.medium.time.wait");
    public static final int SHORT_WAIT = PropertiesHelper.getInt("conf.short.time.wait");
    public static final String URL = PropertiesHelper.getPropValue("conf.server.url");
    public static final int APPIUM_PORT_NUMBER = PropertiesHelper.getInt("conf.server.port");

    //Path
    public static final String CAPS_PATH = "src/test/resources/caps/capabilities.json";

    //Profile
    public static final String EMAIL = PropertiesHelper.getPropValue("profile.user.name");
    public static final String PASSWORD = PropertiesHelper.getPropValue("profile.user.password");
}
