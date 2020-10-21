package com.selenium.practice.webdriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAndImagesDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Total links count:" + linksList.size());

		List<WebElement> activeLinksList = new ArrayList<>();

		for (WebElement webElement : linksList) {

			// System.out.println(webElement.getAttribute("href"));
			// exclude url's with href is null
			if (webElement.getAttribute("href") != null && (!webElement.getAttribute("href").contains("javascript"))) {
				activeLinksList.add(webElement);
			}
		}

		System.out.println("Active links count:" + activeLinksList.size());

		// check url is correct or not using HTTPConnection to open connection
		for (WebElement webElement : activeLinksList) {

			// System.out.println(webElement.getAttribute("href"));

			HttpURLConnection connection = (HttpURLConnection) new URL(webElement.getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			if (!response.equalsIgnoreCase("Ok")) {
				System.out.println(webElement.getAttribute("href") + "-->" + response);
			}

		}
	}

}
