package com.psd.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void hardAssertTest() {

		System.out.println("Step 1: Starting test");

		Assert.assertEquals("Prasad", "Guruji"); // ❌ This will FAIL

		System.out.println("Step 2: This line will NOT execute"); // Not executed
	}

}



