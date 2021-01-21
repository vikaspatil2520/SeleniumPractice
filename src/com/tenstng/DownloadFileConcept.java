package com.tenstng;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileConcept {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setup() {

		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//chrome
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		ChromeOptions chromeOptions=new ChromeOptions();
		
		Map<String,Object> prefs=new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups",0);
		prefs.put("download.default_directory",folder.getAbsolutePath());
		
		chromeOptions.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		driver=new ChromeDriver();
		
	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("nature.jpg")).click();
		
		//wait for 2 seconds to download file
		Thread.sleep(3000);
		File[] listOfFiles = folder.listFiles();
		
		//make sure directory is not empty
		Assert.assertTrue(listOfFiles.length>0);
		
		//make sure downloaded file size > 0 bytes		
		for(File file:listOfFiles) {
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
		//delete all files after test case executed
		for(File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
}
