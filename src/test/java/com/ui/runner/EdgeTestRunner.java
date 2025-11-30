package com.ui.runner;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "browser", value = "edge")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, " +
                "json:target/edge/edge-report.json, " +
                "html:target/edge/edge-report.html, " +
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class EdgeTestRunner {
    static {
        System.setProperty("browser", "edge");
        // Override Extent XML dynamically
        System.setProperty("extent.reporter.spark.config", "spark-config-edge.xml");
        System.setProperty("extent.reporter.spark.out", "target/extent/edge/extent-edge.html");
    }
}
