package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/datepicker/#dropdown-month-year");
		Thread.sleep(200);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		Thread.sleep(200);

		String date = "04-Mar-2024";
		String[] dateArr = date.split("-");
		final int noOfDaysInWeek = 7; 
		String day = Integer.valueOf(dateArr[0]).toString();
		String month = dateArr[1];
		String year = Integer.valueOf(dateArr[2]).toString();
		System.out.println(day + ":" + month + ":" + year);

		Select selectYear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
		selectYear.selectByVisibleText(year);

		Select selectMonth = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
		selectMonth.selectByVisibleText(month);

		boolean dayFlag = false;
		WebElement dayElement = null;
		for (int row = 1; row <= 7; row++) {

			for (int column = 1; column <= noOfDaysInWeek; column++) {

				try {
					dayElement = driver.findElement(
							By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[" + row + "]/td[" + column + "]"));
					
				} catch (NoSuchElementException e) {
				 System.out.println("Enter correct date");
				 dayFlag=true;
					break;
				}
				
				String celtext = dayElement.getText();
				if (celtext.equals(day)) {
					dayElement.click();
					dayFlag=true;
					break;
				}
			}
			if(dayFlag) {
				break;
			}

		}
	}
}