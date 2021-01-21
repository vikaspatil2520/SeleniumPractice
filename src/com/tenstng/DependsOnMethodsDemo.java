package com.tenstng;

import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
	@Test(priority=2)
	public void googleLogoTest() {		
		System.out.println("googleLogoTest");
	}
	
	@Test(dependsOnMethods="googleLogoTest",groups="sampleTestGroup",priority=3)
	public void sampleTest1() {
		System.out.println("sampleTest1");
	}
	
	@Test(dependsOnMethods="googleLogoTest",groups="sampleTestGroup",priority=1)
	public void sampleTest2() {
		System.out.println("sampleTest2");
	}
}
