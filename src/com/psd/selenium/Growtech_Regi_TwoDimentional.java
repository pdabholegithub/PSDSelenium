package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Growtech_Regi_TwoDimentional {
	@DataProvider(name = "gtechregidetails")
	public Object[][] method1() {
		Object data[][] = new Object[5][7];
		// 1st row first test case
		data[0][0] = "Prasad1";
		data[0][1] = "Dabhole1";
		data[0][2] = "psd1@gmail.com";
		data[0][3] = "Pwd@1";
		data[0][4] = "Pune1";
		data[0][5] = "Kolhapur1";
		data[0][6] = "412001";

		// 2nd row second test case
		data[1][0] = "Prasad2";
		data[1][1] = "Dabhole2";
		data[1][2] = "psd2@gmail.com";
		data[1][3] = "Pwd@2";
		data[1][4] = "Pune2";
		data[1][5] = "Kolhapur2";
		data[1][6] = "412002";
		// 3rd row third test case
		data[2][0] = "Prasad3";
		data[2][1] = "Dabhole3";
		data[2][2] = "psd3@gmail.com";
		data[2][3] = "Pwd@3";
		data[2][4] = "Pune3";
		data[2][5] = "Kolhapur3";
		data[2][6] = "412003";
		// 4th row fourth test case
		data[3][0] = "Prasad4";
		data[3][1] = "Dabhole4";
		data[3][2] = "psd4@gmail.com";
		data[3][3] = "Pwd@4";
		data[3][4] = "Pune4";
		data[3][5] = "Kolhapur4";
		data[3][6] = "412004";
		// 5th row fifth test case
		data[4][0] = "Prasad5";
		data[4][1] = "Dabhole5";
		data[4][2] = "psd5@gmail.com";
		data[4][3] = "Pwd@5";
		data[4][4] = "Pune5";
		data[4][5] = "Kolhapur5";
		data[4][6] = "412005";
		return data;

	}

	@Test(dataProvider = "gtechregidetails")
	public void getchregidetails_twodimentional(String firstname, String lastname, String email, String password, String present_address, String permant_address, String pincode ) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://grotechminds.com/registration/");
		driver.manage().window().maximize();
		driver.findElement(By.name("fname")).sendKeys(firstname);
		driver.findElement(By.name("lname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("Present-Address")).sendKeys(present_address);
		driver.findElement(By.name("Permanent-Address")).sendKeys(permant_address);
		driver.findElement(By.name("Pincode")).sendKeys(pincode);
		Thread.sleep(3000);
		driver.quit();

	}

}
