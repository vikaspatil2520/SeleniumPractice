package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		Actions actions = new Actions(driver);
//		
//		driver.get("https://demoqa.com/menu");
//		
//		actions.moveToElement(driver.findElement(By.xpath(".//a[contains(text(),'Main Item 2')]"))).build().perform();
//		actions.moveToElement(driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST »')]"))).build().perform();
//		
//	
//         driver.findElement(By.xpath(".//a[contains(text(),'Sub Sub Item 2')]")).click();
      
		
		// SpiceMAX 
//         driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
//         actions.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
//         Thread.sleep(3000);
//         driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Courses']")).click();
//         driver.quit();
         
         //mouse right click
         driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
         WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));
         actions.contextClick(rightClickButton).build().perform();
         driver.findElement(By.cssSelector(".context-menu-icon-copy")).click();
         Thread.sleep(2000);
         driver.quit();
         
	}
}
