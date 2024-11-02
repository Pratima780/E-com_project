package com.mystore.testcase;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
//import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
     
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Throwable {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();

	}

	@Test(groups= {"Smoke"})
	public void verifyLogo() throws Throwable {
		// Logo.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		// Log.endTestCase("verifyLogo");
	}

	@Test(groups= {"Smoke"})
	public void verifyTitle() {
		//Log.startTestCase("verifyTitle");
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Shop");
		//Log.endTestCase("verifyTitle");
	}
}
