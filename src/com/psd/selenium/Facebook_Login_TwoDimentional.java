package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Facebook_Login_TwoDimentional {

	@DataProvider(name = "logindetails")
	public Object[][] method1() {
		Object data[][] = new Object[5][2];
		// 1st row first test case
		data[0][0] = ""; // Null UN
		data[0][1] = ""; // Null Pwd
		// 2nd row second test case
		data[1][0] = "stbymkt@gmail.com"; // Valid UN
		data[1][1] = "stbym123"; // Valid Pwd
		// 3rd row third test case
		data[2][0] = "stbymkt@gmail.com"; // Valid UN
		data[2][1] = "stbym"; // Invalid Pwd
		// 4th row fourth test case
		data[3][0] = "stbymkt@mail.com"; // Invalid UN
		data[3][1] = "stbym123"; // Valid Pwd
		// 5th row fifth test case
		data[4][0] = "stbymkt@gmil.com"; // Invalid UN
		data[4][1] = "stbym1"; // Invalid Pwd
		return data;

	}

	@Test(dataProvider = "logindetails")
	public void fblogin_twodimentional(String username, String password) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
