package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SignIn {
	
	public WebDriver driver;
	
	
	By signIn = By.xpath("//a[@class='login']");
	;

	
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement clickSignIn() {
		return driver.findElement(signIn);
		
	}
	

	
	
	

}
