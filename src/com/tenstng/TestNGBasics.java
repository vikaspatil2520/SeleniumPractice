package com.tenstng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	@BeforeSuite
	public void setproperty() {
		System.out.println("@BeforeSuite--setproperty");
	}
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest--launchBrowser");
	}
	
	@BeforeClass
	public void loginMethod() {
		System.out.println("@BeforeClass--loginapp");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("@BeforeMethod--enter URL");
	}
	
	@Test
	public void titleTest() {
		System.out.println("@Test--google title test");
	}
	
	@Test
	public void logoTest() {
		System.out.println("@Test--logoTest");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("@AfterMethod--logOut");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass--closeBrowser");
	}
	
	@AfterTest
	public void deleteCookies() {
		System.out.println("@AfterTest--deleteCookies");
	}
	
	@AfterSuite
	public void reportGeneration() {
		System.out.println("@AfterSuite--reportGeneration");
	}
}
