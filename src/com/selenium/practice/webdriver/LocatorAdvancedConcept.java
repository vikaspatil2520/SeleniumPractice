package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class LocatorAdvancedConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.facebook.com/");
		// driver.findElement(new
		// ByAll(By.id("email"),By.name("email1"),By.xpath("//input[@id='email']"))).sendKeys("naveenk");
		// driver.findElement(new ByIdOrName("email")).sendKeys("naveenk");;
		driver.findElement(new ByChained(By.className("_6lux"), By.xpath("//input[@id='email']"))).sendKeys("naveenk");
		Thread.sleep(2000);
		driver.quit();
	}

}
