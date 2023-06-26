package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractReuseMethods;

public class CartPage extends AbstractReuseMethods{
	
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_2-uG6-']")
	WebElement items;
	
	@FindBy(xpath="//span[text()='Place Order']")
	WebElement placeOrder;
	
	public String productInCart(){
		return items.getText();
	}
	
	public OrderPalcePage placeOrder() {
		placeOrder.click();
		return new OrderPalcePage(driver);
	}
	

}
