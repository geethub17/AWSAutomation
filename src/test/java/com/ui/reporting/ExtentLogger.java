package com.ui.reporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.MessageFormatter;

import java.util.concurrent.atomic.AtomicInteger;

public class ExtentLogger {

    private final Class<?> clazz;
    private final Logger log;

    // Thread-safe step counter
    private static final ThreadLocal<AtomicInteger> stepCounter =
            ThreadLocal.withInitial(() -> new AtomicInteger(1));

    private ExtentLogger(Class<?> clazz) {
        this.clazz = clazz;
        this.log = LogManager.getLogger(clazz);
    }

    public static ExtentLogger getLogger(Class<?> clazz) {
        return new ExtentLogger(clazz);
    }

    private String stepPrefix() {
        return "Step " + String.format("%02d", stepCounter.get().getAndIncrement()) + ": ";
    }

    private String format(String message, Object... args) {
        return MessageFormatter.arrayFormat(message, args).getMessage();
    }

    // ---------------------------
    // INFO
    // ---------------------------
    public void info(String message, Object... args) {
        String formatted = stepPrefix() + format(message, args);
        ExtentCucumberAdapter.addTestStepLog("ℹ️ " + formatted);
        log.info(formatted);
    }

    // ---------------------------
    // PASS
    // ---------------------------
    public void pass(String message, Object... args) {
        String formatted = stepPrefix() + format(message, args);
        ExtentCucumberAdapter.addTestStepLog("✔ " + formatted);
        log.info("[PASS] " + formatted);
    }

    // ---------------------------
    // WARN
    // ---------------------------
    public void warn(String message, Object... args) {
        String formatted = stepPrefix() + format(message, args);
        ExtentCucumberAdapter.addTestStepLog("⚠️ " + formatted);
        log.warn(formatted);
    }

    // ---------------------------
    // FAIL (with screenshot)
    // ---------------------------
    public void fail(String message, WebDriver driver, Object... args) {
        String formatted = stepPrefix() + format(message, args);
        log.error(formatted);

        try {
            String base64 = ((TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.BASE64);

            ExtentCucumberAdapter.addTestStepLog("❌ " + formatted);
            ExtentCucumberAdapter.getCurrentScenario().fail(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build()
            );

        } catch (Exception e) {
            ExtentCucumberAdapter.addTestStepLog("❌ " + formatted + " (Screenshot unavailable)");
            log.error("Screenshot capture failed", e);
        }
    }
}
