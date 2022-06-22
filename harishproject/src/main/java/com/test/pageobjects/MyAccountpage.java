package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;
import com.test.util.Elementaction;

public class MyAccountpage extends Base{
	public MyAccountpage() {

		PageFactory.initElements(getdriver(), this);
	}
	Elementaction action=new Elementaction();
	@FindBy(id="search_query_top")
	private WebElement search;
	
	@FindBy(name="submit_search")
	private WebElement searchbtn;

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	
	
	public void search(String name) {
		action.sendkeys(search, name);
	}
	public void searchbtn() {
		action.click(getdriver(), searchbtn);
		
	}
	
	public Addtocartpage productresult() {
		action.click(getdriver(), productResult);
		return new Addtocartpage();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
