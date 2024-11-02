/**
 * 
 */
package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.Accountcreationpage;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Loginpage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummary;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.Searchresultpage;
import com.mystore.pageobject.ShippingPage;

/**
 * 
 */
public class EndToEndTest extends BaseClass {
	
	IndexPage index;
	Loginpage loginPage;
	Homepage homePage;
	Accountcreationpage accountCreationPage;
	Searchresultpage searchResultPage; 
	AddToCartPage addToCartPage;
	 OrderPage orderPage;
	  AddressPage addressPage;
		ShippingPage shippingPage;
		 PaymentPage paymentPage;
		 OrderSummary orderSummary;
		 OrderConfirmationPage orderConfirmationPage;
	
		 @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	@Test(groups= {"Regression"})
	public void endToEndTest() throws Throwable {
		//Log.startTestCase("endToEndTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		//Log.endTestCase("endToEndTest");
	}

	
	

}
