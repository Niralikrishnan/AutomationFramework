package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class SignOut extends Base{

public WebDriver driver;

By we_SignOut = By.xpath("//a[@class='logout']");

public SignOut(WebDriver driver) {
		this.driver=driver;
	}


public WebElement click_SignOut() {
	return driver.findElement(we_SignOut);
}


}
