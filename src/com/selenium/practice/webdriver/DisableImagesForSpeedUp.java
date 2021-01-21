package com.selenium.practice.webdriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImagesForSpeedUp {
	public static WebDriver driver;
	
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		disableImagesChrome(options);
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\testing-vikas\\drivers\\geckodriver.exe");
		FirefoxOptions firefoxOptions=new FirefoxOptions();
		disableImagesFirefox(firefoxOptions);
		driver=new FirefoxDriver(firefoxOptions);
		driver.get("https://www.amazon.com");
		
	}

	private static void disableImagesChrome(ChromeOptions options) {
		HashMap< String, Object> imageMap=new HashMap<>();
		imageMap.put("images", 2); //for enable 1 and for disable 2
		HashMap<String, Object> prefs=new HashMap<>();
		prefs.put("profile.default_content_setting_values", imageMap);
		options.setExperimentalOption("prefs", prefs);
	}
	
	private static void disableImagesFirefox(FirefoxOptions options) {
		FirefoxProfile firefoxProfile =new FirefoxProfile();
		firefoxProfile.setPreference("permissions.default.image", 2);
		options.setProfile(firefoxProfile);
		options.setCapability(FirefoxDriver.PROFILE,firefoxProfile);
	}
}
