package com.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;

public class Homepage extends Base {

	public Homepage(){
	
		PageFactory.initElements(getdriver(), this);
	}
	
	//@FindBy(className="logout")
	//private WebElement signout;
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	/**
	 * @return the signout
//	 */
//	public WebElement getSignout() {
//		return signout;
//	}
//	
}
