package appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Caculator {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android"); // W3C-compliant
		capabilities.setCapability("appium:platformVersion", "11");
		capabilities.setCapability("appium:deviceName", "realme 5 pro");
		capabilities.setCapability("appium:udid", "35e153dd");
		capabilities.setCapability("appium:appPackage", "com.coloros.calculator");
		capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:autoGrantPermissions", true);
		capabilities.setCapability("appium:ensureWebviewsHavePages", true);
		// ✅ Important fix
		capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, capabilities);
		WebElement clearBtn=driver.findElement(By.id("com.coloros.calculator:id/clr"));
		clearBtn.click();
		WebElement digitSeven=driver.findElement(By.id("com.coloros.calculator:id/digit_7"));
		WebElement opAdd=driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		WebElement digitThree=driver.findElement(By.id("com.coloros.calculator:id/digit_3"));
		WebElement equals=driver.findElement(By.id("com.coloros.calculator:id/eq"));
		
		digitSeven.click();
		opAdd.click();
		digitThree.click();
		equals.click();
	}

}
