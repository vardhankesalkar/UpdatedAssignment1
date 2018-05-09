package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class browserFactory {
		static WebDriver driver;
	
		//Page factory for signIn
		@FindBy(xpath=".//a[@class='login']")
		public static WebElement Signin;
		@FindBy(xpath=".//input[@id='email_create']")
		public static WebElement emailAddress;
		@FindBy(xpath=".//button[@id='SubmitCreate']")
		public static WebElement createanaccount;
		@FindBy(xpath=". //li[contains(text(),'Invalid email address.')]")
		public static WebElement emailerrormessage;  

		//Page factory for Mega Menu
		//@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
		//public static WebElement Dresses; 
		@FindBy(xpath=".//div[@id='block_top_menu']/ul/li[2]/a")
		public static WebElement Dressesmousecontrol;
		@FindBy(xpath=".//div[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")
		public static WebElement SummerDresses;
	
		//Page factory for Summer Dresses sorting
		
		@FindBy(xpath=".//div[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
		public static WebElement mouseOverImage1;
		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$28.98')]")
		public static WebElement image1Price;
		@FindBy(xpath=".//div[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
		public static WebElement mouseOverImage2;
		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$30.50')]")
		public static WebElement image2Price;
		@FindBy(xpath=".//a[@class='product_img_link']/following::img[2]")
		public static WebElement mouseOverImage3;
		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$16.40')]")
		public static WebElement image3Price;
		@FindBy(xpath=".//select[@id='selectProductSort']")
		public static WebElement SortBy;

		@FindBy(xpath=".//div[@id='center_column']//img[@alt='Printed Chiffon Dress']")
		public static WebElement afterSortmouseOverImage1;
		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$16.40')]")
		public static WebElement afterSortimage1Price;
		@FindBy(xpath=".//div[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
		public static WebElement afterSortmouseOverImage2;
		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$28.98')]")
		public static WebElement afterSortimage2Price;
		@FindBy(xpath=".//a[@class='product_img_link']/following::img[2]")
		public static WebElement afterSortmouseOverImage3;
 		@FindBy(xpath=".//div[@class='product-image-container']//span[contains(text(),'$30.50')]")
		public static WebElement afterSortimage3Price;
 		
 		//Page factory for AddTocart
 		@FindBy(xpath=".//*[@id='color_20'and@class='color_pick']")
		public static WebElement blueColorSquare;
 		@FindBy(xpath=".//button[@class='exclusive']")
		public static WebElement AddTocartButton;
 		
 		//Cart confirmation message locators
 		@FindBy(xpath=".//span[@class='cross']/following::h2")
		public static WebElement cartMessage;
 		@FindBy(xpath=".//span[@id='layer_cart_product_attributes']")
		public static WebElement cartColor;
 		@FindBy(xpath=".//span[@id='layer_cart_product_quantity']")
		public static WebElement cartQuantity;

 		//Page factory for Registration Page
 		@FindBy(xpath=".//input[@id='id_gender1']")
		public static WebElement GenderMr;
 		
 		@FindBy(xpath=".//input[@id='customer_firstname']")
		public static WebElement firstName;
 		@FindBy(xpath=".//input[@id='customer_lastname']")
		public static WebElement lastName;
 		@FindBy(xpath=".//input[@id='passwd']")
		public static WebElement password;
 		@FindBy(xpath=".//select[@id='days']")
		public static WebElement day;
 		@FindBy(xpath=".//select[@id='months']")
		public static WebElement month;
 		@FindBy(xpath=".//select[@id='years']")
		public static WebElement year;
 		@FindBy(xpath=".//input[@id='firstname']")
		public static WebElement address_firstName;
 		
 		@FindBy(xpath=".//input[@id='lastname']")
		public static WebElement address_lastName;
 		@FindBy(xpath=".//input[@id='company']")
		public static WebElement companyName;
 		@FindBy(xpath=".//input[@id='address1']")
		public static WebElement address1;
 		@FindBy(xpath=".//input[@id='address2']")
		public static WebElement address2;
 		@FindBy(xpath=".//input[@id='city']")
		public static WebElement city;
 		@FindBy(xpath=".//select[@id='id_state']")
		public static WebElement state;
 		@FindBy(xpath=".//input[@id='postcode']")
		public static WebElement postcode;
 		@FindBy(xpath=".//input[@id='phone_mobile']")
		public static WebElement mobile;
 		@FindBy(xpath=".//input[@id='alias']")
		public static WebElement alias;
 		@FindBy(xpath=".//button[@id='submitAccount']")
		public static WebElement Register;
 		
 		@FindBy(xpath=".//*[@id='center_column']/p")
		public static WebElement WelcomeMessage;
 		
 	
 		
 		//Initializing the Page Objects:
 		public browserFactory()
 		{
		PageFactory.initElements(driver, this);
 		}
	
	
 		public static WebDriver startBrowser(String browser, String urlname) {
		if(browser.equalsIgnoreCase("firefox"))
		{	 
			 System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}	
		else if(browser.equalsIgnoreCase("ie"))
		{			
			System.setProperty("webdriver.ie.driver", ".\\Driver\\IEDriverServer.exe");	
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();		 
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			DesiredCapabilities chromeCapabilities=DesiredCapabilities.chrome();
			chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new ChromeDriver();		 
		}	

		driver.get(urlname);
		driver.manage().window().maximize();
		return driver;
}
}