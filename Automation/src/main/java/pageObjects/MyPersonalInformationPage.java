package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class MyPersonalInformationPage extends Base {

	public WebDriver driver;
	
	By we_UpdateName  = By.xpath("//input[@id='firstname']");	
	By we_Save = By.xpath("//button[@name='submitIdentity']");
	By we_MyPersonalInformationHeaderText = By.xpath("//div[@id='center_column']//h1");
	By we_currentpassword=By.xpath("//input[@id='old_passwd']");
	By we_newpassword=By.xpath("//input[@id='passwd']");
	By we_confirmpassword=By.xpath("//input[@id='confirmation']");
	By we_UpdateMessageCOnfirmation = By.xpath("//*[@id=\"center_column\"]/div/p");
	
	
	
	
	public MyPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement update_Username() {
		return driver.findElement(we_UpdateName);
	}

	
	public WebElement click_Save() {
		return driver.findElement(we_Save);
	}

	public WebElement set_currentpassword() {
		return driver.findElement(we_currentpassword);
	}
	public WebElement set_newpassword() {
		return driver.findElement(we_newpassword);
	}
	public WebElement set_confirmpassword() {
		return driver.findElement(we_confirmpassword);
	}

	public WebElement validate_LandingOnMyPersonalInformation() {
		
		return driver.findElement(we_MyPersonalInformationHeaderText);
	}
	
	public WebElement validate_UpdateMessageCOnfirmation() {
		
		return driver.findElement(we_UpdateMessageCOnfirmation);
	}

}
