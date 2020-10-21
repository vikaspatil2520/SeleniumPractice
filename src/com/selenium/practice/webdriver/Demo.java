package com.selenium.practice.webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://cookbook.seleniumacademy.com/html5video.html");
		
		 // Get the HTML5 Video Element
	   // WebElement videoPlayer = driver.findElement(By.id("vplayer"));
	    
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    
	    jsExecutor.executeScript("driver.findElement(By.id(\"vplayer\").play()");
/*
	    // We will need a JavaScript Executor for interacting with Video
	    // Element's methods and properties for automation
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	    // Get the Source of Video that will be played in Video Player
	    String source = (String) jsExecutor.executeScript(
	        "return arguments[0].currentSrc;", videoPlayer);
	    // Get the Duration of Video
	    long duration = (Long) jsExecutor.executeScript(
	        "return arguments[0].duration", videoPlayer);

	    // Verify Correct Video is loaded and duration
	    assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
	    assertEquals(25, duration);

	    // Play the Video
	    jsExecutor.executeScript("return arguments[0].play()", videoPlayer);

	    Thread.sleep(5000);

	    // Pause the video
	    jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

	    // Take a screenshot for later verification
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("target/screenshots/pause_play.png"));*/
	}
	
}
