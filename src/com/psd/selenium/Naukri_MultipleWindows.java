package com.psd.selenium;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Naukri_MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=16201&err=1");
		driver.manage().window().maximize();
		WebElement e1 = driver.findElement(By.xpath("//button[@type='button']"));
		e1.click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> i1 = id.iterator();
		String parentid = i1.next();
		String childid = i1.next();
		System.out.println(parentid);
		System.out.println(childid);
		driver.switchTo().window(childid);
		WebElement e2 = driver.findElement(By.id("identifierId"));
		e2.sendKeys("pinkeshr009@gmail.com");

		Thread.sleep(1000);
		driver.close();

	}

}
