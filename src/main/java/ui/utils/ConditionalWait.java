package ui.utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ConditionalWait {
    private static Duration waitDuration = AqualityServices.getConfiguration().getTimeoutConfiguration().getCondition();

    public static void waitUntilClickable(By locator) {
        AqualityServices.getConditionalWait().waitFor(ExpectedConditions.elementToBeClickable(locator), waitDuration);
    }

    public static void waitUntilPresented(By locator) {
        AqualityServices.getConditionalWait().waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator), waitDuration);
    }
}