package com.ui.steps;

import com.ui.pages.BingSearchPage;
import com.ui.reporting.ExtentLogger;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private static final ExtentLogger logger = ExtentLogger.getLogger(SearchSteps.class);
    private WebDriver driver;
    private BingSearchPage bingPage;

    @Given("launch driver and search for text {int}")
    public void launchDriverAndSearchFor(int text) {
        driver = com.ui.base.DriverManager.getDriver();
        String searchText = "hello automation! I'm back " + text;
        logger.info("Executing search test on browser with text [{}]", text);

        bingPage = new BingSearchPage(driver);
        bingPage.openHomePage();
        bingPage.searchFor(searchText);

        logger.info("Page title after search: {}", driver.getTitle());
    }

    @Given("launch driver and search for text failed")
    public void launchDriverAndCaptureScreenshot() {
        driver = com.ui.base.DriverManager.getDriver();
        logger.info("Ready to capture screenshot");

        bingPage = new BingSearchPage(driver);
        bingPage.openHomePage();
        bingPage.searchFor("Cheeseee");
        logger.info("Searched for Cheeseee");
        logger.fail("Captured screenshot for Cheeseee", driver);
    }
}
