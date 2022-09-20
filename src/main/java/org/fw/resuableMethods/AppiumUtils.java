package org.fw.resuableMethods;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class AppiumUtils {

	public AppiumDriverLocalService service;

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

		// convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}

//	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
//	{
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains((ele),"text" , "Cart"));
//	}

	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		// 1. capture and place in folder //2. extent report pick file and attach to
		// report

	}

	/*This method makes a GET call using RestAssured and JsonPath and fetches Name(Title, Firstname and LastName) 
	 * and registration date . Then converts the registration date to required format 
	 */
	public static String[] getTestData() throws ParseException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://randomuser.me";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/api");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String title = jsonPathEvaluator.get("results[0].name.title");
		String firstName = jsonPathEvaluator.get("results[0].name.first");
		String lastName = jsonPathEvaluator.get("results[0].name.last");

		String noteTitle = title + firstName + lastName;

		System.out.println("--------------------Note Title : " + noteTitle);

		String regDate = jsonPathEvaluator.get("results[0].registered.date");

		// convert date format
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date = dateFormat.parse(regDate);// You will get date object relative to server/client timezone wherever it
												// is parsed
		DateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z"); // put specific format
		String dateStr = formatter.format(date);
		String noteDesc = dateStr;
		
		System.out.println("--------------------Note Desc : " + noteDesc);

		String[] data = new String[2];
		data[0] = noteTitle;
		data[1] = noteDesc;
		
		return data;
	}

}
