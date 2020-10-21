package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/menu");
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath(".//a[contains(text(),'Main Item 2')]"))).build().perform();
		actions.moveToElement(driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST »')]"))).build().perform();
		
	
         driver.findElement(By.xpath(".//a[contains(text(),'Sub Sub Item 2')]")).click();
       // SpiceMAX 
	}
}
