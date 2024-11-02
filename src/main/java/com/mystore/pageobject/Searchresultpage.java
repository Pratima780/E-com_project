/**
 * 
 */
package com.mystore.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class Searchresultpage extends BaseClass {

Action action= new Action();
     @FindBy(name="submit_search")
     private WebElement Submitbutton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public Searchresultpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		Action.click(getDriver(), Submitbutton);
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
