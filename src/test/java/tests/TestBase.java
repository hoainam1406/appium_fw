package tests;

import com.demo.driver.DriverUtils;
import com.demo.driver.manager.DriverManager;
import com.demo.helpers.JsonHelper;
import com.demo.helpers.LogHelper;
import com.demo.server.AppiumServer;
import com.demo.utils.Constants;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;

public class TestBase {

    private AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void beforeSuite() {
        AppiumServer.start(Constants.APPIUM_PORT_NUMBER);
    }

    @SneakyThrows
    @BeforeClass
    @Parameters({"platform"})
    public void beforeClass(@Optional("android") String platform) {
        String capabilities = JsonHelper.getJsonObject(Constants.CAPS_PATH).get(platform).toString();
        Capabilities caps = JsonHelper.convertJsonToDesiredCapabilities(capabilities);
        switch (Platform.fromVal(platform)) {
            case ANDROID:
                this.driver = new AndroidDriver<>(new URL(Constants.URL), caps);
                break;
            case IOS:
                this.driver = new IOSDriver<>(new URL(Constants.URL), caps);
                break;
            default:
                LogHelper.info("Unknown platform specified, please check...)");
        }
        DriverManager.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        AppiumServer.stopAppiumServer();
    }

    public void quitDriver() {
        LogHelper.info("Close the driver");
        DriverUtils.quitDriver();
    }
}
