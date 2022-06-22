package com.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;
import com.test.util.Elementaction;

public class Orderconfirmationpage extends Base {
	
	Elementaction action=new Elementaction();
	
	public Orderconfirmationpage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;
	

	public boolean confirmmsg() throws InterruptedException {
		Thread.sleep(4000);
	boolean text=action.isdisplayed(getdriver(), confirmMessag);
		return text;
	}
}
