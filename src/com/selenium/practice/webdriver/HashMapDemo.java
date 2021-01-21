package com.selenium.practice.webdriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		
		String credentialas = getCredentils().get("admin");

		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys(getUserName(credentialas));
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(getPassword(credentialas));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		driver.quit();

	}

	public static HashMap<String, String> getCredentils() {
		HashMap<String, String> useMap = new HashMap<String, String>();
		useMap.put("admin", "batchautomation:Test@12345");
		useMap.put("Manager", "manager:manager@123");
		useMap.put("seller", "seller:seller1#12");
		return useMap;
	}

	public static String getUserName(String credentials) {
		return credentials.split(":")[0];
	}

	public static String getPassword(String credentials) {
		return credentials.split(":")[1];
	}
}
