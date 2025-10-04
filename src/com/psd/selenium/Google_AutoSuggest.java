package com.psd.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.name("q"));
		e1.sendKeys("Pune");
		Thread.sleep(2000);
		// 2 attribute back for x path in case of auto suggestion
		List<WebElement> e2 = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
		int length = e2.size();
		System.out.println("Total auto suggest options size is:" + length);
		System.out.println("Total auto suggest options are as below:");
		for (int i = 0; i < length; i++) {
			WebElement a1 = e2.get(i);
			String autosuggestion = a1.getText();
			System.out.println(autosuggestion);

		}

		driver.close();

	}

}
