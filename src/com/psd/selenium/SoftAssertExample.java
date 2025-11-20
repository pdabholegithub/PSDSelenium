package com.psd.selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test
	public void softAssertTest() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("Step 1: Starting test");

		softAssert.assertEquals("Prasad", "Guruji", "Name Mismatch!"); // ❌ Fail but continue

		System.out.println("Step 2: This line WILL execute"); // Executes even after failure

		softAssert.assertTrue(false, "Boolean is false!"); // Another failure

		System.out.println("Step 3: Also executes");

		// Mandatory – Otherwise failures will not be shown
		softAssert.assertAll();
	}

}
