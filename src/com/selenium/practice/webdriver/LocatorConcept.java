package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/");
			
		
	/*	//1.id
		driver.findElement(By.id("login-username")).sendKeys("testadmin@yahoo.com");
		driver.findElement(By.id("login-signin")).click();*/
		
		//2.name
//		driver.findElement(By.name("username")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.name("signin")).click();
		
		//3. xpath
//		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
//		
		//4.cssSelector
//		driver.findElement(By.cssSelector("#login-username")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.cssSelector("#login-signin")).click();
		
		//5. linktext
	//	driver.findElement(By.linkText("Forgot username?")).click();
		
		//6. partial linktext -- not recommended
//		driver.findElement(By.partialLinkText("Forgot")).click();
		
		//7. class name  --not recommended
//		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.className("pure-button puree-button-primary challenge-button")).click();
		
		// click on URL using xpath
		driver.findElement(By.xpath("//a[@id='mbr-forgot-link']")).click();
		
		
		Thread.sleep(2000);
		driver.quit();
	}
}
