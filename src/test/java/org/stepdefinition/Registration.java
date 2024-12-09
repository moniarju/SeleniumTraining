package org.stepdefinition;

import java.util.Map;

import org.bas.BaseClass;
import org.pojo.SigninPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.*;
public class Registration extends BaseClass {
	SigninPojo s;
	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() {
		launchBrowser();
		windowMaximize();
	    
	}

	@When("To launch url of fb application")
	public void to_launch_url_of_fb_application() {
		launchUrl("https://en-gb.facebook.com/");
	
	}

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() {
		s= new SigninPojo();
		clickBtn(s.getCreateNewAccount());
	  
	}

	@When("To pass firstname in firstname text box")
	public void to_pass_firstname_in_firstname_text_box(DataTable d) throws InterruptedException {
		Thread.sleep(3000);
		Map<String, String> m = d.asMap (String.class,String.class);
		s= new SigninPojo(); 
		passText(m.get("firstname3"),s.getFirstNmeTxtBox());
	}

	@When("To pass secondname in secondname text box")
	public void to_pass_secondname_in_secondname_text_box() {
		s= new SigninPojo(); 
		passText("Arjunan", s.getSecondNameTxtBox());
	}

	@When("To pass mobileno or email in email text box")
	public void to_pass_mobileno_or_email_in_email_text_box(DataTable d) {
		
		
		s= new SigninPojo();
		passText("Monishama26@gmail.com", s.getMobileNumberorEmailTextBox());
	}

	@When("To create new password using new password text box")
	public void to_create_new_password_using_new_password_text_box() {
		s= new SigninPojo();  
		passText("12345", s.getNewPassword());
	}

	@Then("To close the chrome browser")
	public void to_close_the_chrome_browser() {
		s= new SigninPojo();
		//closeEntireBrowser();
	}


	
	
}
