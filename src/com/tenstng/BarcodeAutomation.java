//package com.tenstng;
//
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import javax.imageio.ImageIO;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class BarcodeAutomation {
//
//	public void barcodeTest() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.get("https://barcode.tec-it.com/en/?");
//		
//		String barcodeURL=driver.findElement(By.tagName("img")).getAttribute("src");
//		System.out.println(barcodeURL);
//		
//		URL url=new URL(barcodeURL);
//		BufferedImage bufferedImage = ImageIO.read(url);
//	   // BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
//	    
//		
//		
//	}
//}
