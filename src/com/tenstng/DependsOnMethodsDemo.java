package com.tenstng;

import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
	@Test(priority=2)
	public void googleLogoTest() {		
		System.out.println("googleLogoTest");
	}
	
	@Test(dependsOnMethods="googleLogoTest",groups="sampleTestGroup")
	public void sampleTest1() {
		System.out.println("sampleTest1");
	}
	
	@Test(dependsOnMethods="googleLogoTest",groups="sampleTestGroup")
	public void sampleTest2() {
		System.out.println("sampleTest2");
	}
}
