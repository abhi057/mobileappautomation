package org.fw.pageObjects.android;

import org.fw.resuableMethods.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AllNotesPage extends AndroidActions {

	AndroidDriver driver;

	public AllNotesPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.FrameLayout)[1]")
	private WebElement addedNotes;

	public void addedNotes() {
		addedNotes.isDisplayed();
	}

}