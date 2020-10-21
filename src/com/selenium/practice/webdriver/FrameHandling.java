package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		//switch to another frame
		driver.switchTo().frame("a077aa5e");
		
		//if without switching then its shows no such element: Unable to locate element: {"method":"xpath","selector":"//img[@src="Jmeter720.png"]"}
		driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]")).click();
		
		
		//switch to parent frame
		driver.switchTo().defaultContent();
		
		//more than one webelements having same xpath the use indexing (//img[@src=\"images/app_google_play(1).png\"])[1] 
		driver.findElement(By.xpath("(//img[@src=\"images/app_google_play(1).png\"])[1]")).click();
		
		driver.quit();
	}
}
