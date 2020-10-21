package com.selenium.practice.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DatePickerDemo {
	public static void main(String[] args) throws InterruptedException {
		String dot = "10/June/2020";
		String date, month, year;
		String caldt, calmonth, calyear;
		/*
		 * Spliting the String into String Array
		 */
		String dateArray[] = dot.split("/");
		date = dateArray[0];
		month = dateArray[1];
		year = dateArray[2];

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	/*	// Launch the Website
		driver.get("http://cleartrip.com");
		driver.findElement(By.id("DepartDate")).click();*/
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("DepartDate"))).click().build().perform();
		
		WebElement cal;
		cal = driver.findElement(By.className("calendar"));
		calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		/**
		 * Select the year
		 */
		while (!calyear.equals(year)) {
			driver.findElement(By.className("nextMonth")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println("The Displayed Year::" + calyear);
		}

		calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		/**
		 * Select the Month
		 */
		while (!calmonth.equalsIgnoreCase(month)) {
			driver.findElement(By.className("nextMonth ")).click();
			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		cal = driver.findElement(By.className("calendar"));
		/**
		 * Select the Date
		 */
		List<WebElement> rows, cols;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int k = 0; k < cols.size(); k++) {
				caldt = cols.get(k).getText();
				if (caldt.equals(date)) {
					cols.get(k).click();
					break;
				}
			}
		}

	}
}
