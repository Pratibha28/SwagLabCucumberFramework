package stepDefinations;

import org.testng.Assert;

import baseclass.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginStepDefination extends BaseClass {
<<<<<<< HEAD
	String actualUrl;
	String loginErrorMsg;
	
	  String loginMsg;
    LoginPage loginPage;
	@Given("I launch the browser and navigate to the login page")
	public void i_launch_the_browser_and_navigate_to_the_login_page() {
		actualUrl=Hookss.get("actual");
		 loginErrorMsg=Hookss.get("errorMessage");
		 System.out.println(actualUrl+"%%%%"+loginErrorMsg);
    	loginPage = new LoginPage();
	}
	
	   @When("I log in using Excel credentials")
	    public void i_log_in_using_excel_credentials() {
	        String username = Hookss.get("Username");
	        String password = Hookss.get("Password");
	       
	        loginPage.loginWithValidCredential(username, password);
	    }
=======

	String actualUrl;
	String loginErrorMsg;
	String loginMsg;
	LoginPage loginPage;

	@Given("I launch the browser and navigate to the login page")
	public void i_launch_the_browser_and_navigate_to_the_login_page() {

		loginPage = new LoginPage();
	}

	@When("I log in using Excel credentials")
	public void i_log_in_using_excel_credentials() {
		String username = Hooks.get("Username");
		String password = Hooks.get("Password");
		// actualUrl= Hookss.get("actul");

		loginPage.loginWithValidCredential(username, password);
	}
>>>>>>> ef7c2522505d1d780f603c2bec9a02e229baa338

	@Then("I validate the login result")
	public void i_validate_the_login_result() {
		actualUrl = ConfigReader.getProperties("actual");
		System.out.println(actualUrl + "#############");
		String expectedUrl = loginPage.validateDashboard();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	// invalid login scenario

	@When("Entered invalid username & password")
	public void entered_invalid_username_password() {
		String username = Hooks.get("Username");
		String password = Hooks.get("Password");
		loginErrorMsg = Hooks.get("errorMessage");
	

		loginMsg = loginPage.loginWithInvalidCredential(username, password);

<<<<<<< HEAD
@When("Entered invalid username & password")
public void entered_invalid_username_password() {
	String username = Hookss.get("Username");
    String password = Hookss.get("Password");
    System.out.printf(username, password);
   loginMsg = loginPage.loginWithInvalidCredential(username, password);
  //System.out.println(loginMsg);
}
@Then("Validate the error message")
public void validate_the_error_message() {
   Assert.assertEquals(loginMsg, loginErrorMsg);
}
=======
	}
>>>>>>> ef7c2522505d1d780f603c2bec9a02e229baa338

	@Then("Validate the error message")
	public void validate_the_error_message() {
		

		Assert.assertEquals(loginErrorMsg, loginMsg);
	}

}
