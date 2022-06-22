package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.test.base.Base;
import com.test.util.Elementaction;

public class Shippingpage extends Base{
	Elementaction action=new Elementaction();
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public Shippingpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void checkTheTerms() throws Throwable {
		action.click(getdriver(), terms);
	}
	
	public Paymentpage clickOnProceedToCheckOut() throws Throwable {
		action.click(getdriver(), proceedToCheckOutBtn);
		return new Paymentpage();
	}

}



