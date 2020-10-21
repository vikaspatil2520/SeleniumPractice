package com.selenium.practice.webdriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
		driver.get("https://www.ebay.com/");
		
		//get screenshot & store as a file format
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//now copy screenshot to desired location using copyfile method
		FileUtils.copyFile(src,new File("D:\\testing-workspace\\SeleniumPractice\\src\\screenshot\\ebay.png"));

	}

}
