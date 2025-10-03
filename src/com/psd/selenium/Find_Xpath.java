package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_Xpath {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.igfindia.org/");
		driver.manage().window().maximize();
		// WebElement e1 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/input[1]"));
		WebElement e1 = driver.findElement(By.xpath("//input[@id='whatsapp-fullname']"));
		e1.sendKeys("Test User");
		WebElement e2 = driver.findElement(By.xpath("//input[@id='whatsapp-mobile']"));
		e2.sendKeys("9998877755");
		WebElement e3 = driver.findElement(By.xpath("//button[@type='submit']"));
		e3.click();

		Thread.sleep(5000);

		driver.close();

	}

}
