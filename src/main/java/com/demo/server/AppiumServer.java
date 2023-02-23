package com.demo.server;

import com.demo.helpers.LogHelper;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.ServerSocket;

public class AppiumServer {

    private static AppiumDriverLocalService service;

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (Exception e) {
            //If control comes here, it means that the port is in use
            isServerRunning = true;
        }
        return isServerRunning;
    }

    public static void start(int port) {
        boolean flag = checkIfServerIsRunning(port);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
    }

    public static void stopAppiumServer() {
        service.stop();
        LogHelper.info("Server is stopped successfully");
    }
}
