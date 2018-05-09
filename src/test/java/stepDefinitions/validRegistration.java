package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Helper.browserFactory;
public class validRegistration extends browserFactory 
{
	WebDriver driver;
	
	@Given("^Open \"(.*?)\" and start \"(.*?)\"$")
	public void open_and_start(String browser, String url) throws Throwable 
	{
		//Open the browser and access application
		 driver=browserFactory.startBrowser(browser,url);
		 browserFactory bf=new browserFactory(); 
    }

	@When("^user enter valid \"(.*?)\" and click on Create account button$")
	public void user_enter_valid_and_click_on_Create_account_button(String validemail) throws Throwable {
		//Click on Signin link from header
		Signin.click();
		//Entering email address and click on Create Account button
		emailAddress.sendKeys(validemail);
		createanaccount.click();
	}
	
	@When("^User enters Details to Registration$")
	public void User_enters_Details_to_Registration(DataTable details) throws Throwable {
		Thread.sleep(5000);	
		//Write the code to handle Data Table
				List<List<String>> data = details.raw();
		//Selecting Mr 
		GenderMr.click();
		//Entering first name
		firstName.sendKeys(data.get(1).get(0));
		//Entering last name
		lastName.sendKeys(data.get(1).get(1));	
		//Entering Password 
		password.sendKeys(data.get(1).get(2));
		//Selecting date
		WebElement date = day;
	    Select se1 = new Select(date);
	    se1.selectByValue("1");	
	    //Selecting month
	    Thread.sleep(5000);
		//Selecting month 
		WebElement month1 = month;
	    Select se2 = new Select(month1);
	    se2.selectByValue("5");
		
		//Selecting year 
		Thread.sleep(5000);
	    WebElement year1 = year;
		Select se3 = new Select(year1);
	    se3.selectByValue("1985");
			        
	    //Enerting Address details including first name, last name, company name, address 1 and 2, city, state
		Thread.sleep(5000);
		address_firstName.sendKeys(data.get(1).get(3));
			        
		address_lastName.sendKeys(data.get(1).get(4));
			        
		companyName.sendKeys(data.get(1).get(5));
			        
		address1.sendKeys(data.get(1).get(6));
			        
		address2.sendKeys(data.get(1).get(7));
			        
		city.sendKeys(data.get(1).get(8));
			        
			        
	    WebElement state1 = state;
	    Select se4 = new Select(state1);
	    se4.selectByValue("5");
			        
	    postcode.sendKeys(data.get(1).get(9));
			        
	    mobile.sendKeys(data.get(1).get(10));
			        
	    alias.sendKeys(data.get(1).get(11));
			        
	    //Click on Register button
	    Register.click();
			        
	}
	
		
		
	@Then("^User should be able to register successfully$")
	public void user_should_be_able_to_register_successfully() throws Throwable {
	    Thread.sleep(5000); 
	    String welcomemessage1 =WelcomeMessage.getText(); 
	    System.out.println("Welcome message is:" + welcomemessage1);
	   	Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",WelcomeMessage.getText());		
	    driver.quit();  
	}

}
