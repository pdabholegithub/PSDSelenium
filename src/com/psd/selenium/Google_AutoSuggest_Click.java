package com.psd.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Google_AutoSuggest_Click {

	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.name("q"));
		e1.sendKeys("Mumbai");
		Thread.sleep(2000);
		// 2 attribute back for x path in case of auto suggestion
		List<WebElement> e2 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
		int length = e2.size();
		Thread.sleep(2000);
		//e2.get(0).click();
		e2.get(length-1).click();
		Thread.sleep(5000);
		driver.close();

	}

}
