package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.test.base.Base;
import com.test.util.Elementaction;

public class Ordersummarypage extends Base {
	
	Elementaction action=new Elementaction();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public Ordersummarypage() {
		PageFactory.initElements(getdriver(), this);
	}

	public Orderconfirmationpage clickOnconfirmOrderBtn() throws Throwable {
		Thread.sleep(2000);
		action.click(getdriver(), confirmOrderBtn);
		return new Orderconfirmationpage();
	}

}
