package testClasses;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage;
import testComponents.BaseTest;

public class FunctionalTest extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void searchBox(HashMap<String, String> input) {
		
		HomePage hp = lp.clickCancelBtn();
		hp.searchItem(input.get("item"));
		boolean isShow = hp.productResult();
		Assert.assertTrue(isShow);
		
	}
	
	@Test(dataProvider = "getData", priority = 1)
	public void sortByPriceLToH(HashMap<String, String> input) {
		
		HomePage hp = lp.clickCancelBtn();
		hp.searchItem(input.get("item"));
		hp.clickOnPriceLowToHigh();
		boolean isEqual = hp.isSortByPriceLowToHigh();
		Assert.assertTrue(isEqual);
		
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void sortByPriceHToL(HashMap<String, String> input) throws InterruptedException {
		
		HomePage hp = lp.clickCancelBtn();
		hp.searchItem(input.get("item"));
		hp.clickOnPriceHighToLow();
		Thread.sleep(2000);
		boolean isEqual = hp.isSortByPriceHighToLow();
		Assert.assertTrue(isEqual);
		
	}

}
