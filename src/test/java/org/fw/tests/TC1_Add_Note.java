package org.fw.tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.fw.pageObjects.android.AddNewNotePage;
import org.fw.pageObjects.android.AllNotesPage;
import org.fw.pageObjects.android.NotesHomePage;
import org.fw.testUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class TC1_Add_Note extends AndroidBaseTest {
	
//	NotesHomePage notesHomePage ;
//	AddNewNotePage addNewNotepage; 
//	AllNotesPage allNotesPage ;

//	@BeforeMethod
//	public void preSetup() {
//		// screen to particular page
////		Activity activity = new Activity("page class", null);
////		driver.startActivity(activity);
//
//	}

	@Test(dataProvider = "getData", groups = { "Smoke" })
	public void add_note_test(String noteTitle, String noteDesc) throws InterruptedException, ParseException {

		System.out.println("Note title inside test method: " + noteTitle);
		System.out.println("Note desc inside test method: " + noteDesc);
		
		//For Page Object Model with page factory implementation
        //notesHomePage.clickAddNoteBtn();
  
		driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id ='com.example.android.testing.notes.mock:id/fab_add_notes']")).click();
		driver.findElement(By.id("com.example.android.testing.notes.mock:id/add_note_title")).sendKeys(noteTitle);
		Thread.sleep(2000);
		driver.findElement(By.id("com.example.android.testing.notes.mock:id/add_note_description")).sendKeys(noteDesc);
		Thread.sleep(2000);
		driver.findElement(By.id("com.example.android.testing.notes.mock:id/fab_add_notes")).click();
		Thread.sleep(2000);
		Boolean noteAdded = driver.findElement(By.xpath("(//android.widget.FrameLayout)[1]")).isDisplayed();
		Assert.assertTrue(noteAdded);
		if (noteAdded) {
			System.out.println("Added note verified successsfully");
		} else {
			System.out.println("Added note not verified successsfully");
		}

	}

	@Test
	public void add_note_test2()

	{
     
	}

	@DataProvider
	public Object[][] getData() throws IOException, ParseException {
		String[] noteData = getTestData();
		return new Object[][] { { noteData[0], noteData[1] } };
	}

}
