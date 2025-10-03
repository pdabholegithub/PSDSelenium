package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_DropdownHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.id("searchDropdownBox"));
		e1.sendKeys(Keys.ARROW_DOWN);
		e1.sendKeys(Keys.ARROW_DOWN);
		e1.sendKeys(Keys.ARROW_DOWN);
		e1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.close();

	}

}


