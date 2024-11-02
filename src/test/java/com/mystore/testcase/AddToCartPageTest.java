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
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Loginpage;
import com.mystore.pageobject.Searchresultpage;


/**
 * 
 */
public class AddToCartPageTest extends BaseClass{
	
	IndexPage index;
	Loginpage loginPage;
	Homepage homePage;
	Accountcreationpage accountCreationPage;
	Searchresultpage searchResultPage; 
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	
	@Test(groups={"Regression","Sanity"})
	public void addToCartTest() throws Throwable {
		//Log.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		//Log.endTestCase("addToCartTest");
		
	}

}
