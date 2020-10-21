package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUsingJSDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		driver.get("https://www.spicejet.com/");
//		String dateVal="12-11-2020";
//		
//		WebElement dateElement = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1"));
		
		driver.get("https://jqueryui.com/datepicker/#dropdown-month-year");
		Thread.sleep(200);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Thread.sleep(200);
		WebElement dateElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
		Thread.sleep(200);
		String dateVal="12-11-2020";
		selectDateByJS(driver,dateElement,dateVal);
	}

	private static void selectDateByJS(WebDriver driver, WebElement dateElement, String dateVal) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", dateElement);
	}

}
