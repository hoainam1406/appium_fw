package com.demo.elements;

import com.demo.driver.DriverUtils;
import com.demo.helpers.LogHelper;
import com.demo.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementBase {

    private AppiumDriver<MobileElement> getDriver() {
        return DriverUtils.getDriver();
    }

    protected MobileElement getElement(By by) {
        return getDriver().findElement(by);
    }

    protected List<MobileElement> getElements(By by) {
        return getDriver().findElements(by);
    }

    protected void click(By by) {
        getElement(by).click();
    }

    protected void enter(By by, String value) {
        getElement(by).sendKeys(value);
    }

    protected String getText(By by) {
        waitForElementToBeClickable(by);
        return getElement(by).getText();
    }

    public boolean isVisible(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        return wait.until(ExpectedConditions.elementToBeClickable(by)) != null;
    }

    public boolean isVisible(By by) {
        return isVisible(by, Constants.MEDIUM_WAIT);
    }

    protected void waitForElementToBeClickable(By by, int timeOut) {
        try {
            LogHelper.info(String.format("Wait for clickable of %s", by.toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            LogHelper.error(String.format("waitForElementToBeClickable: Has error with control '%s': %s", by.toString(), e.getMessage().split("\n")[0]));
        }
    }

    protected void waitForElementToBeClickable(By by) {
        waitForElementToBeClickable(by, Constants.MEDIUM_WAIT);
    }

    protected void waitForElementVisibility(By by, int timeOut) {
        try {
            LogHelper.info(String.format("Wait for visibility of %s", by.toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            LogHelper.error(String.format("waitForElementVisibility: Has error with control '%s': %s", by.toString(), e.getMessage().split("\n")[0]));
        }
    }

    protected void waitForElementVisibility(By by) {
        waitForElementVisibility(by, Constants.MEDIUM_WAIT);
    }

}
