package abstractComponents;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageClasses.CartPage;

public class AbstractReuseMethods {

	public WebDriver driver;

	public AbstractReuseMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class='YUhWwv']")
	WebElement cart;
	
	public CartPage goToCart() {
		cart.click();
		return new CartPage(driver);
	}

	public void waitTillElementVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitTillPresenceOfElementLocated(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	
	public void waitTillElementToBeClickable(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void switchToChildWindow() {
		
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		Set<String> winId = driver.getWindowHandles();
		if (parentId.equals(driver.getWindowHandle())) {
			for (String id : winId) {
				System.out.println(id);
				if (!(id.equals(parentId))) {
					driver.switchTo().window(id);

				}
			}
		}

	}
	
	public int priceConvert(WebElement price) {
		
		String value=price.getText();
		String modifiedvalue = value.replaceAll("[^a-zA-Z0-9\\s]", "");
		int numValue = Integer.parseInt(modifiedvalue);
		return numValue;
	}

}
