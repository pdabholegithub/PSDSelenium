package com.psd.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToAmazonRobust {

	public static void main(String[] args) {
		// ---------- Chrome options: small anti-detection tweaks ----------
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-blink-features=AutomationControlled");
		// (Optional) add user-agent or proxy if needed:
		// options.addArguments("user-agent=Mozilla/5.0 (...)");

		// ---------- Create driver (ensure chromedriver is on PATH or use
		// WebDriverManager) ----------
		ChromeDriver driver = new ChromeDriver(options);

		try {
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D155259813593%26hvpone%3D%26hvptwo%3D%26hvadid%3D774088017322%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D8922990009215391951%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062237%26hvtargid%3Dkwd-64107830%26hydadcr%3D14452_2429115%26gad_source%3D1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// ---------- Wait for an input element that looks like email/phone ----------
			// We'll try multiple locators (fallback). Use explicit wait for visibility.
			By[] candidateLocators = new By[] { By.id("ap_email_login"), // seen in some DOM variants
					By.id("ap_email"), // common id
					By.name("email"), // fallback by name
					By.xpath("//input[@type='email']") // more general fallback
			};

			WebElement emailInput = null;
			for (By locator : candidateLocators) {
				try {
					emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					System.out.println("Found email input using: " + locator);
					break;
				} catch (Exception ignored) {
					// continue to next locator
				}
			}

			if (emailInput == null) {
				System.err.println("Could not find an email input field. Exiting.");
				return;
			}

			// ---------- Enter the username/email (use a dummy or test account) ----------
			String testEmail = "abc@amazon.in";
			emailInput.sendKeys(testEmail);
			System.out.println("Entered email (stopped before password): " + testEmail);

			// ---------- Click continue if present ----------
			try {
				By continueBtnBy = By.id("continue");
				WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtnBy));
				continueBtn.click();
				System.out.println("Clicked Continue.");
			} catch (Exception e) {
				System.out.println("Continue button not found/clickable — maybe page auto-submits. Proceeding.");
			}

			// ---------- Detect common anti-bot / captcha indicators ----------
			boolean captchaPresent = false;
			By[] captchaLocators = new By[] { By.id("auth-captcha-image"), // common captcha id
					By.xpath("//div[contains(@class,'captcha')]"), By.xpath("//iframe[contains(@src,'captcha')]") };
			for (By cLoc : captchaLocators) {
				try {
					WebElement c = driver.findElement(cLoc);
					if (c != null && c.isDisplayed()) {
						captchaPresent = true;
						System.out.println("CAPTCHA-like element detected via: " + cLoc);
						break;
					}
				} catch (NoSuchElementException ignored) {
				}
			}

			if (captchaPresent) {
				System.out.println("CAPTCHA present — stopping to avoid automated login attempts.");
				return; // safe stop
			}

			// ---------- Wait for password field to appear, but DON'T submit password
			// ----------
			try {
				By passwordBy = By.id("ap_password");
				WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBy));
				if (passwordField != null) {
					System.out.println(
							"Password field detected. For safety, script will stop here and not enter the password.");
				}
			} catch (Exception e) {
				System.out.println(
						"Password field not visible yet (could be multi-step flow or blocked). Stopping safely.");
			}

			// Optionally: take a screenshot or log more info here (omitted).
		} finally {
			// Clean up
			driver.quit();
			System.out.println("Driver quit — finished.");
		}
	}
}