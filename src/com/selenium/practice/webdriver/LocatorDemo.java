package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorDemo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\testing-vikas\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/test/newtours/index.php");
	
	

	
	//4.linkText	
	driver.findElement(By.linkText("REGISTER")).click();
	
	
	
	//1.xpath
	driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Shree");
	driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Patil");
	driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("1234567890");
	
	//2 id
	driver.findElement(By.id("userName")).sendKeys("Shree123");

	//3. name
	driver.findElement(By.name("address1")).sendKeys("Narhe");
	driver.findElement(By.name("city")).sendKeys("Pune");
	driver.findElement(By.name("state")).sendKeys("MH");
	driver.findElement(By.name("postalCode")).sendKeys("123456");
	
	
	//Select
	Select selectCity=new Select(driver.findElement(By.name("country")));
	selectCity.selectByVisibleText("CANADA");
	
	driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shree@gmail.com");
	driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Shree#123");
	driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]")).sendKeys("Shree#123");
	
	//click on button
	driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
	
	//4.linkText	
	driver.findElement(By.partialLinkText("sign")).click();
		
	driver.findElement(By.xpath("//*[@id=\"closeBtn\"]")).click();
	driver.quit();
	
	
	
}
}
