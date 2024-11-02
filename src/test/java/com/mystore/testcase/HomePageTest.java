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
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Loginpage;



/**
 * 
 */
public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	Loginpage loginPage;
	Homepage homePage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	
/*	@Test
	public void wishListTest (String uname, String pswd) throws Throwable {
		
		
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}*/
	
	@Test(groups= {"Smoke"})
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		//Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		//Log.endTestCase("orderHistoryandDetailsTest");
	}
	
}
