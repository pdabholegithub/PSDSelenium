package com.psd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		//driver.get("https://www.impactguru.com");
		// -------- 1. Count iframes ----------
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total iframes on page: " + iframeCount);

        // -------- 2. Switch to iframe by index ----------
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//iframe"));
        System.out.println("Text inside iframe: " + text.getText());

        // -------- 3. Switch back to default content ----------
        driver.switchTo().defaultContent();

        // -------- 4. Switch using name or ID ----------
        driver.switchTo().frame("iframeResult");

        // -------- 5. Switch using WebElement ----------
        WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(innerFrame);

        System.out.println("Inside nested iframe");

        // -------- 6. Go back to parent frame ----------
        driver.switchTo().parentFrame();

        driver.quit();
    }
}
		
	

