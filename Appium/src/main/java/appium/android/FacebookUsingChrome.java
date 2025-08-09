package appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class FacebookUsingChrome {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Basic Device + App Info
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:platformVersion", "11");
		capabilities.setCapability("appium:deviceName", "realme 5 pro");
		capabilities.setCapability("appium:udid", "35e153dd");
		capabilities.setCapability("appium:appPackage", "com.android.chrome");
		capabilities.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");

		// Appium/WebView Setup
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:autoGrantPermissions", true);
		capabilities.setCapability("appium:ensureWebviewsHavePages", true);
		capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);

		// Use correct path to downloaded ChromeDriver matching Chrome 138.0.7204.179
		capabilities.setCapability("appium:chromedriverExecutable", "C:\\Android Drivers\\chromedriver.exe");

		// Launch Appium session
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, capabilities);

		// Navigate to Google
		driver.get("https://www.google.com");
		Thread.sleep(7000);

		// Print available contexts
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
		    System.out.println("Available context: " + context);
		}

		// Try switching to WEBVIEW
		for (String context : contexts) {
		    if (context.toLowerCase().contains("webview")) {
		        System.out.println("Switching to context: " + context);
		        driver.context(context);
		        break;
		    }
		}

		// Ensure context switched
		System.out.println("Current context: " + driver.getContext());
		
		System.out.println("Page source:\n" + driver.getPageSource()); // Debug: what is visible?

		// Wait for DOM to be ready
		Thread.sleep(8000);

		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		    searchBox.sendKeys("Appium");
		} catch (Exception e) {
		    System.out.println("Element not found or interaction failed: " + e.getMessage());
		}

		// Optional cleanup
		// driver.quit();
	}
}
