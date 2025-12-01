package com.ui.pages;

import com.ui.reporting.ExtentLogger;
import com.ui.steps.SearchSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BingSearchPage {
    private static final ExtentLogger logger = ExtentLogger.getLogger(BingSearchPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox = By.xpath("//textarea[@id='sb_form_q']");

    public BingSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openHomePage() {
        logger.info("Navigating to Bing home page");
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        logger.info("Bing home page loaded successfully");
    }

    public void searchFor(String text) {
        logger.info("Searching for: {}", text);
        driver.findElement(searchBox).sendKeys(text);
    }
}
