package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Helper.browserFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class priceSorting extends browserFactory 
{
 WebDriver driver;
 	@Given("^Open \"(.*?)\"  and access \"(.*?)\"$")
 	public void open_and_access(String browser, String url) throws Throwable 
	{
		//Open the browser and access application
	 driver=browserFactory.startBrowser(browser,url);
	 browserFactory bf=new browserFactory(); 
	}

	@When("^User navigate to Summer dresses and select Price Lowest first in sort by$")
	public void user_navigate_to_Summer_dresses_and_select_Price_Lowest_first_in_sort_by() throws Throwable
	{
		//Moving mouse control into Dresses lists
		Actions act = new Actions(driver);
		act.moveToElement(Dressesmousecontrol).perform();	
		Thread.sleep(5000);
		//Click on SummerDresses
		SummerDresses.click();	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0,500)");

	}

	@Then("^user should see the product as per selected sorting order$")
	public void user_should_see_the_product_as_per_selected_sorting_order() throws Throwable {
	    //Get and store  prices of Casual Dresses Evening Dresses And Summer Dresses		
        Actions act= new Actions(driver);
		act.moveToElement(mouseOverImage1).perform();
		String dprice1=image1Price.getText();
		
		act.moveToElement(mouseOverImage2).perform();
		String dprice2=image2Price.getText();
		
		act.moveToElement(mouseOverImage3).perform();
		String dprice3=image3Price.getText();
		
		//Store all prices in List
		List<String> displayedPrice = new ArrayList<String>();
		displayedPrice.add(dprice1);
		displayedPrice.add(dprice2);
		displayedPrice.add(dprice3);
		// before sorting the list values are
	    System.out.println(displayedPrice);
	    // sort the list
	    Collections.sort(displayedPrice);
	    //After sorting the list values are
	    System.out.println(displayedPrice);
		 
	    //Click on Sort By And select Price:lowest first
	    WebElement dropdown = SortBy;
		Select se1 = new Select(dropdown);
	  	se1.selectByValue("price:asc");
	  	Thread.sleep(5000);
	  	
	  	act.moveToElement(afterSortmouseOverImage1).perform();
		String aprice1=afterSortimage1Price.getText();
		Thread.sleep(5000);
		
		act.moveToElement(afterSortmouseOverImage2).perform();
		String aprice2=afterSortimage2Price.getText();
		Thread.sleep(5000);
		
		act.moveToElement(afterSortmouseOverImage3).perform();
		String aprice3=afterSortimage3Price.getText();
		Thread.sleep(5000);
		
		List<String> actualPrice = new ArrayList<String>();
		actualPrice.add(aprice1);
		actualPrice.add(aprice2);
		actualPrice.add(aprice3);
		
		 System.out.println(actualPrice);
		 
		 for(int i=0;i<displayedPrice.size();i++) {
			    if(actualPrice.get(i).contains(displayedPrice.get(i))) {
			        System.out.println("Product verified");
			    }else {
			        System.out.println("Product verification failed"+actualPrice.get(i));
			    }
			}	
		driver.quit();		
	}	
}
