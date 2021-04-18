package Com.Test.Nirali;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.utility;
import pageObjects.CartSummary;
import pageObjects.Login;
import pageObjects.MyAccount;
import pageObjects.ProductConfirmation;
import pageObjects.SignIn;
import pageObjects.SignOut;


public class Scenario1_OrderTshirt extends Base {
	
	public WebDriver driver;
	public static Logger logger= LogManager.getLogger(Base.class.getName());
	//data will be fetched from dataprovider get data for this testcase
	@Test(dataProvider = "getdata")
	public void orderTshirt(String username, String encodedpassword, String myAccountPageConfirmationText, String CartSummaryPageConfirmationText, String ProductConfirmationinCartSummary ) throws IOException {
		
		
		//Initialise driver - call to generic function in base class
		driver = initialiseDriver();
		logger.info("Driver Intialised");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Get global variable  url from properties file
		driver.get(prop.getProperty("url"));
		logger.info("Driver fetch url");
		
		//maximise the browser window
		driver.manage().window().maximize();
		
		//create object of sign in page object and call the function of SIGnin class
		SignIn SI = new SignIn(driver);
		SI.clickSignIn().click();
		logger.info("Click on Sign In button");

		//create object of Log in page object and call the function of login class
		Login LG = new Login(driver);
		//validate landed on login page
		assertTrue(LG.validate_landingon_loginPage().isDisplayed());
		logger.info("Verify landing on login Page");
		
		//Enter credentials and login into application
		LG.getUserName().sendKeys(username);		
		LG.getPassword().sendKeys(utility.decode(encodedpassword));
		LG.clickLogin().click();

		//create object of MyAccount page object and call the function of MyAccount class
		MyAccount MA = new MyAccount(driver);		
		assertEquals(MA.validate_landingon_myAccountPage().getText(),myAccountPageConfirmationText);
		logger.info("Verify landing on MyAccount page");
		
		
		MA.click_TshirtsMenu().click();
		assertTrue(MA.validate_ClickonTshirtsMenu().isDisplayed());
		logger.info("Verify landing on Tshirt selected page");
		
		
		//Use action class to hover on the webelement
		Actions act = new Actions(driver);
		act.moveToElement(MA.hover_onItemImage()).perform();
		MA.click_AddCart().click();		
		
		//define implicit timeout for 20 seconds for each step
		//proceed to chekcout
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ProductConfirmation PC =  new ProductConfirmation(driver);				
		//assertEquals(PC.validate_Shoppingcart_validationMessage().getText(),"Product successfully added to your shopping cart");
		PC.click_ProceedToCheckout().click();
		logger.info("Click on proceed to check out button");
		
		
		//confirm the product ordered in summary page
		CartSummary CS = new CartSummary(driver);
		assertEquals(CS.Validate_LandingOncartSummaryPage().getText(),CartSummaryPageConfirmationText);
		logger.info("Verify landing on cart summary page");
		
		
		assertEquals(CS.validate_ProductConfirmationinCartSummary().getText(),ProductConfirmationinCartSummary);
		logger.info("Verify product in Cart summary page ");
		//signout from the page
		SignOut SO = new SignOut(driver);
		SO.click_SignOut().click();
		assertTrue(SI.clickSignIn().isDisplayed());
		
	}
	
	
	//data for this text case is defined in this function
	@DataProvider(name = "getdata")
	public Object[][] getdata() throws IOException {

		

		return new Object[][] {{"krishnanm2006@gmail.com", "VGVzdEAxMjM0" , "MY ACCOUNT","01. Summary","Faded Short Sleeve T-shirts"}};

	}
	
	//method will runafter every test in this class
	@AfterTest
	public void teardown() {
		driver.quit(); //will close all the open browser by  driver
	}
	
	

}
