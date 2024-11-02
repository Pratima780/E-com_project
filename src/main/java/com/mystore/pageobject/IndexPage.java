package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
//import org.openqa.selenium.support.PageFactory;

//import com.mystore.actiondriver.Action;
//import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public Loginpage clickOnSignIn() throws Throwable {
		//action.fluentWait(getDriver(), signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		Thread.sleep(3000);
		return new Loginpage();
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public Searchresultpage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		//Thread.sleep(8000);
		Action.scrollByVisibilityOfElement(getDriver(), searchButton);
		//Thread.sleep(5000000);
		Action.click(getDriver(), searchButton);
		//Thread.sleep(3000000);
		return new Searchresultpage();
	}
	
	
	
	
}
