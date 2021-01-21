package com.selenium.practice.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadless {
	public static void main(String[] args) {
		FirefoxBinary firefoxBinary=new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		System.setProperty("webdriver.gecko.driver", "D:\\testing-vikas\\drivers\\geckodriver.exe");
		
		
		FirefoxOptions firefoxOptions=new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://classic.freecrm.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
