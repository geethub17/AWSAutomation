package com.ui.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.edge.EdgeDriver; // uncomment to use Edge
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @Before
    public void setUp() {
        System.out.printf(">> Starting scenario on thread %s%n", Thread.currentThread().getName());
//        ChromeOptions opts = new ChromeOptions();
        // comment out the next line if you want to see the browser windows
        // opts.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(); // Selenium Manager will download driver
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

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}
