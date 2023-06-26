package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractReuseMethods;

public class OrderPalcePage extends AbstractReuseMethods{
	
	
	public WebDriver driver;
	
	public OrderPalcePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[@class='_2-K-ro']")
	List<WebElement> list;
	
	public int personalDetails() {
		return list.size();
	}
	

	

	

}
