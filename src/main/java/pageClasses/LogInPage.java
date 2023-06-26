package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractReuseMethods;

public class LogInPage extends AbstractReuseMethods {
	
	public WebDriver driver;
	public LogInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement cancel;
	
	
	
	public HomePage clickCancelBtn() {
		cancel.click();
		return new HomePage(driver);
	}
	
	
	public void goTo(String URL) {
		driver.get(URL);
	}
	

}
