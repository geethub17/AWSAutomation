package com.ui.runner;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "browser", value = "chrome")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, " +
                "json:target/chrome/chrome-report.json, " +
                "html:target/chrome/chrome-report.html, " +
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class ChromeTestRunner {
    static {
        System.setProperty("browser", "chrome");
        System.setProperty("extent.reporter.spark.config", "spark-config-chrome.xml");
        System.setProperty("extent.reporter.spark.out", "target/extent/chrome/extent-chrome.html");
    }
}
