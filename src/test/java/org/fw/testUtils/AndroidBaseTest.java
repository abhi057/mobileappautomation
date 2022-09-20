package org.fw.testUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.fw.pageObjects.android.NotesHomePage;
import org.fw.resuableMethods.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public NotesHomePage notesHomePage;

	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//fw//properties//data.properties");
		prop.load(fis);

		// uncomment the below to start appium server automatically
		// String port = prop.getProperty("port");
		// service = startAppiumServer(ipAddress,Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName")); // emulator
		
		// for real device
		// options.setDeviceName("Android Device");
		
		//for hybrid app
		// options.setChromedriverExecutable("//Users//Abhishek//documents//chromedriver// 11"); 
		
		options.setApp(System.getProperty("user.dir") + "//src//test//java//org//fw//testResources//app-mock-debug.apk");

		driver = new AndroidDriver(new URL(prop.getProperty("url")), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //  notesHomePage = new NotesHomePage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
//      service.stop();
	}

}
