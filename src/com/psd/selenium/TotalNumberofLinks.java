package com.psd.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TotalNumberofLinks {
	@Test
	public void alllinks() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://grotechminds.com/");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int count = alllinks.size();
		System.out.println("Total links found: " + count);
		for (int i = 0; i < count; i++) {
			WebElement linkall = alllinks.get(i);
			String link = linkall.getAttribute("href");
			String text = linkall.getText();
			System.out.println(getOrdinal(i + 1) + " Link found is: " + link);
			System.out.println(" Link text is: " + text);
			
		}
		driver.quit();

	}

	// ---------- Helper method to convert number → First, Second, Third ----------
	private String getOrdinal(int number) {
		switch (number) {
		case 1:
			return "First";
		case 2:
			return "Second";
		case 3:
			return "Third";
		case 4:
			return "Fourth";
		case 5:
			return "Fifth";
		case 6:
			return "Sixth";
		case 7:
			return "Seventh";
		case 8:
			return "Eighth";
		case 9:
			return "Ninth";
		case 10:
			return "Tenth";
		default:
			return number + "th"; // For 11th, 12th, etc.
		}
	}

}
