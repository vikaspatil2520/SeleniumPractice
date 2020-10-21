package com.selenium.practice.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@name=\"proceed\"]")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		
		String textMsg = alert.getText();
		//accept alert
		alert.accept();
		
		System.out.println(textMsg);
		if(textMsg.equals("Please enter your password")) {
			System.out.println("testcase pass");
		}else {
			System.out.println("testcase pass");
		}
		
		
		//cancel alert
		//alert.dismiss();
		
		
		
		
		
		
		driver.quit();
	}

}
