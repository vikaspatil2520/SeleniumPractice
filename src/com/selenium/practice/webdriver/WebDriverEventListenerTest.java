package com.selenium.practice.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverEventListenerTest {

	public static void main(String[] args) {
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(driver);
		
		TrackChangesInApplication application=new TrackChangesInApplication();
		eventFiringWebDriver.register(application);

		eventFiringWebDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		eventFiringWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		eventFiringWebDriver.get("https://www.google.com/");
		eventFiringWebDriver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");

		List<WebElement> searchResultElementList = eventFiringWebDriver
				.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']"));
		System.out.println("no. of search result:" + searchResultElementList.size());

		for (WebElement webElement : searchResultElementList) {
			if (webElement.getText().contains("javatpoint")) {
				webElement.click();
				break;
			}
		}

	}
}
