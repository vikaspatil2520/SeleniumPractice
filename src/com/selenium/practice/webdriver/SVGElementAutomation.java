package com.selenium.practice.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementAutomation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");

		// switch to frame
		driver.switchTo().frame("svg_result");
		
		
		while (true) {
			List<WebElement> elementList = driver.findElements(By.xpath(
					"//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"));

			for (WebElement element : elementList) {
				System.out.println(element.getAttribute("d"));
			}
		}

	}
}
