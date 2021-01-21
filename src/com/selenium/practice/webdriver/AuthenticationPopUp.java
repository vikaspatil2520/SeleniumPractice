package com.selenium.practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.cssSelector("p")).getText());

	}
}
