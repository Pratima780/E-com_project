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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.Loginpage;
import com.mystore.utility.Log;

/**
 * 
 */
public class LoginPageTest extends BaseClass{
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
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class,groups= {"Smoke","sanity"})
	public void loginTest(String uname,String pswd)throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on sign in");
		loginPage=indexPage.clickOnSignIn();
		Log.info("enter user name and password");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		homePage=loginPage.login(uname, pswd,homePage);
		String actualURL=homePage.getCurrURL();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Sucess");
	   Log.endTestCase("loginTest");
	}

}
