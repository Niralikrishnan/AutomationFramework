package Com.Test.Nirali;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;
import Resources.utility;
import pageObjects.Login;
import pageObjects.MyAccount;
import pageObjects.MyPersonalInformationPage;
import pageObjects.SignIn;
import pageObjects.SignOut;

public class Scenario2_UpdatePersonalInformationInMyAccount extends Base {
	
	public WebDriver driver;
	@Test(dataProvider = "getdata")
	public void UpdatePersonalInformationInMyAccount(String username, String encodedpassword, String myAccountPageConfirmationText, String updatedusername, String MyPersonalinformationPageConfirmation, String UpdatemessageConfirmation) throws IOException {
		//Initialise driver - call to generic function in base class
		driver = initialiseDriver();
		
		//Get global variable  url from properties file
		driver.get(prop.getProperty("url"));
		
		//maximise the browser window
		driver.manage().window().maximize();
		
		//Click sign in button
		SignIn SI = new SignIn(driver);
		SI.clickSignIn().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Dnter credentials and login to application
		Login LG = new Login(driver);
		assertTrue(LG.validate_landingon_loginPage().isDisplayed());		
		LG.getUserName().sendKeys(username);		
		LG.getPassword().sendKeys(utility.decode(encodedpassword));
		LG.clickLogin().click();
		
		//verify landint to My account page and click on Mypersonal Information button
		MyAccount MA = new MyAccount(driver);		
		assertEquals(MA.validate_landingon_myAccountPage().getText(),myAccountPageConfirmationText);
		MA.click_MyPersonalInformationbutton().click();
		
		
		//verify landing to My peronsla Information Page and Update everytime new username and current and old paswprd a
		MyPersonalInformationPage MP = new MyPersonalInformationPage(driver); 
		assertEquals(MP.validate_LandingOnMyPersonalInformation().getText(),MyPersonalinformationPageConfirmation);
		MP.update_Username().clear();		
		MP.update_Username().sendKeys(updatedusername+utility.random());
		MP.set_currentpassword().sendKeys(utility.decode(encodedpassword));
		MP.set_newpassword().sendKeys(utility.decode(encodedpassword));
		MP.set_confirmpassword().sendKeys(utility.decode(encodedpassword));
		MP.click_Save().click();
		
		assertEquals(MP.validate_UpdateMessageCOnfirmation().getText(),UpdatemessageConfirmation);
		//signout application
		SignOut SO = new SignOut(driver);
		SO.click_SignOut().click();
		assertTrue(SI.clickSignIn().isDisplayed());
		
		
	}
	
	

	@DataProvider(name = "getdata")
	public Object[][] getdata() throws IOException {
		return new Object[][] {{"krishnanm2006@gmail.com", "VGVzdEAxMjM0" , "MY ACCOUNT","Nirali" , "YOUR PERSONAL INFORMATION","Your personal information has been successfully updated."}};

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}

