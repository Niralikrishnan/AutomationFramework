package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class Login extends Base {
	
	public WebDriver driver;
	By userName = By.xpath("//input[@id='email']");
	By passWord  = By.xpath("//input[@id='passwd']");
	By login  = By.xpath("//button[@id='SubmitLogin']");
	By cart = By.xpath("//a[@title='View my shopping cart']");
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserName() {
		return driver.findElement(userName);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(passWord);
		
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
		
	}	
	
	public WebElement validate_landingon_loginPage() {
		return driver.findElement(cart);
		
	}

}
