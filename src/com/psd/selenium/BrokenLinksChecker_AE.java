package com.psd.selenium;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksChecker_AE {

	public static void main(String[] args) throws InterruptedException {

		// ✅ Set ChromeDriver path if not in PATH
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\path\\to\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// ✅ Open the website
		driver.get("https://automationedge.com/");
		Thread.sleep(3000);

		// ✅ Get all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + links.size());

		// ✅ Create CSV file
		String filePath = "BrokenLinksReport_AE.csv";
		try (FileWriter writer = new FileWriter(filePath)) {
			// Write header
			writer.append("URL,StatusCode,Result\n");

			for (WebElement link : links) {
				String url = link.getAttribute("href");

				if (url == null || url.isEmpty() || (!url.startsWith("http://") && !url.startsWith("https://"))) {
					System.out.println("⚠️ Skipping non-http link: " + url);
					writer.append(url).append(",,Skipped\n");
					continue;
				}

				try {
					HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();

					int responseCode = connection.getResponseCode();
					String result = (responseCode >= 400) ? "Broken" : "Valid";

					// ✅ Print to console
					System.out.println(url + " | " + responseCode + " | " + result);

					// ✅ Write to CSV
					writer.append(url).append(",").append(String.valueOf(responseCode)).append(",").append(result)
							.append("\n");

				} catch (IOException e) {
					System.out.println("⚠️ Exception for URL: " + url + " -> " + e.getMessage());
					writer.append(url).append(",,Exception\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
		System.out.println("✅ Report generated at: " + filePath);
	}
}