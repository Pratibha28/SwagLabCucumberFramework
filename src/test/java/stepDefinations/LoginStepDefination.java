package stepDefinations;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import dataProvider.DataProvider;
import hooks.Hooks;
import hooks.Hookss;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import pages.LoginPage;

public class LoginStepDefination extends BaseClass {
	
	String actualUrl=prop.getProperty("actualUrl");
	String loginErrorMsg=prop.getProperty("loginmessage");
	  String loginMsg;
    LoginPage loginPage;
	@Given("I launch the browser and navigate to the login page")
	public void i_launch_the_browser_and_navigate_to_the_login_page() {
		
    	loginPage = new LoginPage();
	}
	
	   @When("I log in using Excel credentials")
	    public void i_log_in_using_excel_credentials() {
	        String username = Hookss.get("Username");
	        String password = Hookss.get("Password");
	        loginPage.loginWithValidCredential(username, password);
	    }

	@Then("I validate the login result")
	public void i_validate_the_login_result() {
		
		String expectedUrl=loginPage.validateDashboard();
		Assert.assertEquals(actualUrl, expectedUrl);
	   	}
	
	//invalid login scenario
	


@When("Entered invalid username & password")
public void entered_invalid_username_password() {
	String username = Hookss.get("Username");
    String password = Hookss.get("Password");
    System.out.printf(username, password);
   loginMsg = loginPage.loginWithInvalidCredential(username, password);
  System.out.println(loginMsg);
}
@Then("Validate the error message")
public void validate_the_error_message() {
   Assert.assertEquals(loginMsg, loginErrorMsg);
}


}
