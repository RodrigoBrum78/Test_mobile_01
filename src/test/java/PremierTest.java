import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class PremierTest {
	
	@Test
	public void test1() throws Exception {
		
		DesiredCapabilities desiredcap = new DesiredCapabilities();
		desiredcap.setCapability("platformName", "Android");
		desiredcap.setCapability("platformVersion", "9");
		desiredcap.setCapability("deviceName", "Android Emulator");
		desiredcap.setCapability("automationName", "UiAutomator2");
		desiredcap.setCapability("app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk");
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredcap);
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Screen")));
		//WebElement login = driver.findElement(MobileBy.AccessibilityId("Login Screen"));
		System.out.println(login.getAttribute("content-desc"));
		Thread.sleep(3000);
		login.click();
		WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("username")));
		username.sendKeys("alice"); //pwd - mypassword
		WebElement password = driver.findElement(MobileBy.AccessibilityId("password"));
		password.sendKeys("mypassword");
		WebElement btn = driver.findElement(MobileBy.AccessibilityId("loginBtn"));
		btn.click();
		Thread.sleep(3000);
		//driver.quit();
		
		
	}
}
