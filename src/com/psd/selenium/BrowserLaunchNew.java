package com.psd.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class BrowserLaunchNew {

	public static void main(String[] args) {
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("https://www.impactguru.com/");
		String title1 = driver1.getTitle();
		System.out.println(title1);

		EdgeDriver driver2 = new EdgeDriver();
		driver2.get("https://www.igfindia.org/");
		String title2 = driver2.getTitle();
		System.out.println(title2);

		// SafariDriver driver3 = new SafariDriver();
		// FirefoxDriver driver4 = new FirefoxDriver();
		driver1.quit();
		driver2.quit();

	}

}
