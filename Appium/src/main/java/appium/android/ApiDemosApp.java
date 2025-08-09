package appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ApiDemosApp {

	 public static AndroidDriver driver;
	    public static void main(String[] args) throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();

	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appium:platformVersion", "11");
	        caps.setCapability("appium:deviceName", "realme 5 pro");
	        caps.setCapability("appium:udid", "35e153dd");

	        // ✅ Use the launcher activity first
	        caps.setCapability("appium:appPackage", "io.appium.android.apis");
	        caps.setCapability("appium:appActivity", ".ApiDemos");
	        caps.setCapability("appium:automationName", "UiAutomator2");
	        // ✅ Prevent Realme restrictions from breaking the session
	        caps.setCapability("appium:ignoreHiddenApiPolicyError", true);
	        caps.setCapability("appium:noReset", true);
	        caps.setCapability("appium:fullReset", false);

	        caps.setCapability("appium:newCommandTimeout", 3600);
	        caps.setCapability("appium:connectHardwareKeyboard", true);

	       

			// Launch Appium session
			URL url = new URL("http://127.0.0.1:4723/");
			driver = new AndroidDriver(url, caps);

	        System.out.println("✅ Session started!");
	        
	       WebElement peopleNames= driver.findElement(By.xpath("//*[@text='People Names']"));
	       peopleNames.click();
	       System.out.println("✅ People names clicked!");
	       List<WebElement> listofNames=driver.findElements(By.xpath("//*[@class='android.widget.TextView']"));
	       System.out.println("✅ gET ALL names clicked!");
	       for(WebElement person:listofNames)
	       {
	    	   String textValue=person.getAttribute("text");
	    	   
	    	   if(!textValue.equalsIgnoreCase("Dog Names"))
	    	   {
	    		   System.out.println(textValue);
	    	   }
	    	   else {
	    		   break;
	    	   }
	       }
	    }

}
