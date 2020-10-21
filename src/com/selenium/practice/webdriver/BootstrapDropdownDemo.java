package com.selenium.practice.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdownDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li"));
		
//		//click on all checkboxes
//		for (WebElement ele : elements) {
//			//System.out.println(ele.getAttribute("class").equalsIgnoreCase("active"));
//			if (ele.getAttribute("class").equalsIgnoreCase("active")) {
//				System.out.println(ele.getText());
//			} else {
//				ele.click();
//			}
//		}
//		
		
		//check particular checkbox
		for (WebElement element : elements) {
			if(element.getText().equalsIgnoreCase("Angular")) {
				element.click();
			}
			
		}
		
		
		
		*/
		//div[@id="lang-chooser"]//div[2]//div//span[contains(text(),'‪euskara‬')]
		//div[@id='lang-chooser']
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		
		driver.findElement(By.xpath("//div[@id='lang-chooser']")).click();
		List<WebElement> langElementList = driver.findElements(By.xpath("//div[@id='lang-chooser']//div[2]//div//span"));
		
		//show all language
		System.out.println("show all language");
		for(WebElement webElement:langElementList) {
			try {
				if(webElement.getText().contains("Dansk")) {
					System.out.println(webElement.getText());
					webElement.click();
					break;
				}
				
			} catch (StaleElementReferenceException e) {
				driver.quit();
			}
			
			
		}
		
		
		
		
		
		
	}
}
