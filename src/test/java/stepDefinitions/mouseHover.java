package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import Helper.browserFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class mouseHover extends browserFactory 
{
	WebDriver driver;
	
	@Given("^Open \"(.*?)\" and access the \"(.*?)\"$")
	public void open_and_access_the(String browser, String url) throws Throwable 
	{		
		//Open the browser and access application
		 driver=browserFactory.startBrowser(browser,url);
		 browserFactory bf=new browserFactory();
	}
	
	@When("^user mousehover on dress$")
	public void user_mousehover_on_dress() throws Throwable 
	{
		//Moving mouse control into Dresses lists
		Actions act= new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(Dressesmousecontrol).perform();
		Thread.sleep(5000);
		//Click on SummerDresses
		SummerDresses.click();				
	}

	@Then("^User should able to see Summer dress and click on it$")
	public void user_should_able_to_see_Summer_dress_and_click_on_it() throws Throwable 
	{
	    //Verify Summer Dresses with its title
		String title=driver.getTitle();
		System.out.println("PAge title is "+title);
		Assert.assertEquals("Summer Dresses - My Store",title);
		driver.quit();
	}
	
}
