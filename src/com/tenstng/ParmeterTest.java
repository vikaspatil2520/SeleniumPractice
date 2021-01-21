package com.tenstng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParmeterTest {

	//run this file using 
	//right click on tetng.xml -> run as testng 
	@Test
	@Parameters({"url","username"})
	public void yahooTest(String url,String username) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
