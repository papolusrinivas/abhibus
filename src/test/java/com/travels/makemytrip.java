package com.travels;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/flights/");
    }

    @Test
    public void login() throws Throwable {
        // Wait for the popup and close it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
            popup.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }

        // Select "From" city
        WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fromCity']")));
        fromBox.click();

        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        fromInput.sendKeys("Hyd");

        List<WebElement> fromSuggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.xpath("//ul[@role='listbox']//li[contains(@class, 'react-autosuggest__suggestion')]")
        ));

        System.out.println("From suggestions size: " + fromSuggestions.size());

        for (WebElement city : fromSuggestions) {
        	Thread.sleep(2000);
            if (city.getText().contains("Vijayawada Airport")) {
            	Thread.sleep(2000);
                city.click();
                break;
            }
        }

        // Select "To" city
        WebElement toBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='toCity']")));
        toBox.click();

        WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
        toInput.sendKeys("Bang");

        List<WebElement> toSuggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.xpath("//ul[@role='listbox']//li[contains(@class, 'react-autosuggest__suggestion')]")
        ));

        System.out.println("To suggestions size: " + toSuggestions.size());

        for (WebElement city : toSuggestions) {
            if (city.getText().contains("Bangkok")) {
            	Thread.sleep(2000);
                city.click();
                break;
            }
        }

       driver.findElement(By.xpath("//a[text()='Search']")).click();
    }
}
