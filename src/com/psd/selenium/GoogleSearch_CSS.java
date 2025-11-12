package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch_CSS {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys("Jay Hind");
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys(Keys.ENTER);

	}

}



