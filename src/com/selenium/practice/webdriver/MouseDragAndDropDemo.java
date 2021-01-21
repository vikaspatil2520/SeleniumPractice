package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDropDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		Actions actions = new Actions(driver);
		
		/*
		actions.clickAndHold(driver.findElement(By.xpath(".//div[@id='draggable']")))
		       .moveToElement(driver.findElement(By.xpath(".//div[@id='droppable']")))
		       .build()
		       .perform();
		*/
		actions.dragAndDrop(driver.findElement(By.xpath(".//div[@id='draggable']")), driver.findElement(By.xpath(".//div[@id='droppable']")))
		       .build()
		       .perform();
	
	}
}
