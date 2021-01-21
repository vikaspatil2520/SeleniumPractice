package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		By noOfEmp = By.id("Form_submitForm_NoOfEmployees");

		selectDropDownValue(industry,SelectOption.INDEX.toString(), "5");
		selectDropDownValue(country, SelectOption.VISIBLETEXT.toString(), "India");
		selectDropDownValue(noOfEmp, SelectOption.VALUE.toString(), "16 - 20");

		//Select select = new Select(driver.findElement(By.id("Form_submitForm_Industry")));
		//select.selectByIndex(5);
	}

	private static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	private static void selectDropDownValue(By element, String type, String value) {
		WebElement element2 = getElement(element);
		Select select = new Select(element2);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		default:
			System.out.println("wrong choice enterd for dropdown");
			break;
		}

	}

}
