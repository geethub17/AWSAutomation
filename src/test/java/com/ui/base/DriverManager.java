package com.ui.base;

import com.ui.reporting.ExtentLogger;
import com.ui.steps.SearchSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ExtentLogger logger = ExtentLogger.getLogger(DriverManager.class);

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        logger.info(">> Starting scenario on thread {}", Thread.currentThread().getName());
        logger.info(">> Starting scenario '{}' on thread {}", scenario.getName(), Thread.currentThread().getName());

        //Locally
        WebDriver driver = new EdgeDriver();
        DRIVER.set(driver);
        ThreadContext.put("browser", System.getProperty("browser"));

        /* Selenium grid with single container and local setup -
        but it fails as there will be no Selenium Grid running.
        */
        /*String browser = System.getProperty("browser");
        RemoteWebDriver driver;
        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    options
            );
        } else {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    options
            );
        }*/

        //Selenium grid with multiple containers
        /*String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            browser = System.getenv("BROWSER");
        }
        ThreadContext.put("browser", browser);

        String hubURL = System.getenv("SELENIUM_HUB_URL");
        logger.debug("Connecting to Selenium Hub at: {}", hubURL);

        RemoteWebDriver driver;
        logger.info("Browser from System.getProperty: {}", browser);
        logger.info("Hub URL from System.getenv: {}", hubURL);

        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(
                    URI.create(hubURL).toURL(),
                    options
            );
        } else {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(
                    URI.create(hubURL).toURL(),
                    options
            );
        }

        // Log session details
        SessionId sessionId = driver.getSessionId();
        logger.info(">> Created session {} on thread {}", sessionId, Thread.currentThread().getName());
        DRIVER.set(driver);*/
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver d = DRIVER.get();
        if (d != null) {
            logger.info("<< Closing browser for scenario '{}'", scenario.getName());
            d.quit();
            DRIVER.remove();
        }
        ThreadContext.clearAll();
    }
}
