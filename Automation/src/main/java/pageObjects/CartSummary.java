package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class CartSummary extends Base {

	
	public WebDriver driver;
	//located webelement with the help of xpath and return the object
	By we_ValidateLandingOncartSummaryPage = By.xpath("//*[@id=\"order_step\"]/li[1]/span");
	By we_ProductConfirmation_inCartSummary = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[2]/p/a");
	By we_ProductQuantityConfirmationincartSummary = By.xpath("//table[@id='cart_summary']/tbody/tr[1]/td[5]/input[2]");
	
	public CartSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Validate_LandingOncartSummaryPage() {
		return driver.findElement(we_ValidateLandingOncartSummaryPage);
	}

	public WebElement validate_ProductConfirmationinCartSummary() {
		return driver.findElement(we_ProductConfirmation_inCartSummary);
	}
	
	
	public WebElement validate_ProductQuantityConfirmationincartSummary() {
		return driver.findElement(we_ProductQuantityConfirmationincartSummary);
	}
}
