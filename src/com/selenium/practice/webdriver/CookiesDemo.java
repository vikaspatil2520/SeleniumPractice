package com.selenium.practice.webdriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDemo {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",  "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("http://www.google.com");
		
		driver.get("https://www.quora.com/");
		
		//driver.manage().deleteAllCookies();
		
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies) {
			System.out.println("____________"+cookie.getName()+"___________");
			System.out.println(cookie.getDomain());
			System.out.println(cookie.isSecure());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getExpiry());
		}
		
		driver.quit();
	}
}
