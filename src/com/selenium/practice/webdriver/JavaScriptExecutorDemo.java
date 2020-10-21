package com.selenium.practice.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
	
	private static JavascriptExecutor js = null;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");

		WebElement searchBtn = driver.findElement(By.xpath(".//input[@id='gh-btn']"));
		flash(searchBtn, driver);

		drawBorder(searchBtn, driver); // draw border around webelement

		// get screenshot & store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// now copy screenshot to desired location using copyfile method
		FileUtils.copyFile(src, new File("D:\\testing-workspace\\SeleniumPractice\\src\\screenshot\\ebay.png"));

		// alert
		// showAlert("Button is not working as per the requirement",driver);

		// click() using js
		clickElementByJs("gh-btn", driver);

		// refresh using js
		refreshBrowserByJs(driver);

		// get title of page using js
		System.out.println(getTitleByJS(driver));

		// get all text of webpage
		System.out.println(getPageInnerText(driver));

		// scroll down using js
		scrollPageDown(driver);

		// scroll till webelemnt visible
		WebElement aboutEbayLinkElement = driver.findElement(By.linkText("About eBay"));
		srollIntoView(driver, aboutEbayLinkElement);
		aboutEbayLinkElement.click();
		// driver.quit();
	}

	private static void srollIntoView(WebDriver driver, WebElement webElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);

	}

	private static void scrollPageDown(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	private static String getPageInnerText(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	private static String getTitleByJS(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();

	}

	private static void refreshBrowserByJs(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}

	private static void clickElementByJs(String id, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').click();");
	}

	public static void showAlert(String message, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	private static void drawBorder(WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
	}

	public static void flash(WebElement element, WebDriver driver) {

		String bgColor = element.getCssValue("background-color");
		for (int i = 0; i <= 2; i++) {
			changeColor("rgb(0,255,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
