package com.psd.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YahooSearch_WithDataProvider {

	@DataProvider(name = "data1")
	public Object[][] method1() {
		return new Object[][] { { "Modi" }, { "Air Pollution" }, { "SRK" }, { "Ajay Devgan" }, { "Pune" } };
	}
	@DataProvider(name = "data2, parallel = true")
	public Object[][] method2() {
		return new Object[][] { { "11" }, { "999" }, { "888" }, { "333" }, { "899" } };
	}
	@Test(dataProvider = "data1")
	public void yahoosearch1(String input) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("p")).sendKeys(input);
		driver.findElement(By.name("p")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();

	}


	/*
	 * @Test(dataProvider = "data2") public void yahoosearch2(String input) throws
	 * InterruptedException { ChromeDriver driver = new ChromeDriver();
	 * driver.get("https://www.yahoo.co.in/"); driver.manage().window().maximize();
	 * driver.findElement(By.name("p")).sendKeys(input);
	 * driver.findElement(By.name("p")).sendKeys(Keys.ENTER); Thread.sleep(2000);
	 * driver.quit();
	 * 
	 * }
	 */

}
