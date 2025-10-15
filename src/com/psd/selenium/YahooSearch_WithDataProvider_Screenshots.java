package com.psd.selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YahooSearch_WithDataProvider_Screenshots extends Object {

	@DataProvider(name = "data1")
	public Object[][] method1() {
		return new Object[][] { { "Hindu" }, { "India" }, { "Maratha" } };
	}

	@Test(dataProvider = "data1")
	public void yahoosearch1(String input) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("p")).sendKeys(input);
		driver.findElement(By.name("p")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		TakesScreenshot sc = driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		// File destination = new
		// File("C:\\Users\\prasad.dabhole\\eclipse-workspace\\PSDSelenium\\screenshot\\photo"+Math.random()+".png");
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		File destination = new File("C:\\Users\\prasad.dabhole\\eclipse-workspace\\PSDSelenium\\screenshot\\"
				+ new YahooSearch_WithDataProvider_Screenshots().getClass() + timestamp + ".png");
		FileHandler.copy(source, destination);
		driver.quit();

	}

}
