package com.psd.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class BrowserLaunchNew2 {

	public static void main(String[] args) {
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("https://www.impactguru.com/");
		String title1 = driver1.getTitle();

		driver1.get("https://www.igfindia.org/");
		String title2 = driver1.getTitle();

		System.out.println(title1);
		System.out.println(title2);

		// SafariDriver driver3 = new SafariDriver();
		// FirefoxDriver driver4 = new FirefoxDriver();
		driver1.close();

	}

}
