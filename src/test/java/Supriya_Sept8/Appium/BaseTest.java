package Supriya_Sept8.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;
	
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		//code to start Appium sever programmatically 
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//omkarthorat//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		
		
		UiAutomator2Options options = new  UiAutomator2Options();
		options.setDeviceName("SupriyaEmulator");
		options.setApp("//Users//omkarthorat//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), "duration", 2000 ));
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit(); 
		//service.stop();//stop server
	}
}
