package com.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Indexpage extends Base{

	public Elementaction action= new Elementaction();
	
	public Indexpage() {

		PageFactory.initElements(getdriver(), this);
	}
	@FindBy(xpath = "//a[contains(text(),'Sign in')]") 
	private WebElement signInBtn;
	
	@FindBy(xpath="search_query_top")
	private WebElement search;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;

	/**
	 * @param search the search to set
	 */
	public void setSearch(String key) {
		search.sendKeys(key);
	
	} 
	public boolean validatelogo() {
		return action.isdisplayed(getdriver(),myStoreLogo);
	}
	public String geturl() {
		return action.getPageTitle();
	}
	
	public Signin signinlink() throws InterruptedException {
		Thread.sleep(2000);
		action.click(getdriver(), signInBtn);
		return new Signin();
	}
	
	
	
	
	
	
	
	
	
}
