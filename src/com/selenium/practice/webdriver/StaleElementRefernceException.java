package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefernceException {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");
		
		//use breakpoint for StaleElementRefernceException
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("batchautomation");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test@12345");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.quit();
	}
}
