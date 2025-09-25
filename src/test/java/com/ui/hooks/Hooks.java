package com.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;
import java.net.URI;

public class Hooks {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    @Before
    public void setUp() throws MalformedURLException {
        System.out.printf(">> Starting scenario on thread %s%n", Thread.currentThread().getName());

        //Remote websriver - locally
      /*  WebDriver driver = new EdgeDriver(); // Selenium Manager will download driver
        DRIVER.set(driver);*/

        // Selenium grid with single container and local setup - but it fails as there will be no Selenium Grid running inside this container.
     /*   String browser = System.getProperty("browser");
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
        String browser = System.getProperty("browser");
        String hubURL = System.getenv("SELENIUM_HUB_URL");
        System.out.println("I am here... "+ hubURL);

        RemoteWebDriver driver;
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
        System.out.printf(">> Created session %s on thread %s%n", sessionId, Thread.currentThread().getName());
        DRIVER.set(driver);
    }

    @After
    public void tearDown() {
        WebDriver d = DRIVER.get();
        if (d != null) {
            d.quit();
            DRIVER.remove();
        }
    }
}
