package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Control_Enable_Disabled {

	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("file:///C:/Users/prasad.dabhole/Downloads/psd.html");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.id("txtEnabled"));
		boolean b1 = e1.isDisplayed();
		boolean b2 = e1.isEnabled();
		if (b1 == true && b2 == true) {
			e1.clear();
			e1.sendKeys("Hello Prasad");

		}
		WebElement e2 = driver.findElement(By.id("txtDisabled"));
		System.out.println(e2.isDisplayed());
		System.out.println(e2.isEnabled());
		Thread.sleep(3000);
		driver.close();

	}

}
