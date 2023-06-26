package pageClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractReuseMethods;

public class HomePage extends AbstractReuseMethods{
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	WebElement submit;
	
	@FindBy(xpath="//span[@class='_10Ermr']")
	WebElement showing;
	
	@FindBy(css="div._4rR01T")
	WebElement product;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(css=".B_NuCI")
	WebElement productName;
	
	@FindBy(xpath="//div[text()='Price -- Low to High']")
	WebElement sortLtoH;
	
	@FindBy(xpath="//div[text()='Price -- High to Low']")
	WebElement sortHtoL;
	
	@FindBy(css="div[class='_3tbKJL'] div[class='_30jeq3 _1_WHN1']")
	List<WebElement> prices;

	By compareBy = By.xpath("//label[text()='Compare']"); 
	By sortLtoHBy = By.cssSelector("div[data-id='MOBGA5VADB6VMBBP']");
	By addToCompareBy = By.xpath("//span[text()='Add to Compare']");
	By pricesBy = By.cssSelector("div[class='_3tbKJL'] div[class='_30jeq3 _1_WHN1']");
	By showingBy = By.xpath("//span[@class='_10Ermr']");
	
	public String searchItem(String item) {
		searchBox.sendKeys(item);
		submit.click();
		return product.getText();
	}
	
	public String searchShowing() {
		return showing.getText();
	}
	
	public CartPage addToCart(){
		product.click();
		switchToChildWindow();
		waitTillElementVisible(compareBy);
		addToCartBtn.click();
		return goToCart();
	}
	
	public boolean productResult() {
		return showing.isDisplayed();
	}
	
	public void clickOnPriceLowToHigh(){
		sortLtoH.click();
		waitTillElementVisible(sortLtoHBy);
	}
	
	public void clickOnPriceHighToLow(){
		sortHtoL.click();
	}
	
	
	
			
	public boolean isSortByPriceLowToHigh() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(WebElement price:prices) {
			int numValue = priceConvert(price);
			list.add(numValue);
			list1.add(numValue);
		}
		
		Collections.sort(list);
		boolean isEqual = list1.equals(list);
		return isEqual;
		
	}
	
	public boolean isSortByPriceHighToLow() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(WebElement price:prices) {
			int numValue = priceConvert(price);
			list.add(numValue);
			list1.add(numValue);
		}
		Collections.sort(list, Comparator.reverseOrder() );
		boolean isEqual = list1.equals(list);
		return isEqual;
		
	}

}
