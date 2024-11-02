package com.mystore.pageobject;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
public class Loginpage extends BaseClass{
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy (id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public Loginpage() {
		PageFactory.initElements(getDriver(), this);
}
	
	public Homepage login(String uname, String pswd, Homepage homePage) throws Throwable {
		//Action.scrollByVisibilityOfElement(driver, userName);
		//Thread.sleep(80000);
		Action.type(userName, uname);
		//Thread.sleep(400);
		Action.type(password, pswd);
		//Thread.sleep(500);
		Action.click(getDriver(), signInBtn);
		//Thread.sleep(200);
		//homePage=new Homepage();
		return new Homepage();
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		//Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public Accountcreationpage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);
		return new Accountcreationpage();
	}

	
}
