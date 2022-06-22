package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Paymentpage extends Base{
	Elementaction action=new Elementaction();
	@FindBy(xpath="//a[@class='bankwire']")
	private WebElement bankwire;
	
	
	public Paymentpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public Ordersummarypage bankwire() {
		action.click(getdriver(), bankwire);
		return new Ordersummarypage();
	}
	
	
	

}
