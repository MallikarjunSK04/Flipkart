package testClasses;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.CartPage;
import pageClasses.HomePage;
import pageClasses.OrderPalcePage;
import testComponents.BaseTest;

public class E2ETest extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String,String> input) {
		HomePage hp = lp.clickCancelBtn();
		String productAdded=hp.searchItem(input.get("item"));
		String text = hp.searchShowing();
		Assert.assertTrue(text.contains(input.get("text")));
		
		CartPage cp = hp.addToCart();
		String cartProduct = cp.productInCart();
		boolean isProd=productAdded.contains(cartProduct);
		Assert.assertTrue(isProd);
		
		OrderPalcePage op = cp.placeOrder();
		int size = op.personalDetails();
		Assert.assertEquals(size, 3);
		
	}

}
