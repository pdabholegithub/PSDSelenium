package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart_HoverOver {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.xpath("(//span[.='Fashion'])[2]"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(e1).perform();
		Thread.sleep(2000);
		WebElement e2 = driver.findElement(By.xpath("(//object/a)[4]"));
		a1.moveToElement(e2).perform();
		Thread.sleep(2000);
		WebElement e3 = driver.findElement(By.linkText("Men's Sports Shoes"));
		e3.click();
		Thread.sleep(2000);		
		driver.close();

	}

}
