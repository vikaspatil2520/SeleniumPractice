package com.tenstng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenShotDemo extends Base {

	@BeforeMethod
	public void setup() {
		Base.initilaization();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void screenshottest1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void screenshottest2() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void screenshottest3() {
		Assert.assertEquals(false, true);
	}
}
