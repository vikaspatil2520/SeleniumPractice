package com.tenstng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;

	public static void initilaization() {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	public  void faild(String methodName) {
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("D:\\testing-workspace\\SeleniumPractice\\src\\screenshot\\testfailedimg_"+this.getClass().getName()+"_"+methodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
