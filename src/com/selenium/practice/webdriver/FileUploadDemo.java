package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\testing-vikas\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://html.com/input-type-file/");	
	driver.findElement(By.xpath("//input[@id=\"fileupload\"]")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@value=\"submit\"]")).click();
	//driver.quit();
	
}
}
