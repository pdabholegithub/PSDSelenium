package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Gmail_Double_RightClick {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.linkText("Gmail"));
		Actions a1 = new Actions(driver);
		Thread.sleep(3000);
		// a1.doubleClick(e1).perform();
		a1.contextClick(e1).perform();
		Thread.sleep(5000);
		driver.quit();

	}

}
