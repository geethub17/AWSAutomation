package com.ui.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ui.hooks.Hooks;
import org.openqa.selenium.edge.EdgeDriver;

public class SearchSteps {

    @Given("launch edge and search for text 1")
    public void search_text_one() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back one.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }

    @Given("launch edge and search for text 2")
    public void search_text_two() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back two.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }

    @Given("launch edge and search for text 3")
    public void search_text_three() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back three.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }

    @Given("launch edge and search for text 4")
    public void search_text_four() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back four.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }

    @Given("launch edge and search for text 5")
    public void search_text_five() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back five.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }

    @Given("launch edge and search for text 6")
    public void search_text_six() throws InterruptedException {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("hello automation! I'm back six.");
        System.out.printf("Title(%s) = %s%n", Thread.currentThread().getName(), driver.getTitle());
    }
}
