package com.psd.selenium;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.TimeoutException;

public class Amazon_Search_TwoDimentional2 {

	@DataProvider(name = "searchdetails")
	public Object[][] method1() {
		Object data[][] = new Object[5][1];
		// 1st row first test case
		data[0][0] = "Mens T shirts";
		// 2nd row second test case
		data[1][0] = "Womens Shoes";
		// 3rd row third test case
		data[2][0] = "Sandals";
		// 4th row fourth test case
		data[3][0] = "Hand Gloves";
		// 5th row fifth test case
		data[4][0] = "Headphones";
		return data;

	}

	@Test(dataProvider = "searchdetails")
	public void amazonsearch_twodimentional(String items) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type = 'submit']")));
			submitBtn.click();
			System.out.println("Submit button found and clicked.");
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Submit button not found, performing search directly...");
		}

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(items);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
