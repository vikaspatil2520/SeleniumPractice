package com.tenstng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertDemoTest {
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
	@Test()
	public void googleTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
		Assert.assertEquals(title, "google","title is not correct");
	}
	
	@Test(priority=2)
	public void googleLogoTest() {
		boolean logoFlag = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertEquals(logoFlag, true);
		Assert.assertTrue(logoFlag);
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("After method called");
		driver.close();
	}
}
