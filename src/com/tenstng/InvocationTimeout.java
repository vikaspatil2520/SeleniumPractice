package com.tenstng;

import org.testng.annotations.Test;

public class InvocationTimeout {
	@Test(invocationTimeOut = 5)
	public void timeoutTest() {
		int i=1;
		while(i==1) {
			System.out.println(i);
		}
		
	}
}
