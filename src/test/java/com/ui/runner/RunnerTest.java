package com.ui.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "extent.reporter.spark.start", value = "true")
@ConfigurationParameter(key = "extent.reporter.spark.out", value = "target/extent/edge/extent-edge.html")
@ConfigurationParameter(key = "extent.reporter.spark.config", value = "spark-config-edge.xml")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value =
                "pretty, " +
                        "json:target/edge/edge-report.json, " +
                        "html:target/edge/edge-report.html, " +
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class RunnerTest {
    static {
        System.setProperty("browser", "edge");
    }
}


