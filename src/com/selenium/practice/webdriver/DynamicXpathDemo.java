package com.selenium.practice.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
		driver.get("https://www.facebook.com/");
		
	//	driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("mobile");
	//	driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("mobile");
		
		//driver.findElement(By.xpath("//button[@id='u_0_b']")).click();
	//	driver.findElement(By.xpath("//input[starts-with(@id,'gh-btn')]")).click();
		
		
	//find number of links
		
		List<WebElement> urlWebElementList = driver.findElements(By.tagName("a"));
		
		System.out.println("number of links:"+urlWebElementList.size());
		
		for(WebElement element:urlWebElementList) {
			System.out.println(element.getText());
		}
		
		//driver.close();

	}

}
