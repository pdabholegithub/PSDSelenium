package com.psd.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	static void validatinglinks(String link) throws IOException {
		try {
			URL u1 = new URL(link);
			HttpURLConnection h2 = (HttpURLConnection) u1.openConnection();
			if (h2.getResponseCode() == 200 || h2.getResponseCode() == 201) {
				System.out.println("Link is Valid " + link);
				System.out.println("Here is the status code for it " + h2.getResponseCode());
				System.out.println("Here is the response message for it " + h2.getResponseMessage());
			} else {
				System.out.println("Link is Not Valid " + link);
				System.out.println("Here is the status code for it " + h2.getResponseCode());
				System.out.println("Here is the response message for it " + h2.getResponseMessage());
			}
		} catch (NullPointerException n1) {
			System.out.println("Link was Null, I handled");

		} catch (MalformedURLException n1) {
			System.out.println("Link was Null, I handled");

		}
		 catch (ClassCastException n1) {
				System.out.println("Link was Null, I handled");

			}
	}

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.navigate().to("https://grotechminds.com/");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int count = alllinks.size();
		System.out.println("Total links found: " + count);
		for (int i = 0; i < count; i++) {
			WebElement linkall = alllinks.get(i);
			String link = linkall.getAttribute("href");
			String text = linkall.getText();
			System.out.println(getOrdinal(i + 1) + " Link found is: " + link);
			// System.out.println(" Link text is: " + text);
			validatinglinks(link);

		}
		driver.quit();

	}

	// ---------- Helper method to convert number → First, Second, Third ----------
	private static String getOrdinal(int number) {
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
