package com.travels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Duplication;

public class abhibus {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.abhibus.com/");
	
	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void login() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	WebElement frombox=driver.findElement(By.xpath(("//input[@placeholder='From Station']")));
	frombox.sendKeys("hyd");
	
	frombox.sendKeys(Keys.ARROW_DOWN);
	frombox.sendKeys(Keys.ENTER);
Thread.sleep(5000);
	driver.findElement(By.xpath(("//input[@placeholder='To Station']"))).sendKeys("Ganapavaram");
	Thread.sleep(5000);
	driver.findElement(By.xpath(("//input[@placeholder='To Station']"))).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath(("//input[@placeholder='To Station']"))).sendKeys(Keys.ENTER);
	
	driver.findElement(By.xpath(("(//div[contains(@class,'input-prefix col')])[3]"))).click();
	
	driver.findElement(By.xpath(("//span[@data-date='11']"))).click();
	driver.findElement(By.xpath(("//button[text()='Search']"))).click();
	//driver.close();
	
	
	
	}
	

}
