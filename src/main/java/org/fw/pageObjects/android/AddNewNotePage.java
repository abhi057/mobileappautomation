package org.fw.pageObjects.android;

import org.fw.resuableMethods.AndroidActions;
import org.fw.resuableMethods.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddNewNotePage extends AndroidActions {

	AndroidDriver driver;



	public AddNewNotePage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.example.android.testing.notes.mock:id/add_note_title")
	private WebElement notesTitle;

	@AndroidFindBy(id = "com.example.android.testing.notes.mock:id/add_note_description")
	private WebElement notesDesc;

	@AndroidFindBy(id = "com.example.android.testing.notes.mock:id/fab_add_notes")
	private WebElement OkBtn;
	
	

	public void enterDesc(String noteDesc) {
		notesTitle.sendKeys(noteDesc);

	}

	public AllNotesPage clickAddNoteBtn() {
		OkBtn.click();
		return new AllNotesPage(driver);

	}

}
