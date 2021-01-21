import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class TestListView {

	AndroidDriver driver;

	@Before
	public void setup() throws Exception {
		DesiredCapabilities desiredcap = new DesiredCapabilities();
		desiredcap.setCapability("platformName", "Android");
		desiredcap.setCapability("platformVersion", "9");
		desiredcap.setCapability("deviceName", "Android Emulator");
		desiredcap.setCapability("automationName", "UiAutomator2");
		desiredcap.setCapability("app",
				"https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredcap);

	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testListView() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement listdemo = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("List Demo")));
		listdemo.click();
		Thread.sleep(3000);
		
		//simulation du doigt
		PointerInput doigt = new PointerInput(Kind.TOUCH, "doigt");
		Interaction movetostart = doigt.createPointerMove(Duration.ZERO, Origin.viewport(), 520, 1530);
		Interaction pressdown = doigt.createPointerDown(MouseButton.LEFT.asArg());
		Interaction movetoend = doigt.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), 520, 500);
		Interaction pressup = doigt.createPointerUp(MouseButton.LEFT.asArg());
		
		//sequence des moviments
		Sequence swip = new Sequence(doigt, 0);
		swip.addAction(movetostart);
		swip.addAction(pressdown);
		swip.addAction(movetoend);
		swip.addAction(pressup);
		
		driver.perform(Arrays.asList(swip));
		
		WebElement cloudelement = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Stratus")));
		cloudelement.click();
		Thread.sleep(3000);
	}
	
	
} 
