package com.psd.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener_Logic.class)
public class TestCase1 extends Listener_Logic {
	@Test
	public void testcase1() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("p")).sendKeys("Jai Hind");
		driver.findElement(By.name("p")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
