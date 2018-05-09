package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import Helper.browserFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addProductAndVerify extends browserFactory
{
	WebDriver driver;
	
	@Given("^Launch \"(.*?)\" browser and access \"(.*?)\"$")
	public void launch_browser_and_access(String browser, String url) throws Throwable {
	    
		//Open the browser and access application
		 driver=browserFactory.startBrowser(browser,url);
		 browserFactory bf=new browserFactory(); 
			
	}

	@When("^User select the dress change the color and add to cart$")
	public void user_select_the_dress_change_the_color_and_add_to_cart() throws Throwable {
	    
		Actions act = new Actions(driver);
		
		//Moving mouse control into Dresses lists
		act.moveToElement(Dressesmousecontrol).perform();		
		Thread.sleep(5000);	
		
		//Click on SummerDresses
		SummerDresses.click();
		
		//Scroll the window
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollBy(0,700)");	
		
		//Select Blue color		
		blueColorSquare.click();
		
		//Click on Blue color
		blueColorSquare.click();
			
		Thread.sleep(5000);		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		
		//click on Add to Cart
		AddTocartButton.click();	
		Thread.sleep(5000);
		
	}

	@Then("^user should see the same product, color and quantity in cart summery page$")
	public void user_should_see_the_same_product_color_and_quantity_in_cart_summery_page() throws Throwable {
	    
		Thread.sleep(5000);
		
		//Verify product with Blue Quantity Total);
        String message = cartMessage.getText();
		System.out.println("Success message is:" + message);
		Assert.assertEquals("Product successfully added to your shopping cart",cartMessage.getText());
				
		String getcolor=cartColor.getText();
		System.out.println("Selected color is : "+ getcolor);
		Assert.assertEquals("Blue, S", getcolor);
		
		String qty = cartQuantity.getText();
		System.out.println("Selected quantity is : "+ qty);
		Assert.assertEquals("1", qty);
		
		driver.quit();
			
	}	
	
}
