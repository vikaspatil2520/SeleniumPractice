package com.tenstng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	//SoftAssert softAssert = new SoftAssert();

	@Test
	public void test1() {
		SoftAssert softAssert1 = new SoftAssert();
		System.out.println("stmt1");
		// softAssert.assertEquals(true, false,"assertion failed afetr stmt 1");
		softAssert1.assertEquals(true, false);
		System.out.println("stmt2");
		softAssert1.assertEquals(true, false);
		System.out.println("stmt3");
		System.out.println("stmt4");
		Assert.assertEquals(true, true);
		System.out.println("stmt5");
		softAssert1.assertAll();
	}

	@Test
	public void test2() {
		SoftAssert softAssert2 = new SoftAssert();
		System.out.println("test2 stmt1");
		softAssert2.assertEquals(true, true, "assertion failed afetr test2 stmt 1");
		System.out.println("test2 stmt2");
		Assert.assertEquals(true, true);
		System.out.println("stmt5");
		softAssert2.assertAll();
	}
}
