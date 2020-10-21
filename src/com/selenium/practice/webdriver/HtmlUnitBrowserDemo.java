package com.selenium.practice.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HtmlUnitBrowserDemo {

	public static void main(String[] args) {		
		
		// System.setProperty("webdriver.gecko.driver","D:\\testing-vikas\\drivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver","D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title:"+title);
		if(title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("In-Correct title");
		}
		//System.out.println(driver.getPageSource());
		driver.quit();
	}
	


}
