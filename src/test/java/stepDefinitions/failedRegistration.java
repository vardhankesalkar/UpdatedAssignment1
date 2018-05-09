package stepDefinitions;


import org.openqa.selenium.WebDriver;
import Helper.browserFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class failedRegistration extends browserFactory {
	WebDriver driver;
	@Given("^Open \"(.*?)\" browser and launch \"(.*?)\" address$")
	public void open_browser_and_launch_address(String browser, String url) throws Throwable 
	{	 //Open the browser and access application
		 driver=browserFactory.startBrowser(browser,url);
		 browserFactory bf=new browserFactory();
	}

	@When("^user enter the invalid email address \"(.*?)\"$")
	public void user_enter_the_invalid_email_address(String invalidemail) throws Throwable 
	{
		Thread.sleep(5000);
		//Click on Signin link from header
		Signin.click();
		Thread.sleep(10000);
		//Entering email address and click on Create Account button
		emailAddress.sendKeys(invalidemail);
		createanaccount.click();			
	}

	@Then("^user should get an error message$")
	public void user_should_get_an_error_message() throws Throwable 
	{
		Thread.sleep(5000); 
		 String errormessage = emailerrormessage.getText(); 
		 System.out.println("======================");
		 System.out.println("error message is "+ errormessage); 
		 //Verify invalid Email error message
		 Assert.assertEquals("Invalid email address.", errormessage);
		 driver.quit();
	}



}
