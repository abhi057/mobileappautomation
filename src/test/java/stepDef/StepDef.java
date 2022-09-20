package stepDef;

import io.cucumber.java.en.*;

public class StepDef {

	@Given("I am on NoteHome page")
	public void i_am_on_note_home_page() {
		System.out.println("To add steps");
	}

	@When("click on Add notes and enter details")
	public void click_on_add_notes_and_enter_details() {
		System.out.println("To add steps");
	}

	@Then("the note should be added")
	public void the_note_should_be_added() {
		System.out.println("To add steps");
	}

}
