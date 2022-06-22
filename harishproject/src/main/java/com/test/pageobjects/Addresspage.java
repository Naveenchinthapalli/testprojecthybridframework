package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.test.base.Base;
import com.test.util.Elementaction;

public class Addresspage extends Base{
	
	
	
Elementaction action= new Elementaction();
	
	@FindBy(xpath="//span[(text()='Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	public Addresspage() {
		PageFactory.initElements(getdriver(), this);
	}

	public Shippingpage clickOnCheckOut() throws Throwable {
		Thread.sleep(3000);
		action.click(getdriver(), proceedToCheckOut);
		return new Shippingpage();
	}

}
