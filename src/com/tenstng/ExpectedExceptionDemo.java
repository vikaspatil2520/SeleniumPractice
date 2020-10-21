package com.tenstng;

import org.testng.annotations.Test;

public class ExpectedExceptionDemo {

	@Test(expectedExceptions=NumberFormatException.class)
	public void test() {
		String x="100X";
		int y = Integer.parseInt(x);
		System.out.println(y);
	}
}
