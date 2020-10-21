package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	private static JavascriptExecutor js = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.get("http://demo.guru99.com/test/web-table-element.php");
//
//		
//		//method 1 using iterate for loop
//		
//		
//		// find no. of columns
//		List<WebElement> colHead = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
//		System.out.println("no. of columns are:" + colHead.size());
//
//		// find no. of columns
//		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
//		System.out.println("no. of rows are:" + rows.size());
//	
//		//*[@id="leftcontainer"]/table/tbody/tr[6]/td[1]/a
//		
//		
//		//retrive all text from first row
//		String before_xpath="//*[@id='leftcontainer']/table/tbody/tr[";
//		String after_xpath="]/td[1]";
//		
//		for(int i=1;i<=rows.size();i++) {
//			WebElement companyElement = driver.findElement(By.xpath(before_xpath+i+after_xpath));
//			if(companyElement.getText().contains("IDFC")) {
//				System.out.println("current share price of YES Bank:"+driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[4]")).getText());
//			}
//			
//			System.out.println(companyElement.getText());
//		}
//		
		
		//method 2
		
		driver.get("https://www.moneycontrol.com/india/stockpricequote/printingstationery/graphiccharts/GC13");
		scrollPageDown(driver);
		System.out.println("Net Profit Qtr:"+driver.findElement(By.xpath("//*[contains(text(),'Gensol Engineer')]/parent::td//following-sibling::td[7]")).getText());
	}

	
	private static void scrollPageDown(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
