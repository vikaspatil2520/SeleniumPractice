package com.selenium.practice.webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		/*
		System.out.println("Set of open windows are:");
		for (String windowId : driver.getWindowHandles()) {
			System.out.println("window:"+windowId);
		}
		*/
		
		Set<String> windowIdSet = driver.getWindowHandles();
		Iterator<String> iterator = windowIdSet.iterator();
	
		Thread.sleep(2000);
		
		String parentWindowId = iterator.next();		
		String childWindowId = iterator.next();
		
		//switch from parent window to child window
		driver.switchTo().window(childWindowId);
		System.out.println("child window title:"+driver.getTitle());
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title:"+driver.getTitle());
		
		
	}

}
