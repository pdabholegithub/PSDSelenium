package com.psd.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassOne {
	
	@Test
	public void testcase1()
	{
		Assert.assertEquals(false, false);
	}

}
