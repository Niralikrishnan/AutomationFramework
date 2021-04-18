package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Resources.Base;

public class MyAccount extends Base {
	
 public WebDriver driver;
 By we_headerText = By.xpath("//div[@id='center_column']/h1");
 By we_Tshirts = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a");
 By we_Tshirts_HeaderText = By.xpath("//div[@id='center_column']/h1/span[1]");
 By we_ItemImage = By.xpath("//a[@class='product_img_link']/img");
 By we_AddToCart = By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']/Span");
 By we_MyPersonalInformation = By.xpath("//ul[@class='myaccount-link-list']/li[4]/a");
 
 
 
	public MyAccount(WebDriver driver) {
		this.driver= driver;
	}
	

	public WebElement validate_landingon_myAccountPage() {
		return driver.findElement(we_headerText);
	}

	public WebElement click_TshirtsMenu() {
		
		return driver.findElement(we_Tshirts);
	}
	
	public WebElement validate_ClickonTshirtsMenu() {
		
		return driver.findElement(we_Tshirts_HeaderText);
	}
	
	public WebElement hover_onItemImage() {
		
		return driver.findElement(we_ItemImage);
	}
	
	
	public WebElement click_AddCart() {
		
		return driver.findElement(we_AddToCart);
	}
	
	
	public WebElement click_MyPersonalInformationbutton() {
		
		return driver.findElement(we_MyPersonalInformation);
	}
	
	
}
