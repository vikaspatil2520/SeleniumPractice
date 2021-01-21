package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@id='u_0_2']")).click();
		Thread.sleep(5000);

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		// Select selectDay=new Select(day);
		// selectDay.selectByVisibleText("4");
		//
		// Select selectMonth=new Select(month);
		// selectMonth.selectByVisibleText("Jun");
		//
		// Select selectYear=new Select(year);
		// selectYear.selectByVisibleText("1990");

		String dob="4-Jun-1990";
		String[] dobArr = dob.split("-");
		selectFromDropDown(day, dobArr[0]);
		selectFromDropDown(month, dobArr[1]);
		selectFromDropDown(year, dobArr[2]);
		Thread.sleep(10000);
		driver.quit();

	}

	private static void selectFromDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
