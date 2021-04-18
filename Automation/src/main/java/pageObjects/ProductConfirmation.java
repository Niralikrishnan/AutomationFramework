package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class ProductConfirmation extends Base {

	public WebDriver driver;
	
	By we_Shoppingcart_validationMessage = By.xpath("//div[@id='layer_cart']/div[1]/div[1]/h2");
	
	By we_ProceedToCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	
	public ProductConfirmation(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement validate_Shoppingcart_validationMessage() {
		return driver.findElement(we_Shoppingcart_validationMessage);
	}
	
	public WebElement click_ProceedToCheckout() {
		return driver.findElement(we_ProceedToCheckout);
	}
}
