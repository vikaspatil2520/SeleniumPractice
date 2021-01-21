package com.selenium.practice.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteWebTableValueIntoExcel {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		
		String xpathPart1="//table[@id='customers']/tbody/tr[";
		String xpathPart2="]/td[";
		String xpathPart3="]";
		
		//count no. of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		
		for(int row=2;row<=rows.size();row++) {
			for(int col=1;col<=3;col++) {
				String actualXpath=xpathPart1+row+xpathPart2+col+xpathPart3;
				String text = driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println(text);
			}
		}
		

	}

}
