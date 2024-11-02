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
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Loginpage;

/**
 * 
 */
public class AccountCreationPageTest extends BaseClass {

	IndexPage indexPage;
	Loginpage loginPage;
	Homepage homePage;
	Accountcreationpage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}
	
	@Test(groups= {"Sanity"})
	public void verifyCreateAccountPageTest() throws Throwable {
		//Log.startTestCase("verifyCreateAccountPageTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount("ghf@gmail.com");
		boolean result=accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		//Log.endTestCase("verifyCreateAccountPageTest");
	}
}
