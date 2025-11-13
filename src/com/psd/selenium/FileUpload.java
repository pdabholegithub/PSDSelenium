package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

	@Test()
	public void getchregidetails_twodimentional() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://grotechminds.com/registration/");
		driver.manage().window().maximize();
		driver.findElement(By.name("fname")).sendKeys("Prasad");
		driver.findElement(By.name("lname")).sendKeys("Patil");
		driver.findElement(By.name("email")).sendKeys("email@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.name("Present-Address")).sendKeys("Pune");
		driver.findElement(By.name("Permanent-Address")).sendKeys("Kolhapur");
		driver.findElement(By.name("Pincode")).sendKeys("416020");
		WebElement fileupload = driver.findElement(By.id("file"));
		fileupload.sendKeys("C:\\Users\\prasad.dabhole\\Downloads\\SETTLEMENT_UPLOAD_DONATION.csv");
		Thread.sleep(3000);

	}

}
