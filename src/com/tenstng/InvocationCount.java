package com.tenstng;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount=10)
	public void sum() {
		int a=10;
		int b=20;
		System.out.println("sum="+(a+b));
	}
}
