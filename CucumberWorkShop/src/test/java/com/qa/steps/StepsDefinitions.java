package com.qa.steps;

import com.qa.util.Utilitiy;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDefinitions {
	Utilitiy uti = new Utilitiy();

	// loginFalse
	@Given("^I want to go to this website$")
	public void i_want_to_go_to_this_website() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.gotoWebSite();
	}

	@When("^I complete performance to the login form with invalid information$")
	public void i_complete_performance_to_the_login_form_with_invalid_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.performanceForm();
	}

	@Then("^I will see the error message$")
	public void i_will_see_the_error_message() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.checkTheError();
	}
	@And("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    uti.closeWebSite();
	}

	// loginFalseWithDataTable
	@When("^I complete performance to the login form as$")
	public void i_complete_performance_to_the_login_form_as(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		uti.performanceForm(arg1);
	}

	@Then("^I will see the error message as$")
	public void i_will_see_the_error_message_as(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		uti.checkTheErrorAs(arg1);
	}

	// loginFalseWithData \"([a-zA-Z]*)\"
	@When("^I want to write a username with \"([^\"]*)\"$")
	public void i_want_to_write_a_username_with(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.inputUserName(arg1);
	}

	@And("^I want to write a password with  \"([^\"]*)\"$")
	public void i_want_to_write_a_password_with(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.inputPassword(arg1);
	}

	@And("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.clickSubmitButton();
	}

	@Then("^I verify the \"([^\"]*)\" in step$")
	public void i_verify_the_in_step(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		uti.verifyError(arg1);
	}
	//Expecdia
	
	@Given("^I want to go to this \"([^\"]*)\"$")
	public void i_want_to_go_to_this(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.gotoWebSite(url);
	}

	@When("^I complete performance form with valid information$")
	public void i_complete_performance_form_with_valid_information() throws Throwable {
	    uti.completeForm();
	    
	}

	@Then("^I will see the message$")
	public void i_will_see_the_message() throws Throwable {
	    uti.seeMessage();
	}

	@When("^I complete performance form as$")
	public void i_complete_performance_form_as(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    uti.completeForm(table);
	}

	@Then("^I will see the message as$")
	public void i_will_see_the_message_as(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		uti.seeMessage(table);
	}

	@When("^I want to write a flying from with \"([^\"]*)\" and i click on \"([^\"]*)\"$")
	public void i_want_to_write_a_flying_from_with_and_i_click_on(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    uti.flyingFrom(arg1,arg2);
	}

	@When("^I want to write a flying to with \"([^\"]*)\" and i click on \"([^\"]*)\"$")
	public void i_want_to_write_a_flying_to_with_and_i_click_on(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.flyingTo(arg1,arg2);
	}

	@When("^I choise departing day \"([^\"]*)\" and select Departing with  \"([^\"]*)\"$")
	public void i_choise_departing_day_and_select_Departing_with(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.departing(arg1,arg2);
	}
	@When("^I choise returning day \"([^\"]*)\" and select Returning with  \"([^\"]*)\"$")
	public void i_choise_returning_departing_day_and_select_Returning_with(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.returning(arg1,arg2);
	}
	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.clickSearch();
	}

	@Then("^I verify the massage as$")
	public void i_verify_the_massage_as(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		uti.seeMessage(table);
	}
	
	
	@Given("^Navigate to expedia\\.com$")
	public void navigate_to_expedia_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.navigateto();
	}

	@Given("^Click on Flight button$")
	public void click_on_Flight_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.ClickonFlightButton();
	}

	@When("^Perform flight form$")
	public void perform_flight_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 uti.PerformFlightForm();
	}

	@Then("^Verify message$")
	public void verify_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.VerifyMessage();
	}
	@When("^Perform flight form with datatable$")
	public void perform_flight_form_with_datatable(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		uti.performFlight(arg1);
	}
	@Then("^Verify message with datatable$")
	public void verify_message_with_datatable(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		uti.VerifyMessage(table);
	}
}