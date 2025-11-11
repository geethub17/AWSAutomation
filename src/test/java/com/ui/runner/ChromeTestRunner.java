package com.ui.runner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // path inside src/test/resources
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.ui.steps,com.ui.hooks")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
public class RunnerTest {
    // empty — annotations do the work
}

