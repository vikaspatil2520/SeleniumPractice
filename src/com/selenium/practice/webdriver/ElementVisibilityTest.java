package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\testing-vikas\\drivers\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://reg.ebay.com/reg/PartialReg");

		// check button is displayed or not on a webpage.
		boolean isButtonDisplayed = driver.findElement(By.xpath("//button[@id='EMAIL_REG_FORM_SUBMIT']")).isDisplayed();
		System.out.println("is submit button is displayed on webpage?:" + isButtonDisplayed);

		if (isButtonDisplayed) {
			// if button is available then check it's status
			boolean isButtonEnabled = driver.findElement(By.xpath("//button[@id='EMAIL_REG_FORM_SUBMIT']")).isEnabled();
			System.out.println("submit button status befor filling info:" + isButtonEnabled);
		}
		driver.get("https://reg.ebay.com/reg/PartialReg");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("pqr");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abcpqr@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Apple@123");

		Thread.sleep(2000);

		boolean isButtonEnabled1 = driver.findElement(By.cssSelector("#EMAIL_REG_FORM_SUBMIT")).isEnabled();
		System.out.println("submit button status after filling info:" + isButtonEnabled1);

	}

}
