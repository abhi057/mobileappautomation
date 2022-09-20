package org.fw.pageObjects.android;

import org.fw.resuableMethods.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotesHomePage extends AndroidActions {
	
	
	AndroidDriver driver;

	public NotesHomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id ='com.example.android.testing.notes.mock:id/fab_add_notes']")
	public WebElement addNotesBtn;
	// driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id
	// ='com.example.android.testing.notes.mock:id/fab_add_notes']"))

	public AddNewNotePage clickAddNoteBtn() {
		addNotesBtn.click();
		return new AddNewNotePage(driver);

	}
}
