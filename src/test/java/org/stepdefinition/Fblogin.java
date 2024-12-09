package org.stepdefinition;

import org.bas.BaseClass;
import org.pojo.FbLoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Fblogin extends BaseClass{
	FbLoginPojo f;
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
		launchBrowser();
		windowMaximize();
	   
	}

	@When("To launch the url of the facebook application")
	public void to_launch_the_url_of_the_facebook_application() {
	  launchUrl("https://en-gb.facebook.com/");
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		 f = new FbLoginPojo();
		passText("Selenium inmakes@gmail.com", f.getEmail());
	  
	}

	@When("To pass invalid password in password field")
	public void to_pass_invalid_password_in_password_field() {
		 f = new FbLoginPojo();
		passText("1234", f.getPassword());
	  	
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		f= new  FbLoginPojo();
		clickBtn(f.getLoginbutton());
	
	}

	@When("To check wheather navigate to the home page or not")
	public void to_check_wheather_navigate_to_the_home_page_or_not() {
		System.out.println("to check the credentials");
	  
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	   
	}



}
