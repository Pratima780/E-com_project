package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManger;

//import ch.qos.logback.core.joran.action.Action;

//import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * @author Hitendra: BaseClass is used to load the config file and Initialize 
 * WebDriver
 *  
 */
public class BaseClass {
	public static Properties prop;
   // public static WebDriver driver; 
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadconfig() throws IOException {
		ExtentManger.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			System.out.println("super consturctor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			//System.out.println(" driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	//loadConfig method is to load the configuration
	

	/*public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get(null);
	}*/
     
	public static void launchApp(String browserName) throws Throwable {
		 //String browserName = prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
		   WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 1000);
		Action.pageLoadTimeOut(getDriver(), 20000);
		getDriver().get(prop.getProperty("url"));
		
		
		//Maximize the screen
		/*getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}*/
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManger.endReport();
	}
	
		
	
}