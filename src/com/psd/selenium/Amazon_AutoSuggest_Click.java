package com.psd.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_AutoSuggest_Click {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
		e1.sendKeys("shoe");
		Thread.sleep(2000);
		// 2 attribute back for x path in case of auto suggestion
		List<WebElement> e2 = driver.findElements(By.xpath("//div[@class='two-pane-results-container']/div/div"));
		int length = e2.size();
		Thread.sleep(2000);
		// e2.get(0).click();
		e2.get(length - 1).click();
		Thread.sleep(5000);
		driver.close();

	}

}
