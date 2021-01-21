package com.selenium.practice.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassPractice2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@id='u_0_2']")).click();
		Thread.sleep(5000);

		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
	//	WebElement year = driver.findElement(By.id("year"));

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
		//selectFromDropDown(month, dobArr[1]);
		//selectFromDropDown(year, dobArr[2]);
		//Thread.sleep(10000);
		
		//Print all months options
		Select select=new Select(month);
		System.out.println("is multiselect dropdown?:"+select.isMultiple());
		System.out.println("all options belonging to select tag");
		System.out.println("size:"+(select.getOptions().size()));		
		List<WebElement> options = select.getOptions();
		for(WebElement option:options) {
			System.out.println(option.getText());
			if(option.getText().equals(dobArr[1])) {
				select.selectByVisibleText(option.getText());
				break;
			}
		}
		
		//click using without Select class
		List<WebElement> yearList = driver.findElements(By.xpath("//select[@id='year']//option"));
		for(WebElement element:yearList) {
			if(element.getText().equals(dobArr[2])) {
				element.click();
			}
		}
		
		
		//driver.quit();

	}

	private static void selectFromDropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
