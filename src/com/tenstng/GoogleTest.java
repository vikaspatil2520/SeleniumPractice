package com.tenstng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test(priority=1,groups="TitleTest")
	public void googleTitleTest() {
		String title = driver.getTitle();
	//	int a=10/0;
		System.out.println("title:"+title);
	}
	
	@Test(priority=2)
	public void googleLogoTest() {
		boolean logoFlag = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println("logoFlag:"+logoFlag);
	}
	
	@Test(dependsOnMethods="googleTitleTest",groups="sampleTestGroup")
	public void sampleTest1() {
		System.out.println("sampleTest1");
	}
	
	@Test(dependsOnMethods="googleTitleTest",groups="sampleTestGroup")
	public void sampleTest2() {
		System.out.println("sampleTest2");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
