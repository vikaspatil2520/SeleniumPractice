package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAdvanDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Its not recommended to implicit wait wait explicit wait together
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		WebElement userName = driver.findElement(By.id("login1"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password?"));

		sendKeys(driver, userName, 10, "vikaspatil12345");
		sendKeys(driver, password, 10, "vikas@123");
		clickOn(driver, forgotPassword, 10);

		Thread.sleep(20000); // static explicit wait
		
		//driver.quit();
	}

	//explicit wait
	private static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//explicit wait
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

}
