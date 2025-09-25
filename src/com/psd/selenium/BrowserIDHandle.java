package com.psd.selenium;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserIDHandle {

	public static void main(String[] args) {
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("https://www.impactguru.com/");
		String title1 = driver1.getTitle();

		driver1.get("https://www.igfindia.org/");
		String title2 = driver1.getTitle();

		System.out.println(title1);
		System.out.println(driver1.getWindowHandle());
		System.out.println(title2);
		System.out.println(driver1.getWindowHandle());
		driver1.close();

	}

}
